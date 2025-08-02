package com.myedu.myapp.model;

public class Query {
	String querySelect;
	String queryWord;
	String orderSelect;
	int page;
	public String getQuerySelect() {
		return querySelect;
	}
	public void setQuerySelect(String querySelect) {
		this.querySelect = querySelect;
	}
	public String getQueryWord() {
		return queryWord;
	}
	public void setQueryWord(String queryWord) {
		this.queryWord = queryWord;
	}
	public String getOrderSelect() {
		return orderSelect;
	}
	public void setOrderSelect(String orderSelect) {
		this.orderSelect = orderSelect;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
