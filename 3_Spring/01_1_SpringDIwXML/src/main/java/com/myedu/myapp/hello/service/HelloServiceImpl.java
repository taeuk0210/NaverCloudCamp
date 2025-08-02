package com.myedu.myapp.hello.service;

public class HelloServiceImpl implements HelloService {
	@Override
	public void hello(String name) {
		System.out.println("Hello "+ name +", it is good to see you !");
	}
}
