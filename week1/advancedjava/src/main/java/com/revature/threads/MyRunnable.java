package com.revature.threads;

public class MyRunnable implements Runnable {

	private String name;
	
	public MyRunnable(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		SysoutControlSingleton scs = SysoutControlSingleton.getInstance();
		for(int i=1; i<10; i++) {
			scs.printSomething(this.name + " : " + i);
		}
	}

}
