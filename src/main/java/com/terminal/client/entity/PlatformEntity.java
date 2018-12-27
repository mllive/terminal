package com.terminal.client.entity;

public class PlatformEntity {
	String code;
	String name;
	String tomcatRoot;
	String port;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTomcatRoot() {
		return tomcatRoot;
	}

	public void setTomcatRoot(String tomcatRoot) {
		this.tomcatRoot = tomcatRoot;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}
