/**
 * @author Revature
 */
package com.revature.arraydemo;

import java.util.Arrays;

/**
 * @author Revature
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Let's work with some arrays.
		// Arrays are collections of fixed length.  We use
		// the Arrays utility class to manipulate them.
		arrayFun();

	}

	private static void arrayFun() {
		System.out.println("Hi from the IDE");
		
		//declaring and creating an array from literal:
		int[] myArray = {2, 4, 6, 7, 3};
		// Don't do the following:
		//int myArray2[];
		
		int[][] myMultiArray = {{1,2}, {3,4}, {5,6,7}};
		// Don't do this either:
		//int[] myMultiArray2[];
		
		// multiple types in one array ONLY if we upcast each type.
		// This is OK only because we have Objects in an array
		// of Objects.  Arrays have a fixed type!
		Object[] myTestArray = {"someString", Integer.valueOf(3)};
		
		// We use Arrays.toString(array) because it's much prettier
		// that just printing the array.
		System.out.println(Arrays.toString(myTestArray));
		
		System.out.println(Arrays.toString(myArray));
		
		// We can use both basic and enhanced for loops to loop
		// through arrays.  I encourage you to use the same code
		// each time -- only the names change!
		System.out.println("Looping through multi-dim arrays");
		for(int i=0;i<myMultiArray.length;i++) {
			for(int j=0;j<myMultiArray[i].length;j++) {
				System.out.println(myMultiArray[i][j]);
			}
		}
		
		//enhanced for loop version: (for-each loop)
		for(int[] innerArray : myMultiArray) {
			for(int num : innerArray) {
				System.out.println(num);
			}
		}
		
		// Arrays.deepToString is used to nicely display multi-dim
		// arrays.
		System.out.println(Arrays.toString(myMultiArray));
		System.out.println(Arrays.deepToString(myMultiArray));
		
		//another way of creating arrays -- just different syntax.
		//We can create an array of default values (null here) like so:
		String[] nullArray =  new String[10];
		String[] array1 = new String[] {"a","c","e","b","f"};
		String[] array2 = new String[] {"h", "i", "k", "l"};
		String[] array3 = new String[] {"1", "adam", "jeff", "mandy", "010"};
		
		//mixing literals and identifiers is fine:
		String[][] multi =  {array1, array2, array3};
		
		//enhanced for loop
		for(String[] array : multi) {
			System.out.println(Arrays.toString(array));
			
			//sorting -- it sorts in-place!
			System.out.println("Sorting array in-place:");
			Arrays.sort(array);
			System.out.println(Arrays.toString(array));
			
			//The array MUST be sorted before we search through it
			// otherwise, unpredictable behaviour.
			String lookfor = "jeff";
			System.out.println("Searching for: " + lookfor);
			System.out.println(Arrays.binarySearch(array,lookfor));
			
		}
		
	}

	
	
	
	
}
