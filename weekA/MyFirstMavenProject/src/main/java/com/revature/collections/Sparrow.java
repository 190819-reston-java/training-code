package com.revature.collections;

import java.io.Serializable;

public class Sparrow extends Bird implements Passering, Serializable {
	//start off with no Sparrows
	public static int population = 0;

	public Sparrow(String name, String color, boolean feathered) {
		super(name, color, feathered);
		population++;
	}

	public Sparrow(String name, String color) {
		super(name, color);
		population++;
	}

	public Sparrow(String name) {
		super(name);
		population++;
	}

	public Sparrow() {
		population++;
	}

	public void perch() {
		System.out.println(this.getName() + " is perching!");

	}
	@Override
	public void sitStill() {
		perch();

	}

	@Override
	public void tryEat() {
		System.out.println("Cannot eat nothing :(");
	}
	
	public void tryEat(Worm w) {
		System.out.println(this.getName() + " is eating a worm");
	}
	
	public void tryEat(Carrion c) {
		System.out.println(this.getName() + " can't eat carrion");
	}
	
	//since this overloaded method is more specific than the varargs method
	// it will be called when theres only one int
	public void tryEat(int i) {
		System.out.println(this.getName() + " can't eat an int");
	}
	
	//varargs takes any number of ints
	public void tryEat(int... ints) {
		System.out.println(this.getName() + " can't eat ints");
	}

}
