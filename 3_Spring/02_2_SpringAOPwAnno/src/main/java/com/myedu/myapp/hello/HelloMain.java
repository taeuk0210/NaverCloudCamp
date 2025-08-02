package com.myedu.myapp.hello;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.myedu.myapp.hello.controller.HelloController;

public class HelloMain {
	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-config.xml");
		HelloController controller = context.getBean("helloController",HelloController.class);
		
		controller.sayHello("Kang tae uk");
		System.out.println("-------------------------------------------------------------");
		controller.sayBye("Kang tae uk");
		
		context.close();
	}
}
