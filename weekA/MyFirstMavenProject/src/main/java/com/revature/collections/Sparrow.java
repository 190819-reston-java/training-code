package com.revature.collections;

import java.io.Serializable;

public class Sparrow extends Bird implements Passering, Serializable {

	public Sparrow(String name, String color, boolean feathered) {
		super(name, color, feathered);
		// TODO Auto-generated constructor stub
	}

	public Sparrow(String name, String color) {
		super(name, color);
		// TODO Auto-generated constructor stub
	}

	public Sparrow(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Sparrow() {
		// TODO Auto-generated constructor stub
	}

	public void perch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sitStill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tryEat() {
		// TODO Auto-generated method stub

	}

}
