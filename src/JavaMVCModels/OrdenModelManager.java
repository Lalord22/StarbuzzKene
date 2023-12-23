package JavaMVCModels;


public class OrdenModelManager {
	private OrdenModel[] vector = new OrdenModel[100];
	
	private int can;
	
	public OrdenModelManager(){
		can = 0;
	}
	
	public String mostrarBasico(int indice) {
		return vector[indice].muestraBasica();
	}
	
	public void agregar(OrdenModel orden) {
		if(orden != null) {
		if(can < 100) {
			vector[can] =orden;
			can++;
			}
		}
	}
	
	public void eliminar(int indice) {
		
		if(indice < can) {
			for(int i = indice;i<can;i++) {
				vector[i] = vector[i+1];
			}
		}
	}
	
	public OrdenModel getOrdenModel(int index) {
		return vector[index];
		
	}
	
	public int getSize() {
	return can;
		
	}
	
}
