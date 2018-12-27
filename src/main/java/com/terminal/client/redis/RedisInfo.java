package com.terminal.client.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisInfo {
	static String host;

	static String password;

	public String getHost() {
		return host;
	}

	@Value("${common.redis.host}")
	public void setHost(String host) {
		RedisInfo.host = host;
	}

	public String getPassword() {
		return password;
	}

	@Value("${common.redis.password}")
	public void setPassword(String password) {
		RedisInfo.password = password;
	}

}
