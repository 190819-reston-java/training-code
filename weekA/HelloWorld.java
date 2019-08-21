// This is a comment (single line)

/*
 * This is a multi
 * line comment
 */
 
/**
 * This is a JavaDoc comment.
 * it's used by other tools to better document your code
 * you can add special tags:
 * @author Adam
 */

// Naming convention: classes are UpperCamelCase
public class HelloWorld {
	
	// We can declare variables with a statement:
	// <type> <identifier>;
	// ex: Object myObject;
	// This allows the variable to be used (only as that type though!)
	// We then can assign values to that variable using the assignment
	// operator, '=' :
	// <identifier> = <value>;
	// ex: myObject = new Object();
	// We can also combine those two lines:
	// <type> <identifier> = <value>;
	// ex: Object myObject = new Object();
	
	
	// Naming convention: constants (something that
	// doesn't change) are in SNAKE_CASE.
	// We create constants in Java using the keywords
	// static and final:
	static final String MY_STRING = "hi";
	
	// Naming convention: members of a class
	// should be lowerCamelCase:
	public static void main(String[] args) {
		System.out.println(MY_STRING);
	}
	
	
	
}