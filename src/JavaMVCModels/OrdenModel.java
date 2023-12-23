package JavaMVCModels;

import decoratorDrinks.Drink;

public class OrdenModel {
	
	private String nomCliente;
	private int cuenta;
	private Drink Productos[] = new Drink[100];
	private int can;
	private int numeroOrden=0;
	private String status;
	private String descripcionBebidas;
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDescripcionBebidas() {
		return descripcionBebidas;
	}


	public void setDescripcionBebidas(String descripcionBebidas) {
		this.descripcionBebidas = descripcionBebidas;
	}


	public OrdenModel() {
		this.numeroOrden = 0;
		this.cuenta = 0;
		this.can=0;
		this.status = "Pendiente";
	}
	
	public void setNumeroCuenta(int c) {
		this.numeroOrden = c;
	}
	
	public String getNomCliente() {
		return nomCliente;
	}

	public String getDecripcionProductos() {
		String desc;
		if(can!= 0) {
			desc = Productos[0].getDescription()+ "\n";
		for(int i = 1; i <can;i++) {
			desc+= Productos[i].getDescription()+" "+"\r\n";
			}	
		}
		else
			desc = "Sin extras";
		
		return desc;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}



	public int getCuenta() {
		return cuenta;
	}



	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}



	public Drink[] getProductos() {
		return Productos;
	}
	
	public int getCan() {
		return can;
	}



	public void setCan(int can) {
		this.can = can;
	}



	public int getNumeroOrden() {
		return numeroOrden;
	}
	
	public void agregaBebidaEnPos(Drink bebida, int pos) {
		if(pos<can) {
			cuenta++;
			restaCuenta(Productos[pos].cost());
			this.Productos[pos] = bebida;
			sumaCuenta(bebida.cost());
		}
	}


	public String imprimeOrden() {
		String legend="";
		//legend = "Cliente: "+ nomCliente +"\n"
			//	+"Productos:\n";
		
		for(int i=0;i<can;i++) {
			legend += Productos[i].getDescription()+"\n";
		}
		//legend+="Costo Total: "+ cuenta;
		
		return legend;
	}
	
	public void sumaCuenta(int n) {
		this.cuenta += n;
	}
	public void restaCuenta(int n) {
		this.cuenta -= n;
	}
	
	
	public void agregarBebida(Drink beb){
		if(can < 100) {
			Productos[can] = beb;
			this.sumaCuenta(beb.cost());
			can++;
		}
	}
	public void borrarBebidaEnPos(int n) {
		if(n<can) {
			for(int i = n; i<can-1;i++) {
				cuenta -= Productos[i].cost();
				Productos[i] = Productos[i+1];
				can--;
				
			}
		}
		
	}
	
	public int cuentaTotal() {
		int total = 0;
		for(int i = 0; i<can;i++) {
			total += Productos[i].cost() ;
		}
		cuenta = total;
		return total;
	}
	
	public void borrarTodasBebidas() {
		for(int i = 0; i<can;i++) {
			Productos[i] = null;
		}
		can = 0;
	}
	
	public String muestraBasica() {
		return this.numeroOrden +"          "  + nomCliente+ "     ";
	}
	
	public String imprimeProductoPos(int pos) {
		
		if(pos<can) {
			String text;
			text = Productos[pos].getDescription();
			return text;
		}else {
			return "Error";
		}
		
	}
	
}
