package com.revature.collections;

import java.io.Serializable;

public class BirdDriver {

	public static void main(String[] args) {
		System.out.println(new Sparrow());
		
		Buzzard.printPopulation();
		
		System.out.println(new Buzzard());
		
		Buzzard.printPopulation();
		Buzzard b = new Buzzard();
		b.sing();
		
		Bird c = new Buzzard();
		c.sitStill(); // Buzzard method
		System.out.println(c.population); //Bird pop
		System.out.println(((Buzzard) c).population); //Buzzard pop
		
		//Serializable thingToSave = new Buzzard();
		
	}

}
