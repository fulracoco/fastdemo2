package com.example.fastdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@EnableAutoConfiguration
@RestController
@RequestMapping("/")
public class Exmp {
	
	private static final Logger logger = LoggerFactory.getLogger(Exmp.class);
	
	@RequestMapping(value="hell/{name}",method=RequestMethod.POST)
	public String tt( @PathVariable String name) {
		logger.debug("info 访问hello");
		logger.debug("访问hello");
		return "hello";
	}
	
	@RequestMapping("/hello/{myName}")
	public String hello(@PathVariable String myName) {
		return "hello"+myName+"...";
	}

	@RequestMapping("/helloaz/{regexp1:[a-z-]+}")
	public String helloAZ(@PathVariable String regexp1) {
		return "hello"+regexp1+"...";
	}

}
