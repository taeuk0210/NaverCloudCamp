package com.myedu.myapp.hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello ~ !, "+name+".");
	}

}
