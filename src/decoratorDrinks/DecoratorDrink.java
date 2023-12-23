package decoratorDrinks;

public abstract class DecoratorDrink extends Drink{
	private int cantidad;
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public abstract String getDescription();
	
	
}
