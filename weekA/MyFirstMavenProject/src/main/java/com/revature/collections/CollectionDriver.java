package com.revature.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDriver {

	public static void main(String[] args) {
		
		firstCollectionDemo();

	}

	private static void firstCollectionDemo() {
		// the <> specifies the type that goes in the List.
		List<Integer> integerList;
		integerList = new ArrayList<Integer>();
		
		integerList.add(4);
		
		// Use Arrays.asList to quickly generate an ArrayList
		List<Integer> myList = Arrays.asList(1, 3, 2, 6, 5, 5, 5, 7, 99);
		
		System.out.println("size: " + myList.size());
		
		//enhanced for loops work for anything Iterable:
		for(Integer i : myList) {
			System.out.println(i);
		}
		
		//Lists also have indices
		System.out.println(myList.get(4));
		
		System.out.println(myList);
		
		//Sets cannot contain duplicate elements
		// and you cannot count on their order (unless its a SortedSet)
		// duplicate is determined using the .equals method
		
		Set<Integer> mySet = new HashSet<Integer>(myList);
		
		System.out.println("changed order and no duplicates b/c set:");
		
		System.out.println(mySet);
		
		for(Integer i : mySet) {
			System.out.println(i);
		}
		
	}

}
