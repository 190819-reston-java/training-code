package com.revature.collections;

import java.util.Comparator;

public class SparrowScale implements Comparator<Sparrow> {

	public int compare(Sparrow o1, Sparrow o2) {
		int out = 0;
		long sparrowOneWeight = o1.getWeight();
		long sparrowTwoWeight = o2.getWeight();
		out = (int) (sparrowOneWeight - sparrowTwoWeight);
		//we could just return out to compare weight
		// but if weights are equal, lets use default comparison:
		if(out == 0) {
			out = o1.compareTo(o2);
		}
		
		return out;
	}

}
