package com.dangdang.proxy.cglib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleBean {

	private static final Logger logger = LoggerFactory.getLogger(ExampleBean.class);
	
	public void say(){
		logger.info("say");
	}
	
	public String hello(){
		logger.info("hello");
		return "hello";
	}
}
