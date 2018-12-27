package com.terminal.client.redis;

import redis.clients.jedis.JedisPubSub;

public class RedisMQHandler extends JedisPubSub {

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println("接收到一条推流消息，准备推流：" + Thread.currentThread().getName() + " " + message);
	}

	@Override
	// 接收到消息后进行分发执行
	public void onMessage(String channel, String message) {
		if ("push".equals(channel)) {
			System.out.println("接收到一条推流消息，准备推流：" + Thread.currentThread().getName() + " " + message);
		} else if ("close".equals(channel)) {
			System.out.println("接收到一条关闭消息，准备关闭应用：" + Thread.currentThread().getName() + " " + message);
		}
		System.out.println("接收到一条推流消息，准备推流：" + Thread.currentThread().getName() + " " + message);
	}
}
