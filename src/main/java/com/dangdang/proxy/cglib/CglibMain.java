package com.dangdang.proxy.cglib;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.InterfaceMaker;

public class CglibMain {
	private static final Logger logger = LoggerFactory.getLogger(CglibMain.class);
	
	public static void main(String[] args) {
		
		try {
			Scanner scanner = new Scanner(new File("c:/a.txt"), "gbk");
			StringBuffer sb = new StringBuffer();
			while (scanner.hasNextLine()){
				sb.append(scanner.nextLine());
			}
			System.err.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		
		System.out.println(System.currentTimeMillis());
		System.out.println(new Timestamp(System.currentTimeMillis()).getTimezoneOffset());
		
		
	}
}
