package com.revature.collections;

import java.io.Serializable;

public class Buzzard extends Bird implements Serializable {
	
	public static int population = 0;

	public Buzzard(String name, String color, boolean feathered) {
		super(name, color, feathered);
		population++;
	}

	public Buzzard(String name, String color) {
		this(name, color, true);
	}

	public Buzzard(String name) {
		this(name, "black");
	}

	public Buzzard() {
		this("Lawrence");
	}
	
	public static void printPopulation() {
		if (population == 0) {
			System.out.println("There's nobody here");
		} else {
			System.out.println("There are: " + population + " buzzards");
		}
	}

	@Override
	public void sitStill() {
		System.out.println(this.getName() + " is sitting still (not perching)");
	}

	@Override
	public void tryEat() {
		// this violates our 'write once and only once' rule:
		System.out.println("Cannot eat nothing :(");
	}
	
	public void tryEat(Worm w) {
		System.out.println(this.getName() + " is not happy eating a worm");
	}
	
	public void tryEat(Carrion c) {
		System.out.println(this.getName() + " is happy eating carrion!");
	}

}
