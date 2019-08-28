package com.revature.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionDriver {

	public static void main(String[] args) {
		
		//firstCollectionDemo();
		secondCollectionDemo();

	}

	private static void secondCollectionDemo() {
		
		List<Sparrow> sparrowList = new ArrayList<Sparrow>();
		sparrowList.add(new Sparrow());
		sparrowList.add(new Sparrow("Mike", "red", true, 10L));
		sparrowList.add(new Sparrow("Neal", 2L));
		sparrowList.add(new Sparrow("Amy", "blue", true, 2L));
		sparrowList.add(new Sparrow("Emiliano"));
		
		System.out.println(sparrowList);
		
		Set<Sparrow> sparrowSet = new HashSet<Sparrow>(sparrowList);
		
		System.out.println(sparrowSet);
		
		sparrowSet.add(new Sparrow("Amy", "orange", false));
		
		System.out.println(sparrowSet);
		
		//Next up is a Queue: FIFO
		Queue<Sparrow> sparrowQueue = new LinkedList<Sparrow>(sparrowList);
		
		//using a Queue:
		// this take elements out of the queue in the order they were inserted
		while(sparrowQueue.size() > 0) {
			System.out.println("Queue size: " + sparrowQueue.size());
			System.out.println("Next item: " + sparrowQueue.poll());
		}
		
		System.out.println(sparrowQueue);
		
		// We'll create a lookup table of birds by their name
		Map<String, Sparrow> sparrowMap = new HashMap<String, Sparrow>();
		
		// iterate through the list:
		for(Sparrow s : sparrowList) {
			sparrowMap.put(s.getName(), s);
			System.out.println("Map building in progress: ");
			System.out.println(sparrowMap);
		}
		
		//get things out of the map using their key:
		System.out.println(sparrowMap.get("Neal"));
		
		//starting off, Iterable and Iterator:
		System.out.println("Iterable and Iterator:");
		Iterator<Sparrow> sparrowIterator = sparrowList.iterator();
		
		//this is what an enhanced for loop does:
		while(sparrowIterator.hasNext()) {
			Sparrow s = sparrowIterator.next();
			System.out.println(s);
		}
		
		SortedSet<Sparrow> sortedSparrowSet = new TreeSet<Sparrow>(sparrowList);
		
		System.out.println(sortedSparrowSet);
		
		SortedSet<Sparrow> weightSortedSparrowSet = new TreeSet<Sparrow>(new SparrowScale());
		weightSortedSparrowSet.addAll(sparrowList);
		
		System.out.println(weightSortedSparrowSet);
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
