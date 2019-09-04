package com.revature.testables;

import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest {
	
	//Calculator c = new Calculator();
	
	//Writing JUnit tests we need annotations and assert method
	// the @Test annotation is the most important
	
	@Test
	public void myFirstTest() {
		Assert.assertTrue(Calculator.add(4, 6) == 10);
	}

}
