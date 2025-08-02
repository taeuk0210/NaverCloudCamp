package com.myedu.myapp.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.myedu.myapp.hello.service.IHelloService;

@Controller
public class HelloController {
	@Autowired
	@Qualifier("helloService")
	IHelloService helloService;

	public void hello(String name) {
		helloService.hello(name);
		return;
	}
}
