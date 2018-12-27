package com.terminal.client.task;

import java.util.List;

import com.terminal.client.entity.TaskEntity;
import com.terminal.client.redis.RedisMQHandler;

public class TerminalClientTask {
	public static void startTask(List<TaskEntity> taskList) {
		for (TaskEntity task : taskList) {
			startTask(task, "psub");
		}
	}

	public static void startTask(TaskEntity taskEntity, String subscribeType) {
		System.out.println(taskEntity.getChannel());
		Thread task = new Thread(new Tasker(new RedisMQHandler(), subscribeType, taskEntity.getChannel()),
				taskEntity.getName());
		task.start();
	}
}
