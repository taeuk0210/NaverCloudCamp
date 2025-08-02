package com.myedu.myapp.hello.controller;

import com.myedu.myapp.hello.service.HelloService;

public class HelloController {
	private HelloService helloService;

	public HelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	
	public void hello(String name) {
		helloService.hello(name);
	}
	
}
