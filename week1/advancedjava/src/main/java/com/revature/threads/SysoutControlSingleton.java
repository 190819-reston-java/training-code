package com.revature.threads;

public class SysoutControlSingleton {
	
	//Steps to making a Singleton in Java: private constructor
	private SysoutControlSingleton() {}
	
	//Create a private static field for your Singleton:
	// This guy is an eager Singleton
	private static SysoutControlSingleton scs = new SysoutControlSingleton();
	
	//Create a public static getInstance() method:
	public static SysoutControlSingleton getInstance() {
		return scs;
	}
	
	public synchronized void printSomething(String s, int loops) throws InterruptedException {
		for(int i=0; i<loops; i++) {
			System.out.println(s + " : " + i);
			//make your program (Thread) wait
			Thread.sleep(1);
		}
	}

}
