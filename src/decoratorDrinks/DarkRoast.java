package decoratorDrinks;

public class DarkRoast extends Drink{

	public DarkRoast() {
		this.description = "Dark Roast premium";
	}
	
	@Override
	public int cost() {
		return 2000;
	}

}
