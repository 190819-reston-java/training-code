package myPkg;

public class App {
	
	//makes use of varargs: variable number of arguments passed in as array
	public static void main(String[] args) {
		
		// Prints all given command line arguments:
		//for (int i = 0; i < args.length; i++) {
		//	System.out.println(args[i]);
		//}
		
		//we'll let the user set the temperature of their drink starting off
		Drink usersDrink = new Drink();
		
		// try-catch lets us do exception handling in Java
		try {
			usersDrink.setTemperature(args[0]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Usage: App <starting-temperature>");
			// This quits the program:
			System.exit(0);
		// this should be replaced with a custom Exception.
		} catch(RuntimeException e) {
			System.out.println(e);
			System.out.println("Using default temperature");
		} finally {
			System.out.println("This always runs unless system exits");
		}
		
		System.out.println(usersDrink.getTemperature());
		usersDrink.getWarm();
		System.out.println(usersDrink.getTemperature());
		
		// castingAndPolymorphismDemo();

	}
	
	static void castingAndPolymorphismDemo() {
		
		FruityDrink zingyTurmericGingerLemonade = new FruityDrink();
		FruityDrink frostyCoconutMintGreenTeaMocktail = new FruityDrink();
		
		System.out.println(zingyTurmericGingerLemonade.getTemperature());
		zingyTurmericGingerLemonade.getWarm();
		zingyTurmericGingerLemonade.getWarm();
		System.out.println(zingyTurmericGingerLemonade.getTemperature());
		
		System.out.println(frostyCoconutMintGreenTeaMocktail.getTemperature());
		
		Drink milk = new Drink();
		
		// create an Array of Drinks of size 3:
		Drink[] drinks = new Drink[3];
		
		drinks[0] = milk;
		drinks[1] = (Drink) zingyTurmericGingerLemonade;
		drinks[2] = (Drink) frostyCoconutMintGreenTeaMocktail;
		
		for(int i=0; i<3; i++) {
			System.out.println(drinks[i].getTemperature());
			drinks[i].getWarm();
			System.out.println(drinks[i].getTemperature());
		}
	}
	
}