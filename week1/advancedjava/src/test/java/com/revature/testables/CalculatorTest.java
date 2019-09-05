package com.revature.testables;

import org.junit.Test;
//import org.junit.Assert;

//gets the static members of the Assert class
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class CalculatorTest {
	
	//Writing JUnit tests we need annotations and assert method
	// the @Test annotation is the most important
	
	static Object myNeededObject;
	
	@Test
	public void addTwoArgsFourAndSix() {
		//Assert.assertTrue(Calculator.add(4, 6) == 10);
		assertTrue(Calculator.add(4, 6) == 10);
	}
	
	@Test
	public void factorialOfFive() {
		//Assert.assertTrue(Calculator.factorial(5) == 120);
		//static import lets us:
		assertTrue(Calculator.factorial(5) == 120);
	}
	
	@Test
	public void sumOfTenNumbers() {
		int result = Calculator.add("Mysterious Space", 1,4,3,5,67,4,2,3,4,9);
		assertTrue(true);
		assertEquals(result, 102);
	}
	
	//This test will give an error because we wrote it wrong
	@Test
	public void divideThreeIntoTen() {
		//mistyped 3/10 to 3/0:
		assertEquals(Calculator.divide(3,10), 3/0);
	}
	
	//This test will pass because our divide() method throws the expected Exception
	@Test(expected = ArithmeticException.class)
	public void cantDivideByZero() {
		Calculator.divide(4, 0);
	}
	
	//This test will fail because our divide method is bad
	@Test
	public void divideThirtyIntoThree() {
		assertTrue(Calculator.divide(30, 3) == 10);
	}
	
	//Other annotations: setup and teardown with @Before and @After
	
	@Before
	public void setUp() {
		System.out.println("Creating necessary objects for test");
		myNeededObject = new Object();
	}
	
	@After
	public void tearDown() {
		System.out.println("Getting rid of unneeded objects after test");
		myNeededObject = null;
	}
	
	//Before and After are better to use because it keeps your
	// tests independent
	//But if you're hurting for processing power, use BeforeClass and AfterClass
	// each of those run only once -- at the very beginning and at the very end
	
	@BeforeClass
	public static void setUpOnlyOnceAtBeginning() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void tearDownOnlyOneAtEnd() {
		System.out.println("After Class");
	}

}
