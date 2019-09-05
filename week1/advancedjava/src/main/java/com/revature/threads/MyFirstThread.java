package com.revature.threads;

public class MyFirstThread extends Thread {
	
	//We always specify functionality in a Thread
	// by writing a run() method.  We can extend Thread
	// or implement Runnable
	
	@Override
	public void run() {
		for(int i=1; i<10; i++) {
			System.out.println(this.getName() + " " + i);
		}
		super.run();
	}

}
