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
		// Let's work with some arrays
		arrayFun();

	}

	private static void arrayFun() {
		System.out.println("Hi from the IDE");
		
		//declaring and creating an array from literal
		int[] myArray = {2, 4, 6, 7, 3};
		//int myArray2[];
		
		int[][] myMultiArray = {{1,2}, {3,4}, {5,6,7}};
		//int[] myMultiArray2[];
		
		// multiple types in one array ONLY if we upcast each type
		Object[] myTestArray = {"someString", Integer.valueOf(3)};
		
		System.out.println(Arrays.deepToString(myTestArray));
		
		System.out.println(Arrays.toString(myArray));
		
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
		
		System.out.println(Arrays.toString(myMultiArray));
		System.out.println(Arrays.deepToString(myMultiArray));
		
		//another way of creating arrays
		String[] array1 = new String[] {"a","c","e","b","f"};
		String[] array2 = new String[] {"h", "i", "k", "l"};
		String[] array3 = new String[] {"1", "adam", "jeff", "mandy", "010"};
		
		String[][] multi =  {array1, array2, array3};
		
		//enhanced for loop
		for(String[] array : multi) {
			System.out.println(Arrays.toString(array));
			
			//sorting
			System.out.println("Sorting array in-place:");
			Arrays.sort(array);
			System.out.println(Arrays.toString(array));
			
			String lookfor = "jeff";
			System.out.println("Searching for: " + lookfor);
			System.out.println(Arrays.binarySearch(array,lookfor));
			
		}
		
	}

	
	
	
	
}
