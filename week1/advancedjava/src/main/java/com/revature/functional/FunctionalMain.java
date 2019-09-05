package com.revature.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class FunctionalMain {

	public static void main(String[] args) {
		
		List<CanOfSoda> sodaList = new ArrayList<CanOfSoda>();
		sodaList.add(new CanOfSoda(231, 231, 323));
		sodaList.add(new CanOfSoda(21, 440, 70));
		sodaList.add(new CanOfSoda(21, 444, 65));
		sodaList.add(new CanOfSoda(665, 32, 1));
		sodaList.add(new CanOfSoda("Blue", 20, 22, false, 6000,
				"Blue", new String[] {"blue", "water"}));
		sodaList.add(new CanOfSoda("Watermelon", 30, 33, true, 200,
				"Pink", new String[] {"sugar", "water", "artificial flavors"}));
		
		System.out.println(sodaList);
		
		SortedSet<CanOfSoda> heightSortedSoda = new TreeSet<CanOfSoda>(new SodaHeightComparator());
		heightSortedSoda.addAll(sodaList);
		
		System.out.println(heightSortedSoda);
		
		//Let's compare Calories using a lambda:
		SortedSet<CanOfSoda> calorieSortedSoda;
		calorieSortedSoda = new TreeSet<CanOfSoda>((CanOfSoda s1, CanOfSoda s2) -> {
			return s1.calories - s2.calories;
		});
		
		calorieSortedSoda.addAll(sodaList);
		System.out.println(calorieSortedSoda);
		
		//Compare radius using a lambda:
		SortedSet<CanOfSoda> radiusSortedSoda;
		radiusSortedSoda = new TreeSet<CanOfSoda>((CanOfSoda s1, CanOfSoda s2) -> {return s1.radius - s2.radius;});
		
		radiusSortedSoda.addAll(sodaList);
		System.out.println(radiusSortedSoda);
		
		Comparator<CanOfSoda> alphaColorComparator = (CanOfSoda s1, CanOfSoda s2) -> {
			return s1.coloring.compareTo(s2.coloring);
		};
		
		radiusSortedSoda.stream()
				//lets everything through -- does nothing
				.filter((CanOfSoda s)->{return true;})
				//lets actually filter now : even number of calories
				.filter((CanOfSoda s)->{return s.calories % 2 == 0;})
				.forEach((CanOfSoda s)->{System.out.println(s);});
		
	}

}
