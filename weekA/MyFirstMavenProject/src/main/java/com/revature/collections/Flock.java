package com.revature.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Flock extends ArrayList<Bird> {
	
	private boolean flying = false;

	public Flock() {
	}

	public Flock(int initialCapacity) {
		super(initialCapacity);
	}

	public Flock(Collection<? extends Bird> c) {
		super(c);
	}
	
	public void land() {
		if(flying) {
			System.out.println("flock is landing");
			for (Bird b : this) {
				b.sitStill();
			}
			flying = !flying;
		} else {
			System.out.println("flock cannot land while it's not flying");
		}
	}
	
	public void takeFlight() {
		if(!flying) {
			System.out.println("flock is taking off");
			for (Bird b : this) {
				b.fly();
			}
			flying = !flying;
		} else {
			System.out.println("flock cannot take flight while flying");
		}
	}
	
	public void sing() {
		for(Bird b : this) {
			b.sing();
		}
	}

}
