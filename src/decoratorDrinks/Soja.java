package decoratorDrinks;

public class Soja extends DecoratorDrink {
	private final Drink drink;
	
	
	public Soja(Drink drink) {
		this.drink = drink;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.drink.getDescription()  + " con Soja";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return drink.cost()+ 600;
	}
}
