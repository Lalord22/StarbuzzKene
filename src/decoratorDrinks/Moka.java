package decoratorDrinks;

public class Moka extends DecoratorDrink{
	
	private final Drink drink;
	
	
	public Moka(Drink drink) {
		this.drink = drink;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return drink.getDescription() + " con Moka";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return drink.cost()+500;
	}
	

}
