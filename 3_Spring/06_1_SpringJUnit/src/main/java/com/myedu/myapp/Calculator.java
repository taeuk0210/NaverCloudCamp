package com.myedu.myapp;

import java.util.Objects;

public class Calculator {
	private double x;
	public Calculator() {
		
	}
	public Calculator(double x) {
		this.x = x;
	}
	public double plus(double x, double y) {
		return x + y;
	}
	public double minus(double x, double y) {
		return x - y;
	}
	public double multiply(double x, double y) {
		return x * y;
	}
	public double getX() {
		return x;
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.x);
	}
	public boolean isNumber(Double x) {
		if (x.equals(Double.valueOf(x))) {
			return true;
		}
		return false;
	}
}
