package JavaMVCControllers;
import vista.*;

import java.sql.SQLException;

import JavaMVCModels.*;
public class HelloWorldController {
	private static OrdenModelManager manager= new OrdenModelManager();
	private Login view;
	private VentanaPedidos ventanaPedidos;
	private static VentanaPendientes ventanaPendientes = new VentanaPendientes();
	private VentanaPrincipal ventanaPrincipal;
	private static Orden orden = new Orden();
	private HelloWorldModel mod;
	private static VentanaProcesadas ventanaProcesadas = new VentanaProcesadas();
	private static OrdenModelProcesadasManager procesadas= new OrdenModelProcesadasManager() ;
	private static ConnectDB database = new ConnectDB();
	
	
	public void startApplication() {
		view.setVisible(true);
	}
	
	
	
	public void agregarOrden(OrdenModel orden) {
		//System.out.print(orden.getDecripcionProductos());
		ventanaPendientes.agregarPedidos(orden);
		manager.agregar(orden);   // aca ingresa la orden a la ventana de orden
	}
	
	public static void retrieveOrderDB(VentanaPendientes vP, VentanaProcesadas VPro,OrdenModelManager mpen, OrdenModelProcesadasManager mpro) throws Exception {
		try {
			database.loadOrders(vP,VPro, mpen,mpro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminarOrden(int index) {
		manager.eliminar(index);
	}
	
	public String getMessage() {
		try {
			HelloWorldModel model = new HelloWorldModel();
			return model.getData();
		}catch(Exception er) {
			return "There was an error";
		}
	}
	
	public boolean writeMessage(String message) {
		try {
			HelloWorldModel model = new HelloWorldModel();
			return model.writeData(message);
		}catch(Exception er) {
			return false;
		}
	}
	
	
	
	private void setOrdenModelProcesadasManager(OrdenModelProcesadasManager procesadas) {
		HelloWorldController.procesadas = procesadas;
		
	}

	private void setVentanaProcesadas(VentanaProcesadas ventanaProcesadas) {
		HelloWorldController.ventanaProcesadas= ventanaProcesadas;
		
	}

	private void setManager(OrdenModelManager manager2) {
		HelloWorldController.manager = manager2;
		
	}

	private void setModelo(HelloWorldModel mod) {
		this.mod = mod;
		
	}

	private void setOrden(Orden orden) {
		HelloWorldController.orden = orden;
		
	}

	private void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		
	}

	private void setVentanaPendientes(VentanaPendientes ventanaPendientes) {
		HelloWorldController.ventanaPendientes = ventanaPendientes;
		
	}

	private void setVentanaPedidos(VentanaPedidos ventanaPedidos) {
		this.ventanaPedidos= ventanaPedidos;
		
	}

	private void setLogin(Login view) {
		this.view = view;
		
	}

	public void abreVentanaPrincipal() {
		ventanaPrincipal.setVisible(true);	
	}

	public void abreVentanaPedidos() throws Exception {
		
		ventanaPedidos.setVisible(true);
		
	}
	
	public void abrirVentanaProcesados() throws Exception {
		ventanaProcesadas.resetGI();
		retrieveOrderDB(ventanaPendientes,ventanaProcesadas, manager,procesadas);
		ventanaProcesadas.setVisible(true);
	}

	public void abreVentanaPendientes() throws Exception {
		ventanaPendientes.resetGI();
		retrieveOrderDB(ventanaPendientes,ventanaProcesadas, manager,procesadas);
		ventanaPendientes.setVisible(true);	
	}
	
	public HelloWorldModel getModel() {
		return mod;
	}

	public void abreVentanaOrden(int index) {
		if(index>-1) {
			//reiniciar la lista
			orden.resetList();
			orden.setOrden(manager.getOrdenModel(index));
			orden.setVisible(true);
		}
		
		
	}
	
	public int getSelectedIndex() {
		return ventanaPendientes.getSelectedIndexVP();
	}
	
	//setea el status de la orden
	
	public void setStatus(int index) throws SQLException {
		// set status to Procesada
		//database.updateStatus(manager.getOrdenModel(index));    
	}
	
	
	public void eliminarPendientes() {
		if(getSelectedIndex()>= 1) {
		agregarOrdenProcesadas();
		ventanaPendientes.eliminarPedidos(getSelectedIndex()-1);
		//manager.eliminar(getSelectedIndex());
	}
		}
	
	
	public void agregarOrdenProcesadas() {
		procesadas.agregar(manager.getOrdenModel(getSelectedIndex()));
	}
	
	public void ventanaLogin() {
		view.setVisible(true);
	}

	public void editarOrden(int index) {
	//	manager[index];
		
	}
	
	public void databaseADD(OrdenModel orden) throws SQLException {
		//database.addSQL(orden);
	}
	
	public int giveNextOrderNumber() throws SQLException {
		int max;
		max = database.getMaxCode();
		return max;
	}
	public void editOrder(OrdenModel orden) throws SQLException {
		//database.updateOrder(orden);
	}
public static void main(String[] args) throws Exception {
		
		
		try {
			database.startDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ConnectDB.addSQL();
		HelloWorldController controller = new HelloWorldController();
		
		
		
		VentanaPedidos ventanaPedidos = new VentanaPedidos();
		
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		
		HelloWorldModel mod = new HelloWorldModel();
		Login view  = new Login ();
		
		controller.setOrdenModelProcesadasManager(procesadas);
		controller.setVentanaProcesadas(ventanaProcesadas);
		controller.setLogin(view);
		controller.setVentanaPedidos(ventanaPedidos);
		controller.setVentanaPendientes(ventanaPendientes);
		controller.setVentanaPrincipal(ventanaPrincipal);
		controller.setOrden(orden);
		controller.setModelo(mod);
		controller.setManager(manager);
		
		
		
		view.setController(controller);
		ventanaPedidos.setControl(controller);
		ventanaPendientes.setControl(controller);
		ventanaProcesadas.setControl(controller);
		procesadas.setController(controller);
		ventanaPrincipal.setControl(controller);
		orden.setControl(controller);
		
		
		
		controller.startApplication();
	
	}

}
