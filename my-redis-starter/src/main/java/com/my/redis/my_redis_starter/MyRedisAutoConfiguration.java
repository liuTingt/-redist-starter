package com.my.redis.my_redis_starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 
 * @Description 
 *	自动化配置类
 * @author lt
 *
 */
@Configuration
@ConditionalOnClass(MyRedisProperties.class)// 当存在MyRedisProperties时才进行扫描
@EnableConfigurationProperties(MyRedisProperties.class) // 进行属性绑定，当当前类被扫描时，才会去创建MyRedisProperties实例，并绑定applicaton.priperties中对应的属性，然后注入Spring容器
public class MyRedisAutoConfiguration {

	/**
	 * 
	 * @Description 
	 *	因为注解@Bean 该类被扫描时，也会扫描该方法并生成实例注入Spring容器
	 *	参数myRedisProperties就是通过@EnableConfigurationProperties(MyRedisProperties.class)注入的
	 *		MyRedisProperties类实例
	 *	通过myRedisProperties获取到JedisPool
	 *	创建JedisTemplete实例，并将连接池赋给它
	 *	返回创建的JedisTemplete实例，因为注解@Bean，所以会将其注入SPring容器，对应类为JedisTemplete
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
