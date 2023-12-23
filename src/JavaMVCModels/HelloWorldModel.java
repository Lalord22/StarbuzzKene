package JavaMVCModels;  
  
import java.io.*;  
import java.nio.file.Files;  
import java.nio.file.Paths;
import java.util.Arrays;

import decoratorDrinks.DarkRoast;
import decoratorDrinks.Decaf;
import decoratorDrinks.Drink;
import decoratorDrinks.Espresso;
import decoratorDrinks.EspumaLeche;
import decoratorDrinks.HouseBlend;
import decoratorDrinks.LecheBatida;
import decoratorDrinks.Moka;
import decoratorDrinks.Soja;  
  

public class HelloWorldModel { 
	
	OrdenModel orden = new OrdenModel();
	
	
	public void borrarProdEnPos(int n) {
		orden.borrarBebidaEnPos(n);
	}
	public void EraseDrinks() {
		orden.borrarTodasBebidas();
	}
	public void agregaProducto(Drink d,int costo) {
		if(orden.getCan()<100) {
			orden.agregarBebida(d);
			//System.out.print(d.getDescription());
			orden.sumaCuenta(costo);
			}
	}
	
	public String imprimeOrden() {
		return orden.imprimeOrden();
	}
	
	
	public static boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;
	    char[] correctPassword = { '1', '2', '3' };

	    if (input.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
	
public EspumaLeche decorarConEspuma(Drink bebida) {
	EspumaLeche s = new EspumaLeche(bebida);
	//System.out.print(s.getDescription());
	return s;
}
public Soja decorarConSoja(Drink bebida) {
	Soja s = new Soja(bebida);
	//System.out.print(s.getDescription());
	return s;
}
public Moka decorarConMoka(Drink bebida) {
	Moka s = new Moka(bebida);
	//System.out.print(s.getDescription());
	return s;
}
public LecheBatida decorarConLecheBatida(Drink bebida) {
	LecheBatida s = new LecheBatida(bebida);
	//System.out.print(s.getDescription());
	return s;
}
public Drink creaBebida(int n) {
	Drink hB = new HouseBlend();
	Drink es = new Espresso();
	Drink dR = new DarkRoast();
	Decaf de = new Decaf();
	switch(n) {
		case 1:
			return hB;
		case 2:
			return es;
		case 3:
			return dR;
		case 4:
			return de;
		default:
			return null;
	}
}
	
 public String getData() throws FileNotFoundException, IOException {  
  
  if (!(new File("F:\\file.txt").isFile())) {  
   // Create -- Make sure file exists -- the file before continuing    
   Files.createFile(Paths.get("F:\\file.txt"));  
  }  
  
  String data;  
    
  try (BufferedReader reader = new BufferedReader(  
   new FileReader("F:\\file.txt"))) {  
    
   StringBuilder string = new StringBuilder();  
  

   String line = reader.readLine();  
   string.append("<html>");  
      
   while (line != null) {  
   
    string.append(line);  
    string.append("<br />");  
    // Read the next line    
    line = reader.readLine();  
   }  
   string.append("</html>");  
   data = string.toString();  
  } catch (Exception er) {  
  
   data = er.getMessage();  
  }  
 
  return data;  
 }  
  
 public boolean writeData(String data) throws IOException, FileNotFoundException {  
  // Save the data to the File    
  try (BufferedWriter writer = new BufferedWriter(  
   new FileWriter("F:\\file.txt"))) {  
  
   writer.write(data);  
    
   return true;  
  } catch (Exception er) {  
   return false;  
  }  
 }
 
 
}   