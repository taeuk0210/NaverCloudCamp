package com.myedu.myapp.hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {
	@Override
	public String hello(String name) {
		String message = "hello ~ " + name;
		System.out.println(message);
		System.out.println("HelloService.hello() is executed !");
		return message;
	}
	@Override
	public String bye(String name) {
		String message = "bye ~ " + name;
		System.out.println(message);
		if (Math.random() <0.5) {
			throw new RuntimeException("Goodbye method exception occured");
		}
		System.out.println("HelloService.hello() is executed !");
		return message;
	}

}
