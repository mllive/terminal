package com.terminal.client.entity;

public class TaskEntity {
	String name;
	String channel;

	public TaskEntity(String name, String channel) {
		super();
		this.name = name;
		this.channel = channel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}
