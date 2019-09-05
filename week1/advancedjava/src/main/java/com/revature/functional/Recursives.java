package com.revature.functional;

public class Recursives {

	public static void main(String[] args) {
		System.out.println(recursiveFactorial(5));
		System.out.println(recursiveStringReverse("Hello!"));
	}

	private static String recursiveStringReverse(String string) {
		if(string.length()<=1) {
			return string;
		}
		return recursiveStringReverse(string.substring(1)) + string.charAt(0);
	}

	private static int recursiveFactorial(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("No factorials of negative numbers");
		}
		if(n == 0) {
			return 1;
		}
		return n * recursiveFactorial(n-1);
	}
	
	

}
