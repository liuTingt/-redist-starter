package com.my.redis.my_redis_starter;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/***
 * 
 * @Description 
 *	Redis����ģ����
 * @author lt
 *
 */
public class JedisTemplete {

	private JedisPool jedisPool;

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
	/**
	 * 
	 * @Description 
	 *	��ȡredisʵ��
	 * @return
	 */
	public Jedis getJedis() {
		try {
			if(jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/***
	 * �ͷ�jedis��Դ
	 * @Description 
	 *
	 * @param jedis
	 */
	public void close(final Jedis jedis) {
		if(jedis != null) {
			jedis.close();
		}
	}
	
	public String getValue(String key) {
		return getJedis().get(key);
	}
}
