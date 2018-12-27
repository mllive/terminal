package com.terminal.client.redis;

import com.terminal.common.utils.redis.JedisPoolUtil;

import redis.clients.jedis.BinaryJedisPubSub;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

public class RedisMQ {
	/**
	 * 推入消息到redis消息通道
	 * 
	 * @param String
	 *            channel
	 * @param String
	 *            message
	 */
	public static Long publish(String channel, String message) {
		JedisPool jedisPool = null;
		Jedis jedis = null;
		try {
			jedisPool = JedisPoolUtil.getJedisPoolInstance(RedisInfo.host, RedisInfo.password);
			jedis = jedisPool.getResource();
			return jedis.publish(channel, message);
		} finally {
			jedis.close();
		}
	}

	/**
	 * 推入消息到redis消息通道
	 * 
	 * @param byte[]
	 *            channel
	 * @param byte[]
	 *            message
	 */
	public Long publish(byte[] channel, byte[] message) {
		JedisPool jedisPool = null;
		Jedis jedis = null;
		try {
			jedisPool = JedisPoolUtil.getJedisPoolInstance(RedisInfo.host, RedisInfo.password);
			jedis = jedisPool.getResource();
			return jedis.publish(channel, message);
		} finally {
			jedis.close();
		}

	}

	/**
	 * 监听消息通道
	 * 
	 * @param jedisPubSub
	 *            - 监听任务
	 * @param channels
	 *            - 要监听的消息通道
	 */
	public static void subscribe(BinaryJedisPubSub jedisPubSub, byte[]... channels) {
		JedisPool jedisPool = null;
		Jedis jedis = null;
		try {
			jedisPool = JedisPoolUtil.getJedisPoolInstance(RedisInfo.host, RedisInfo.password);
			jedis = jedisPool.getResource();
			jedis.psubscribe(jedisPubSub, channels);
		} finally {
			jedis.close();
		}
	}

	/**
	 * 监听消息通道
	 * 
	 * @param jedisPubSub
	 *            - 监听任务
	 * @param channels
	 *            - 要监听的消息通道
	 */
	public static void subscribe(JedisPubSub jedisPubSub, String subscribe, String... channels) {
		JedisPool jedisPool = null;
		Jedis jedis = null;
		try {
			jedisPool = JedisPoolUtil.getJedisPoolInstance(RedisInfo.host, RedisInfo.password);
			jedis = jedisPool.getResource();
			if (subscribe.equals("sub")) {
				jedis.subscribe(jedisPubSub, channels);
			} else if (subscribe.equals("psub")) {
				jedis.psubscribe(jedisPubSub, channels);
			}
		} finally {
			// JedisPoolUtil.release(jedisPool, jedis);
			jedis.close();
		}
	}
}
