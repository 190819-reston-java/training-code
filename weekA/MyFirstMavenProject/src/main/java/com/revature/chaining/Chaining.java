package com.revature.chaining;

public class Chaining {
	
	String myNecessaryField1;
	String myNecessaryField2;

	public static void main(String[] args) {
		//Overloaded constructors
		System.out.println(new Chaining());
		System.out.println(new Chaining("two", "arguments"));
		System.out.println(new Chaining("one arg"));
		
		System.out.println((new Chaining()).toString());
		System.out.println((new Chaining()).toString("append this!"));
	}
	
	public Chaining(String arg1, String arg2) {
		super();
		System.out.println("2 args: " + arg1 + "," + arg2);
		this.myNecessaryField1 = arg1;
		this.myNecessaryField2 = arg2;
	}
	
	public Chaining(String arg1) {
		this(arg1, "default arg 2");
	}
	
	public Chaining() {
		//super();
		this("default arg 1", "default arg 2");
		System.out.println("no args");
	}

	@Override
	public String toString() {
		return "Chaining [myNecessaryField1=" + myNecessaryField1 + "]";
	}
	
	public String toString(String myAppendedString) {
		return this.toString() + myAppendedString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myNecessaryField1 == null) ? 0 : myNecessaryField1.hashCode());
		result = prime * result + ((myNecessaryField2 == null) ? 0 : myNecessaryField2.hashCode());
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
		Chaining other = (Chaining) obj;
		if (myNecessaryField1 == null) {
			if (other.myNecessaryField1 != null)
				return false;
		} else if (!myNecessaryField1.equals(other.myNecessaryField1))
			return false;
		if (myNecessaryField2 == null) {
			if (other.myNecessaryField2 != null)
				return false;
		} else if (!myNecessaryField2.equals(other.myNecessaryField2))
			return false;
		return true;
	}
	
	
	
//	@Override
//	public String toString() {
//		return "field 1: " + this.myNecessaryField1 + 
//				" field 2: " + this.myNecessaryField2;
//	}
	
	

}
