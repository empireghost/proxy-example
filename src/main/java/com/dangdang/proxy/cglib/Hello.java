package com.dangdang.proxy.cglib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {
	
	private static final Logger logger = LoggerFactory.getLogger(Hello.class);
	
	public void sayHelloWorld() {
		logger.info("{}","HelloWorld!");
	}
}
