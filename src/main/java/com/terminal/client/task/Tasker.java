package com.terminal.client.task;

import com.terminal.client.redis.RedisMQ;

import redis.clients.jedis.JedisPubSub;

public class Tasker implements Runnable {
	private String[] channel = null;// 监听的消息通道
	private JedisPubSub jedisPubSub = null;// 消息处理任务
	private String subscribeType = null;// 订阅类型

	public Tasker(JedisPubSub jedisPubSub, String subscribeType, String... channel) {
		this.jedisPubSub = jedisPubSub;
		this.subscribeType = subscribeType;
		this.channel = channel;
	}

	@Override
	public void run() {
		// 监听channel通道的消息
		RedisMQ.subscribe(jedisPubSub, subscribeType, channel);
	}

}