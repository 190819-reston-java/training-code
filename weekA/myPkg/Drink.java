package myPkg;

public class Drink extends AbstractDrink {
	
	private String temperature = "refreshing";
	static int size = 20;
	
	Drink() {
		super();
		System.out.println("inside of Drink's constructor");
	}
	
	public void setTemperature(String inputTemperature) {
		if (inputTemperature.equals("refreshing") ||
			inputTemperature.equals("lukewarm") ||
			inputTemperature.equals("toasty") ||
			inputTemperature.equals("too hot!")) {
				this.temperature = inputTemperature;
			} else {
				//we'll come back to this and make it better
				System.out.println("invalid temperature");
			}
	}
	
	public String getTemperature() {
		return this.temperature;
	}
	
	void getWarm() {
		// this used to have: this.temperature == "refreshing"
		if (this.temperature.equals("refreshing")) {
			this.temperature = "lukewarm";
		} else if (this.temperature.equals("lukewarm")) {
			this.temperature = "toasty";
		} else if (this.temperature.equals("toasty")) {
			this.temperature = "too hot!";
		}
	}
	
}