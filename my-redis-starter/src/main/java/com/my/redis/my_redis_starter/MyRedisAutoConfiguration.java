package com.my.redis.my_redis_starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 
 * @Description 
 *	�Զ���������
 * @author lt
 *
 */
@Configuration
@ConditionalOnClass(MyRedisProperties.class)// ������MyRedisPropertiesʱ�Ž���ɨ��
@EnableConfigurationProperties(MyRedisProperties.class) // �������԰󶨣�����ǰ�౻ɨ��ʱ���Ż�ȥ����MyRedisPropertiesʵ��������applicaton.priperties�ж�Ӧ�����ԣ�Ȼ��ע��Spring����
public class MyRedisAutoConfiguration {

	/**
	 * 
	 * @Description 
	 *	��Ϊע��@Bean ���౻ɨ��ʱ��Ҳ��ɨ��÷���������ʵ��ע��Spring����
	 *	����myRedisProperties����ͨ��@EnableConfigurationProperties(MyRedisProperties.class)ע���
	 *		MyRedisProperties��ʵ��
	 *	ͨ��myRedisProperties��ȡ��JedisPool
	 *	����JedisTempleteʵ�����������ӳظ�����
	 *	���ش�����JedisTempleteʵ������Ϊע��@Bean�����ԻὫ��ע��SPring��������Ӧ��ΪJedisTemplete
	 *	
	 * @param myRedisProperties
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(name = "jedisTemplete")
	public JedisTemplete jedisTemplete(MyRedisProperties myRedisProperties) {
		JedisTemplete jedisTemplete = new JedisTemplete();
		
		jedisTemplete.setJedisPool(myRedisProperties.getJedisPool());
		return jedisTemplete;
	}
}
