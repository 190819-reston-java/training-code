package com.revature.functional;

import java.util.Arrays;

public class CanOfSoda {
	
	public String flavor;
	public int height;
	public int radius;
	public boolean fizzy;
	public int calories;
	public String coloring;
	public String[] ingredients;
	
	public CanOfSoda(String flavor, int height, int radius, boolean fizzy,
			int calories, String coloring, String[] ingredients) {
		super();
		this.flavor = flavor;
		this.height = height;
		this.radius = radius;
		this.fizzy = fizzy;
		this.calories = calories;
		this.coloring = coloring;
		this.ingredients = ingredients;
	}
	
	public CanOfSoda(int height, int radius, int calories) {
		this("Cherry", height, radius, true, calories, "Red",
				new String[] {"sugar", "cherries", "water"});
	}

	@Override
	public String toString() {
		return "CanOfSoda [flavor=" + flavor + ", height=" + height + ", radius=" + radius + ", fizzy=" + fizzy
				+ ", calories=" + calories + ", coloring=" + coloring + ", ingredients=" + Arrays.toString(ingredients)
				+ "]";
	}
	
	

}
