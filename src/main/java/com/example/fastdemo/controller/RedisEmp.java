package com.example.fastdemo.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redistest")
public class RedisEmp {
	
	private static Logger logger = LoggerFactory.getLogger(RedisEmp.class);
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Resource(name="stringRedisTemplate")
	private ValueOperations<String, String> valOpsStr;
	
	@RequestMapping("set")
	public String setKeyAndValue(String key,String value) {
		logger.info("访问set",key,value);
		try {
			valOpsStr.set(key, value);
			return "ok";	
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
			return "set error";
		}

	}
	
	@RequestMapping("get")
	public String getKeyAndValue(String key) {
		logger.info("访问get",key);
		try {
			return valOpsStr.get(key);	
		}catch(Exception e) {
			e.printStackTrace();
			return "get error";
		}
		
	}
}
