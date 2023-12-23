package decoratorDrinks;

public class Espresso extends Drink {

	public Espresso() {
		this.description = "Espresso de la casa";
	}
	
	@Override
	public int cost() {
		return 2000;
	}

	

}
