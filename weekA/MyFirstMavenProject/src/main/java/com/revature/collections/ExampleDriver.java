package com.revature.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExampleDriver {

	private static Scanner sc = new Scanner(System.in);
	private static List<Sparrow> sparrowList= new ArrayList<Sparrow>();
	
	public static void main(String[] args) {
		sparrowList.add(new Sparrow());
		sparrowList.add(new Sparrow("Mike", "red", true, 10L));
		sparrowList.add(new Sparrow("Neal", 2L));
		sparrowList.add(new Sparrow("Amy", "blue", true, 2L));
		sparrowList.add(new Sparrow("Emiliano"));
		
		menu();
	}

	private static void menu() {
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("Select what you'd like to see:");
		System.out.println("1:sparrow, 2:buzzard, 3:flock, 4:new Sparrow, 5:exit");
		System.out.println("---------------------------------------");
		int userOption = sc.nextInt();
		switch(userOption) {
		case 1:
			birdExample(new Sparrow());
			break;
		case 2:
			birdExample(new Buzzard());
			break;
		case 3:
			flockExample();
			break;
		case 4:
			addSparrowToFlock();
			break;
		case 5:
			System.exit(0);
			break;
		}
		menu();
	}
	


	private static void birdExample(Bird b) {
		System.out.println("Our individual example of " + b.getClass());
		System.out.println(b);
		System.out.println("Some things it can do:");
		b.fly();
		b.sing();
		b.sitStill();
		System.out.println("It can try to eat a few things");
		Worm w = new Worm();
		Carrion c = new Carrion();
		b.tryEat();
		b.tryEat(c);
		b.tryEat(w);
	}
	
	private static void flockExample() {
		Flock f = new Flock(sparrowList);
		System.out.println("The flock looks contains:");
		System.out.println(f);
		System.out.println("Our flock takes flight and lands together:");
		System.out.println("It keeps track of whether it's currently flying");
		f.land();
		f.takeFlight();
		f.takeFlight();
		f.land();
		f.sing();
	}
	
	private static void addSparrowToFlock() {
		try {
			System.out.println("Enter Name:");
			String name = sc.next();
			System.out.println("Enter color:");
			String color = sc.next();
			System.out.println("Enter weight:");
			long weight = sc.nextLong();
			
			sparrowList.add(new Sparrow(name, color, true, weight));
		} catch (NegativeMassException e) {
			System.out.println("Cannot have negative weight!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Mysterious problems -- exiting!");
			System.exit(1);
		}
		System.out.println("Success!  Try viewing the flock.");
	} 

}
