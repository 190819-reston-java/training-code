package myPkg;

public class FruityDrink extends Drink {
	
	FruityDrink() {
		super();
		System.out.println("inside of FruityDrink's constructor");
	}
	
	@Override
	void getWarm() {
		// this needs to be reworked to work with getters and setters
		//  as is, it will tell us we're using temp incorrectly
		if (this.getTemperature().equals("refreshing")) {
			this.setTemperature("meh");
		} else if (this.getTemperature().equals("meh")) {
			this.setTemperature("blehhh");
		} else if (this.getTemperature().equals("blehhh")) {
			this.setTemperature("too hot!");
		}
	}
	
}