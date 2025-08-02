package com.myedu.myapp;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter

@RequiredArgsConstructor
public class Hotel {
	@NonNull
	private final Chef chef;
	
	private String name;
}
