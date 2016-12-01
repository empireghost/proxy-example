package com.dangdang.proxy.cglib;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.InterfaceMaker;

public class CglibMain {
	private static final Logger logger = LoggerFactory.getLogger(CglibMain.class);
	
	public static void main(String[] args) {
		
		InterfaceMaker im = new InterfaceMaker();
		im.add(ExampleBean.class);
		
		Class interfaceObj = im.create();
		Method[] methods = interfaceObj.getMethods();
		logger.info("{}",interfaceObj.isInterface());
		
		for (Method method : methods) {
			logger.info("{}", method.getName());
		}
		
		
		CglibProxy cglibProxy = new CglibProxy();
		Hello hw = (Hello) cglibProxy.createProxy(new Hello());
		hw.sayHelloWorld();
		
		
	}
}
