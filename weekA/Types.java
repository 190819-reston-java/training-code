public class Types {

	// Built-in datatypes in Java.
	// These are all primitive values:
	int i;
	char c;
	double d;
	float f;
	short s;
	byte b;
	long l;
	boolean bo;
	// This is a reference value.  It's an Object, so o is a reference that
	// points to an actual Object stored in memory on the heap.
	Object o;
	
	public static void main(String[] args) {
		new Types().print();
	}
	
	void print() {
		// this will print the default values. Default values for numerics
		// will be 0.  Default Object is null.
		System.out.println("i: " + i);
		System.out.println("c: " + c);
		System.out.println("d: " + d);
		System.out.println("f: " + f);
		System.out.println("b: " + b);
		System.out.println("s: " + s);
		System.out.println("l: " + l);
		System.out.println("bo: " + bo);
		System.out.println("o: " + o);
	}
	
}