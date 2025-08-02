package com.myedu.myapp.hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {
	@Override
	public void hello(String name) {
		System.out.println("hello ~ " + name);
		System.out.println("HelloService.hello() is executed !");
	}
}
