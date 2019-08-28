package com.revature.collections;

public abstract class Bird {
	
	public static int population = 0;
	
	private String name;
	private String color;
	private boolean feathered;
	private long weight;
	
	//chaining overloaded constructors
	
	public Bird(String name, String color, boolean feathered, long weight) {
		super();
		this.name = name;
		this.color = color;
		this.feathered = feathered;
		this.weight = weight;
	}
	
	public Bird(String name, String color, boolean feathered) {
		this(name, color, feathered, 6L);
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

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Bird [name=" + name + ", color=" + color + ", feathered=" + feathered + ", weight=" + weight + "]";
	}

	// hashCode is usually a number unique to each object
	// the only actual rule is that "if two objects are equal,
	// 		they need to have the same hashCode".
	// Don't worry about the guts of this
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
