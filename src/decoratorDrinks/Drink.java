package decoratorDrinks;

import java.util.Scanner;

public abstract class Drink {
	
	protected String description = "NULL";

    public String getDescription() {
        return description;
    }

    public abstract int cost();
    
  
}
