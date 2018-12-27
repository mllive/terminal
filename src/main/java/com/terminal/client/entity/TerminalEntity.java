package com.terminal.client.entity;

public class TerminalEntity extends TerminalBase {

	@Override
	public String getSubscribeByProvinceAndPlatform(PlatformEntity platform) {
		return getProvince() + ".*." + platform.getCode();
	}

	@Override
	public String getSubscribe(PlatformEntity platform) {
		return getProvince() + "." + getCity() + "." + getCounty() + "." + platform.getCode() + ".client";
	}

}
