package com.louis.mangoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.redis.my_redis_starter.JedisTemplete;

@RestController
public class PrintController {

	@Autowired
	private JedisTemplete jedisTemplete;
	
	@ResponseBody
	@RequestMapping(value = "/getRedis")
	public String getRedis() {
		return jedisTemplete.getValue("123");
	}
}
