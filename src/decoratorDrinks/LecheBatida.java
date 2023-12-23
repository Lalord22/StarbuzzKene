package decoratorDrinks;

public class LecheBatida extends DecoratorDrink{
	
	private final Drink drink;
	
	
	public LecheBatida(Drink drink) {
		this.drink = drink;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return drink.getDescription()  + " con Leche batida";
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return drink.cost()+ 1000;
	}
}
