package com.revature.reflectionapi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class InspectApp {

	public static void main(String[] args) throws ClassNotFoundException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException,
		InstantiationException, SecurityException {
		
		//Starting off, get the Class:
		// ? in generics mean don't worry about the Type
		Class<?> inspectClass = Class.forName("com.revature.reflectionapi.InspectMe");
		
		//We get Object class methods as well as our methods
		System.out.println(Arrays.toString(inspectClass.getMethods()));
		
		for(Method m : inspectClass.getMethods()) {
			
			InspectMe ourObj = (InspectMe) inspectClass.getConstructors()[0].newInstance();
			
			int intCounter = 0;
			
			if(m.getParameterTypes().length == 2) {
				for(Class<?> type : m.getParameterTypes()) {
					if(type.equals(int.class)) {
						intCounter++;
					}
				}
				
				if(intCounter == 2) {
					m.invoke(ourObj, 3,5);
				}
			}
		}
	}
}
