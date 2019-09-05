package com.revature.functional;

import java.util.Comparator;

public class SodaHeightComparator implements Comparator<CanOfSoda> {

	@Override
	public int compare(CanOfSoda o1, CanOfSoda o2) {
		int result = o1.height - o2.height;
		if(result == 0) {
			result = o1.calories - o2.calories;
		}
		return result;
		
		//this does the same thing
		// ternary operator:
		// <condition> ? <if-true> : <if-false>
		//return result==0 ? o1.calories-o2.calories : result;
	}

}
