package com.terminal.client.service;

import java.util.ArrayList;
import java.util.List;

import com.terminal.client.entity.PlatformEntity;
import com.terminal.client.entity.TaskEntity;
import com.terminal.client.entity.TerminalEntity;
import com.terminal.client.task.TerminalClientTask;

public class TerminalService {

	public TerminalEntity gTerminalEntity(String terminalId) {
		List<TerminalEntity> list = new ArrayList<>();

		// 测试数据，终端1
		TerminalEntity entity1 = new TerminalEntity();
		entity1.setId("t1");
		entity1.setProvince("hebei");
		entity1.setCity("chengde");
		entity1.setCounty("luanping");
		entity1.setIp("1.1.1.1");
		entity1.setBackPath("e:\\bak\\t1");
		List<PlatformEntity> platforms1 = new ArrayList<>();
		// 终端1 平台1
		PlatformEntity platform11 = new PlatformEntity();
		platform11.setCode("p11");
		platform11.setTomcatRoot("//p11");
		platform11.setPort("8888");
		platforms1.add(platform11);
		// 终端1 平台2
		PlatformEntity platform12 = new PlatformEntity();
		platform12.setCode("p12");
		platform12.setTomcatRoot("//p12");
		platform12.setPort("9999");
		platforms1.add(platform12);
		entity1.setPlatforms(platforms1);

		// 测试数据，终端2
		TerminalEntity entity2 = new TerminalEntity();
		entity2.setId("t2");
		entity2.setProvince("hebei");
		entity2.setCity("chengde");
		entity2.setCounty("longhua");
		entity2.setIp("2.2.2.2");
		entity2.setBackPath("e:\\bak\\t2");
		List<PlatformEntity> platforms2 = new ArrayList<>();
		// 终端1 平台1
		PlatformEntity platform21 = new PlatformEntity();
		platform21.setCode("p11");
		platform21.setTomcatRoot("//p11");
		platform21.setPort("8888");
		platforms2.add(platform21);
		// 终端1 平台2
		PlatformEntity platform22 = new PlatformEntity();
		platform22.setCode("p12");
		platform22.setTomcatRoot("//p12");
		platform22.setPort("9999");
		platforms2.add(platform22);
		entity2.setPlatforms(platforms2);

		list.add(entity1);
		list.add(entity2);

		for (TerminalEntity terminalEntity : list) {
			if (terminalEntity.getId().equals(terminalId)) {
				return terminalEntity;
			}
		}
		return null;
	}

	public void subscribeMessage(String terminalId) {
		TerminalEntity terminal = gTerminalEntity(terminalId);
		List<PlatformEntity> platforms = terminal.getPlatforms();

		List<TaskEntity> subscribeList = new ArrayList<>();
		for (PlatformEntity platformEntity : platforms) {
			// 单个终端
			String subChannel1 = terminal.getSubscribe(platformEntity);
			// 省内终端，某平台
			String subChannel2 = terminal.getSubscribeByProvinceAndPlatform(platformEntity);

			subscribeList.add(new TaskEntity(terminal.toString(), subChannel1));
			subscribeList.add(new TaskEntity(terminal.toString(), subChannel2));

		}
		// 终端服务器
		String subChannel3 = terminal.getSubscribeByTerminal();
		subscribeList.add(new TaskEntity(terminal.toString(), subChannel3));

		TerminalClientTask.startTask(subscribeList);
	}
}
