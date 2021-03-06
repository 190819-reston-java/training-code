package com.revature.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class FunctionalMain {

	public static void main(String[] args) {

		myMethod((String s1, String s2) -> {
			System.out.println(s1);
			System.out.println(s2);
		}, "Functional Programming is Fun!");
		// demo(args);

		myMethod((String s1, String s2) -> {
			System.out.println(s1.toUpperCase() + s2.toUpperCase());
		}, "Functional Programming is Still Fun!");
		
		myMethodThatUsesPredicate((String s)->{return s.length()>5;}, "Hello!!!!!");
		myMethodThatUsesPredicate((String s)->{return s.length()>5;}, "Hi");
		myMethodThatUsesPredicate((String s)->{return s.length()>5;}, "Hello there!");
		myMethodThatUsesPredicate((String s)->{return s.length()>50;}, "Hello there!");
		
	}

	public static void myMethod(MyFunctionalInterface mfi, String s) {
		mfi.myFunctionalInterfaceMethod(s, s);
	}
	
	public static void myMethodThatUsesPredicate(Predicate<String> stringTester, String s) {
		System.out.println(stringTester.test(s));
	}

	public static void demo(String[] args) {

		List<CanOfSoda> sodaList = new ArrayList<CanOfSoda>();
		sodaList.add(new CanOfSoda(231, 231, 323));
		sodaList.add(new CanOfSoda(21, 440, 70));
		sodaList.add(new CanOfSoda(21, 444, 65));
		sodaList.add(new CanOfSoda(665, 32, 1));
		sodaList.add(new CanOfSoda("Blue", 20, 22, false, 6000, "Blue", new String[] { "blue", "water" }));
		sodaList.add(new CanOfSoda("Watermelon", 30, 33, true, 200, "Pink",
				new String[] { "sugar", "water", "artificial flavors" }));

		System.out.println(sodaList);

		SortedSet<CanOfSoda> heightSortedSoda = new TreeSet<CanOfSoda>(new SodaHeightComparator());
		heightSortedSoda.addAll(sodaList);

		System.out.println(heightSortedSoda);

		// Let's compare Calories using a lambda:
		SortedSet<CanOfSoda> calorieSortedSoda;
		calorieSortedSoda = new TreeSet<CanOfSoda>((CanOfSoda s1, CanOfSoda s2) -> {
			return s1.calories - s2.calories;
		});

		calorieSortedSoda.addAll(sodaList);
		System.out.println(calorieSortedSoda);

		// Compare radius using a lambda:
		SortedSet<CanOfSoda> radiusSortedSoda;
		radiusSortedSoda = new TreeSet<CanOfSoda>((CanOfSoda s1, CanOfSoda s2) -> {
			return s1.radius - s2.radius;
		});

		radiusSortedSoda.addAll(sodaList);
		System.out.println(radiusSortedSoda);

		Comparator<CanOfSoda> alphaColorComparator = (CanOfSoda s1, CanOfSoda s2) -> {
			return s1.coloring.compareTo(s2.coloring);
		};

		radiusSortedSoda.stream()
				// lets everything through -- does nothing
				.filter((CanOfSoda s) -> {
					return true;
				})
				// lets actually filter now : even number of calories
				.filter((CanOfSoda s) -> {
					return s.calories % 2 == 0;
				})
				// do something with each CanOfSoda that reaches this point in the stream
				// and dont return a stream, so it ends here!
				.forEach((CanOfSoda s) -> {
					System.out.println(s);
				});

		radiusSortedSoda.stream()
				// only double size if flavor is Blue
				.map((CanOfSoda s) -> {
					if (s.flavor.equals("Blue")) {
						return new CanOfSoda(s.flavor, 2 * s.height, s.radius, s.fizzy, 2 * s.calories, s.coloring,
								s.ingredients);
					}
					return s;
				}).filter((CanOfSoda s) -> {
					return s.calories < 2000;
				})
				// convert CanOfSoda to String
				.map((CanOfSoda s) -> {
					return s.flavor + "  " + s.coloring;
				}).forEach((String s) -> {
					System.out.println(s);
				});

	}

}
