package decoratorDrinks;

public class Decaf extends Drink{

	public Decaf() {
		this.description = "Decaf de la casa";
	}
	
	@Override
	public int cost() {
		return 2000;
	}

}
