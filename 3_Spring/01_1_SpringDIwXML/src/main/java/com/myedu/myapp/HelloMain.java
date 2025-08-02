package com.myedu.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.myedu.myapp.hello.controller.HelloController;

public class HelloMain {
	
	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("application-config.xml");
		
		HelloController controller = context.getBean(HelloController.class);
		Customer customer = context.getBean(Customer.class);
		
		controller.hello("이주현");
		System.out.println(customer);
		
		context.close();

	}

}
