package decoratorDrinks;

public class HouseBlend extends Drink {

	
	public HouseBlend() {
		this.description = "House Blend de la casa";
	}
	
	@Override
	public int cost() {
		return 2000;
	}
}
