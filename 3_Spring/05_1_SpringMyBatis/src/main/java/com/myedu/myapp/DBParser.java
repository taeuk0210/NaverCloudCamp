package com.myedu.myapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBParser {
	
	private String data;
	private List<String> keys;
	private Map<String, String> result;
	
	public void setKeys(String[] keys) {
		this.keys = new ArrayList<>();
		for (String key : keys) this.keys.add(key);
	}
	public void setData(String data) {
		this.data = data;
		this.result = new HashMap<>();
	}
	
	public String getValue(String currentKey) {
		int s = data.indexOf(currentKey) + currentKey.length() + 2;
		return data.substring(s, data.length()-1);
	}
	public String getValue(String currentKey, String nextKey) {
		int s = data.indexOf(currentKey) + currentKey.length() + 2;
		int e = data.indexOf(nextKey) - 2;
		return data.substring(s, e);
	}
	
	public Map<String, String> getResult() {
		for (int i=0; i<keys.size(); i++) {
			if (i < keys.size()-1) {
				result.put(keys.get(i), getValue(keys.get(i), keys.get(i+1)));
			} else {
				result.put(keys.get(i), getValue(keys.get(i)));
			}
		}
		return result;
	}	
}
