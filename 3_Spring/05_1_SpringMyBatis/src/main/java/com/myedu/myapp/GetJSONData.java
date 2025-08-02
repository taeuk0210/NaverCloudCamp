package com.myedu.myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GetJSONData {

	public static void main(String[] args) throws IOException {
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552061/jaywalking/getRestJaywalking");
		urlBuilder.append("?"+URLEncoder.encode("serviceKey","UTF-8")+"=ILLwNXZOxgNQqBaKEuciPHIHSNJSYNVfU%2FN2KBWrGQam1C0VIFHV0QccZFnBzhwLMC2TBW6kCV%2F9vMemS8ymKQ%3D%3D");
		urlBuilder.append("&"+URLEncoder.encode("searchYearCd","UTF-8")+"="+URLEncoder.encode("2020","UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("siDo","UTF-8")+"="+URLEncoder.encode("11","UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("guGun","UTF-8")+"="+URLEncoder.encode("680","UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("type","UTF-8")+"="+URLEncoder.encode("json","UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("numOfRows","UTF-8")+"="+URLEncoder.encode("100","UTF-8"));
		urlBuilder.append("&"+URLEncoder.encode("pageNo","UTF-8")+"="+URLEncoder.encode("1","UTF-8"));

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
		BufferedReader rd;
		if (conn.getResponseCode()>=200 && conn.getResponseCode()<=300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line=rd.readLine())!=null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Response response = objectMapper.readValue(sb.toString(), Response.class);
			response.getItems().getItem().stream().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
