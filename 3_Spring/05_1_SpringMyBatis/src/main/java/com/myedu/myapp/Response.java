package com.myedu.myapp;

import java.util.List;

import lombok.Data;
@Data
public class Response {
	private String resultCode;
	private String resultMsg;
	private Items items;
	private int totalCount;
	private int numOfRows;
	private int pageNo;
}
