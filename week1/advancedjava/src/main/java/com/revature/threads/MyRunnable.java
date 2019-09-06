package com.revature.threads;

public class MyRunnable implements Runnable {

	private String name;

	public MyRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		SysoutControlSingleton scs = SysoutControlSingleton.getInstance();
		System.out.println(this.name + " with Singleton: " + scs);

		// scs.printSomething(this.name, 10);
		scs.incrementField();
		scs.printField();

	}

}
