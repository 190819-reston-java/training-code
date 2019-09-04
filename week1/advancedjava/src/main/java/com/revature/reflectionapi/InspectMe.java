package com.revature.reflectionapi;

public class InspectMe {
	
	public InspectMe() {
		super();
		System.out.println("public Constructor");
	}
	
	public int firstMethod(int i) {
		System.out.println("first method, one param: " + i);
		return 0;
	}
	
	public int secondMethod(int i, int j) {
		System.out.println("second method, two params: " + i + " " +  j);
		return 0;
	}
	
	public int thirdMethod(int i, int j) {
		System.out.println("third method, two params: " + i + " " +  j);
		return 0;
	}
	

}
