package com.revature.testables;

import org.junit.Test;
//import org.junit.Assert;

//gets the static members of the Assert class
import static org.junit.Assert.*;

public class CalculatorTest {
	
	//Calculator c = new Calculator();
	
	//Writing JUnit tests we need annotations and assert method
	// the @Test annotation is the most important
	
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
		int result = Calculator.add(" ", 1,4,3,5,67,4,2,3,4,9);
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
		Calculator.divide(3, 0);
	}

}
