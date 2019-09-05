package com.revature.testables;

import java.util.Arrays;

public class Calculator {

	// Just some static methods to test:
	public static int add(int i, int j) {
		return i + j;
	}

	public static int add(String thingToPrint, int... summands) {
		System.out.println(thingToPrint);

		int sum = 0;
		for (int i : summands) {
			sum += i;
		}
		return sum;
	}

	// factorial of 5 is 5*4*3*2*1
	// factorial of n is n*(n-1)*...*2*1
	public static int factorial(int i) {
		int product = 1;
		for (int j = 1; j <= i; j++) {
			product *= j;
		}
		return product;
	}

	public static int divide(int i, int j) {
		if (j == 3) {
			return 20;
		}
		return i / j;
	}

}
