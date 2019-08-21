public class OperatorsAndControlFlowApp {
	
	/*
	* Operators are built-in functionality that uses common symbols.  In the expression
	* '4+9', '+' is the operator and we call '4' and '9' the operands.
	*
	* Programs typically execute in a top-to-bottom, inside-out order.  We can
	* change the "control flow" (also flow of control or flow of execution) using
	* control flow statements.  These statements let us branch (execute one block
	* or another) and loop (execute the same block multiple times.  Both types of
	* control flow statements are incredibly useful.
	*/
	public static void main(String[] args) {
		operatorExample();
		controlFlowExample();
	}
	
	public static void controlFlowExample() {
		
		System.out.println("lets look at control flow:");
		
		int a = 3;
		//The if statement does branching.  It takes a boolean expression (condition)
		// and runs the following block of code if the expression evaluates to true.
		if (a > 5) {
			System.out.println("greater than 5");
		} 
		//We can follow if statements with else statements.  Else statements
		// provide a block of code that executes if the if condition is false.
		// We can chain if {} else if {} else if {}...
		else if (a >= 3) {
			System.out.println("between 3 and 5");
		} else {
			System.out.println("a less than 3");
		}
		
		int b = 0;
		if (b > 6) {
			System.out.println("greater than 6");
		} else if (b > 1) {
			System.out.println("less than 1");
		} else if (a > 1) {
			System.out.println("less than 2");
		} else {
			System.out.println("between 1 and 5");
		}
		
		String s = "option 2";
		
		//switch statements also let us branch, but they take a value, then execute
		// one of their "cases" based on that value.  In this example, "case 2" will 
		// be printed.  Remember to put your break statements at the end of each case!
		// In java 8, you can switch on ints, shorts, bytes, chars and Strings.
		switch(s) {
			case "option 1":
				System.out.println("case 1");
				break;
			case "option 2":
				System.out.println("case 2");
				break;
			case "option 3":
				System.out.println("case 3");
				break;
			case "option FUN":
				System.out.println("case FUN!");
				break;
			default:
				System.out.println("default");
				break;
		}
		
		int num = 1;
		// A while loop is a looping structure, not a branching structure.
		// Looping involves running the same block of code multiple times, 
		// sometimes while modifying the valuse of a variable.
		// while loops take a condition and a block of code, and run the
		// block repeatedly as long as the condition is true.
		while(num < 10) {
			System.out.println("lets look at loops!");
			num += 1;
		}
		
		System.out.println("we've exited the while loop");
		
		// Since the condition in this while loop is false from the start,
		// this while loop never runs.
		while(num > 1000) {
			System.out.println("Uh oh");
		}

		// A do-while loop is very similar to a while loop.  The difference is
		// that the do-while loop will always run at least once.
		do {
			System.out.println("this always runs >=1 time");
			num += 1;
		} while(num < 15);
		
		// A for loop takes 3 things: an initializing statement, a condition,
		// and a statement that modifies the initialized value, that runs
		// after each circuit of the loop.  Technically we call these 
		// 'initialization' ; 'termination' ; 'increment'
		
		// Typically we use for loops when we want to loop a specified number
		// of times, and while loops when we want to loop a variable number
		// of times.
		for(int i = 0; i < 100; i++) {
			System.out.println(i % 9);
		}
		
		//skipping enhanced for look for now -- we need Arrays!

		num = 0;

		//continue and break are control flow statements that modify the
		// behaviour of the loop or switch they're found in.
		// 'break', in a loop, will stop executing the loop immediately, never
		// again even checking the condition.
		// 'continue' in a loop will skip the rest of the block of code only
		// for that circuit of the loop.  A continued loop will check the
		// condition again and will continue looping if the condition is true
		while(true) {
			num += 1;
			if(num % 2 == 0) {
				continue;
			}
			System.out.println(num);
			if(num > 12) {
				break;
			}
		}
		
		System.out.println("broken out of loop");
		
		
		
	}
	
	public static void operatorExample() {
		
		System.out.println("lets look at operators:" +
				"our operands will be 4 and 9.");
		System.out.println(4.0 + 9);
		System.out.println(4.0 - 9);
		System.out.println(4.0 * 9);
		System.out.println(4.0 / 9);
		System.out.println(4.0 % 9);
		
		// = is the assignment operator.  This line declares (int x) and assigns
		// the value 4 to x.
		int x = 4;
		
		// ++ and -- are increment and decrement:
		// shorthand ways of adding or subtracting one from a variable.
		// We can do pre/post-increment/decrement, demonstrated below.
		System.out.println(x++); //return 4, make x = 5
		System.out.println(x--); //return 5, make x = 4
		System.out.println(++x); //make x = 5, return 5
		System.out.println(--x); //make x = 4, return 4
		
		// +=, -= , %= are all shorthand
		// x += 1; is the same as x = x + 1;
		
		System.out.println("Lets look at relational" +
				"operators: arguments 4 and 9");
		System.out.println(4 < 9);
		System.out.println(4 <= 9);
		System.out.println(4 > 9);
		System.out.println(4 >= 9);
		System.out.println(4 == 9);
		System.out.println(4 != 9);
		
		System.out.println("Now for boolean ops:" +
				"arguments are true and false");
		// logical AND and OR:
		System.out.println(true & false);
		System.out.println(true | false);
		// logical AND and OR with "short-circuit operators". Short circuit
		// operators only evaluate operands until they know their result, then
		// the return that result, potentially leaving operands un-evaluated.
		System.out.println(true && false);
		System.out.println(true || false);
		// negation:
		System.out.println(!true);
		// exclusive or, or xor:
		System.out.println(true ^ false);
		
		// short circuit example: myExampleMethod() never gets evaluated.
		System.out.println((3 > 5) && myExampleMethod());
		
		// great use case for short circuit:
		// Object o;
		// Object o != null && o.myField > 3
	}
	
	public static boolean myExampleMethod() {
		System.out.println("thiswontrun");
		return true;
	}
}