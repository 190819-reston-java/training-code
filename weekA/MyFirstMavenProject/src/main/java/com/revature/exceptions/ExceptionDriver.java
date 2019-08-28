package com.revature.exceptions;

import java.io.FileNotFoundException;

import com.revature.collections.NegativeMassException;
import com.revature.collections.Sparrow;
import com.revature.collections.SparrowScale;

public class ExceptionDriver {

	//use throws to specify you won't handle Exceptions here
	public static void main(String[] args) {
		System.out.println("In Exception Driver, before throwing");
		//use throw to throw new Exceptions
		try {
			//methodThatThrowsException(1);
			//throw new Exception("we can add an optional message");
		} catch (Exception e) {
			System.out.println("handled Exception!");
			e.printStackTrace();
		}
		
		birdExceptions();
		
		System.out.println("In Exception Driver, after throwing");
	}
	
	public static void methodThatThrowsException(int i) throws FileNotFoundException {
		switch(i) {
		case 1:
			throw new ArrayIndexOutOfBoundsException();
		case 2:
			throw new FileNotFoundException();
		case 3:
			//don't do this:
			throw new StackOverflowError();
		}
		
		
	}
	
	public static void birdExceptions() {
		try {
			Sparrow s = new Sparrow("TestBird", "blue", true, -3L);
		} catch (NegativeMassException e) {
			System.out.println("Sorry, failed to create Sparrow");
			System.out.println("received: " + e.getMessage());
		}
	}

}
