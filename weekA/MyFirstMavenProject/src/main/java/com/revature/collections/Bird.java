package com.revature.collections;

public abstract class Bird {
	
	private String name;
	private String color;
	private boolean feathered;
	
	//chaining overloaded constructors
	
	public Bird(String name, String color, boolean feathered) {
		super();
		this.name = name;
		this.color = color;
		this.feathered = feathered;
	}
	
	public Bird(String name, String color) {
		this(name, color, true);
	}
	
	public Bird(String name) {
		this(name, "brown");
	}
	
	public Bird() {
		this("Reginald");
	}

	public void fly() {
		System.out.println(this.name + " is flying!");
	}
	
	public void sing() {
		System.out.println(this.name + " is singing!");
	}
	
	public abstract void sitStill();
	
	public abstract void tryEat();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFeathered() {
		return feathered;
	}

	public void setFeathered(boolean feathered) {
		this.feathered = feathered;
	}

	@Override
	public String toString() {
		return "Bird [name=" + name + ", color=" + color + ", feathered=" + feathered + "]";
	}

}
