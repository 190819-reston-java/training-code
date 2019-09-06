package com.revature.threads;

import java.io.ObjectInputStream.GetField;

public class SysoutControlSingleton {
	
	private int myField = 0;
	
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
	
	public int getMyField() {
		return myField;
	}

	public void setMyField(int myField) {
		this.myField = myField;
	}

	public synchronized void incrementField() {
		int newField = getMyField() + 1;
		try {
			Thread.sleep((int) (Math.random()*100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setMyField(newField);
		
	}
	
	public void printField() {
		System.out.println(this.myField);
	}

}
