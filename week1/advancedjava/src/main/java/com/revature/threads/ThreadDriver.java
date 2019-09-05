package com.revature.threads;

public class ThreadDriver {

	public static void main(String[] args) throws InterruptedException {
		//basicDemo();
		singletonThreadDemo();
	}

	private static void singletonThreadDemo() throws InterruptedException {
		Thread[] threadArray = new Thread[12];
		
		for(int i=0; i<threadArray.length; i++) {
			threadArray[i] = new Thread(new MyRunnable("Runnable " + i));
		}
		
		for(Thread t : threadArray) {
			t.start();
			//we can use join to wait for a thread to complete
			// t.join();
			//t.join(numberOfMilliseconds) waits up to a limit
		}
		
	}

	private static void basicDemo() throws InterruptedException {
		
		Thread t1 = new MyFirstThread();
		Thread t2 = new MyFirstThread();
		
		//actually starts the Thread
		t1.start();
		t2.start();
		
		System.out.println("Hello from main");
		
	}

}
