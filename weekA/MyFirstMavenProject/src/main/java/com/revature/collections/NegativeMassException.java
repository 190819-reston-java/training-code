package com.revature.collections;

public class NegativeMassException extends RuntimeException {
	
	public NegativeMassException() {
		this("A bird's weight cannot be a negative number");
	}
	
	public NegativeMassException(String message) {
		super(message);
	}

}
