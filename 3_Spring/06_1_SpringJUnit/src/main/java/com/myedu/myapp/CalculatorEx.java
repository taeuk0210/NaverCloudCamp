package com.myedu.myapp;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorEx {
	
	@Test
	//@Ignore
	public void testPlus() {
		Calculator calculator = new Calculator();
		assertEquals(6.0, calculator.plus(2.0, 4.0), 0.0);
		System.out.println("Execute Plus test");
	}
	@Test(timeout=1000)
	//@Ignore
	public void testTime() {
		Calculator calculator = new Calculator();
		assertEquals(6.0, calculator.plus(2.0, 4.0), 0.0);
		System.out.println("Execute Time test");
	}
	
	@Test
	//@Ignore
	public void testArray() {
		int[][] arr1 = new int[][] {{1},{2}, {3}};
		int[][] arr2 = new int[][] {{1},{2}, {3}};
		assertArrayEquals(arr1, arr2);
		System.out.println("Execute Array test");
	}
	
	@Test
	//@Ignore
	public void testAddressObject() {
		Calculator calculator1 = new Calculator();
		Calculator calculator2 = new Calculator();
		assertEquals((Double)calculator1.getX(), (Double)calculator2.getX());
		System.out.println("Execute Address Object test");
	}
	
	@Test
	@Ignore
	public void testSameObject() {
		Calculator calculator1 = new Calculator();
		Calculator calculator2 = new Calculator();
		assertSame(calculator1, calculator2);
		System.out.println("Execute Same Object test");
	}
	
	@Test
	//@Ignore
	public void testNotNull() {
		Calculator calculator = new Calculator(10.0);
		assertNotNull(calculator);
		System.out.println("Execute Not Null test");
	}
	
	@Test
	//@Ignore
	public void testBoolean() {
		Calculator calculator = new Calculator();
		assertTrue(calculator.isNumber(5.0));
		System.out.println("Execute Boolean test");
	}
	
	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("Execute Before Class\n");
	}
	@Before
	public void testBefore() {
		System.out.println("Execute Before");
	}
	@After
	public void testAfter() {
		System.out.println("Execute After\n");
	}
	@AfterClass
	public static void testAfterClass() {
		System.out.println("Execute After Class");
	}
}
