package com.revature.stringsdemo;

public class StringsDriver {

	public static void main(String[] args) {
		
		stringFun();

	}

	private static void stringFun() {
		
		String str1 = "hi"; // creates new String in pool
		
		String str2 = "hi"; // uses already existing "hi" String
		
		String str3 = new String("hi"); // creates String outside pool
		
		// == will see if references point to same object
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str2==str3);
		
		// .equals (with Strings) checks value equality
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str2.equals(str3));
		
		String str4 = "hi";
		
		System.out.println("str2 reassigned to 'hello'");
		str2 = "hello";
		
		System.out.println("str4 reassigned to Object referenced by str3");
		str4 = str3;
		
		// == will see if references point to same object
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str2==str3);
		
		// .equals (with Strings) checks value equality
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str2.equals(str3));
		
		System.out.println("Is str4 pointing to Object in pool?");
		System.out.println(str1==str4);
		System.out.println(str3==str4);
		
		// Strings are immutable, so all methods return a new String
		String test = "Here is my String -- isn't it cool?";
		String str5 = test.replaceAll(" ", "_");
		System.out.println(test);
		System.out.println(test.replaceAll(" ", "_"));
		System.out.println(str5);
		//producing Strings dynamically means they're outside the pool:
		System.out.println(test.replaceAll(" ", "_")==str5);
		
		System.out.println(test.charAt(3));
		System.out.println(test.charAt(4));
		
		String str = "WeiRD CaSe?";
		System.out.println(str);
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
		//Assorted String methods:
		
		System.out.println(test.length());
		System.out.println(test.endsWith("cool?"));
		System.out.println(test.trim());
		
		String stringToTrim = "      hi     ";
		System.out.println(stringToTrim);
		System.out.println(stringToTrim.trim());
		
		//method chaining
		System.out.println(test
				.toUpperCase()
				.substring(5)
				.concat("concat!    ")
				.trim()
				.replace("OO", "OOOOOOO")
				.substring(3, 30)
				//.repeat(2) //this is Java 11!
				);
		
		
		// split to cut string up into array
		// join to take multiple pieces and make a string
		
	}

}
