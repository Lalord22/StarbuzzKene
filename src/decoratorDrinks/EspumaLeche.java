package decoratorDrinks;

public class EspumaLeche extends DecoratorDrink {

private final Drink drink;
	
	
	public EspumaLeche(Drink drink) {
		this.drink = drink;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return drink.getDescription() + " con Espuma y Leche";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return drink.cost()+ 300;
	}
	
	
	
}
