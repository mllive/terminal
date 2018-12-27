package com.terminal.client.entity;

import java.util.List;

public abstract class TerminalBase {
	String id;
	String province;
	String city;
	String county;
	String ip;
	String backPath;

	List<PlatformEntity> platforms;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBackPath() {
		return backPath;
	}

	public void setBackPath(String backPath) {
		this.backPath = backPath;
	}

	public List<PlatformEntity> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<PlatformEntity> platforms) {
		this.platforms = platforms;
	}

	@Override
	public String toString() {
		return "TerminalBase [id=" + id + ", province=" + province + ", city=" + city + ", county=" + county + "]";
	}

	/**
	 * 根据省和平台名称订阅(省.*.平台code)
	 * 
	 * @return
	 */
	public abstract String getSubscribeByProvinceAndPlatform(PlatformEntity platform);

	/**
	 * 根据终端平台订阅(省.市.县.平台code.client)
	 * 
	 * @return
	 */
	public abstract String getSubscribe(PlatformEntity platform);

	/**
	 * 根据终端订阅(省.市.县.终端ID)
	 * 
	 * @return
	 */
	public String getSubscribeByTerminal() {
		return getProvince() + "." + getCity() + "." + getCounty() + "." + getId();
	}

}
