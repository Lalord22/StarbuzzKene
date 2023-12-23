package JavaMVCModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vista.VentanaPendientes;
import vista.VentanaProcesadas;

public class ConnectDB {
	static String dbURL = "jdbc:mysql://localhost:3306/StarbuzzP";
	static String username = "root";
	static String password = "";
	static Connection conn;
	
	
	
	public void startDB() {
		try {
			 
		    conn = DriverManager.getConnection(dbURL, username, password);
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
	}
	public void addSQL(OrdenModel orden) throws SQLException {
		String sql = "INSERT INTO table1 (numeroOrden,nombreCliente, bebida, estado, cuenta) VALUES (?, ?, ?, ?,?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, Integer.toString(orden.getNumeroOrden()));
		statement.setString(2, orden.getNomCliente());
		statement.setString(3, orden.imprimeOrden());
		statement.setString(4, orden.getStatus());
		statement.setString(5, Integer.toString(orden.cuentaTotal()));
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		}
	}
	public int getMaxCode() throws SQLException {
		int returned=0;
		PreparedStatement stat;
		ResultSet rs;
		String sql = "SELECT MAX(codigo) AS max_id FROM table1";
		stat = conn.prepareStatement(sql);
		rs = stat.executeQuery();
		if (rs.next()) {
		    returned = rs.getInt("max_id") + 1;
		}
		return returned;
	}
	
	public void updateOrder(OrdenModel orden) throws SQLException {
		String sql = "UPDATE table1 SET nombreCliente=?, bebida=?, cuenta=? WHERE numeroOrden=?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, orden.getNomCliente());
		statement.setString(2, orden.imprimeOrden());
		statement.setString(3, Integer.toString(orden.cuentaTotal()));
		statement.setString(4, Integer.toString(orden.getNumeroOrden()));
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
	}
	
	public void loadOrders(VentanaPendientes ventanaPen, VentanaProcesadas ventanaPro,OrdenModelManager managerPen,OrdenModelProcesadasManager procesadas  ) throws Exception {
		OrdenModel orden = new OrdenModel();
		
	    try {
	        java.sql.Statement s= conn.createStatement();
	        ResultSet rs = s.executeQuery("SELECT * FROM table1");

	        System.out.println("**************Resultats**************");
	        while ( rs.next() ) {
	            String nO = rs.getString("numeroOrden");
	            String nC = rs.getString("nombreCliente");
	            String be = rs.getString("bebida");
	            String st = rs.getString("estado");
	            String cu = rs.getString("cuenta");
	            orden.setNumeroCuenta(Integer.parseInt(nO));
	            orden.setNomCliente(nC);
	            orden.setDescripcionBebidas(be);
	            orden.setStatus(st);
	            orden.setCuenta(Integer.parseInt(cu));
	           
	            System.out.println(orden.getStatus());
	            System.out.println(orden.getNumeroOrden());
	            if(orden.getStatus().equals("Procesada")) {
	            	ventanaPro.agregarPedidos(orden);
	            	procesadas.agregar(orden);
	            	
	            }
	            	
	            else if(orden.getStatus().equals("Pendiente")) {
	            	ventanaPen.agregarPedidos(orden);
	            	managerPen.agregar(orden);
	            }     	          	            
	           
	        }
	       
	    } catch (Exception e) {
	        System.err.println("exception! ");
	        System.err.println(Integer.toString(orden.getNumeroOrden()));
	    }
	}
	
	public void updateStatus(OrdenModel orden) throws SQLException{
		String sql = "UPDATE table1 SET estado=? WHERE numeroOrden=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setString(1, "Procesada");
		statement.setString(2, Integer.toString(orden.getNumeroOrden()));
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("An existing user was updated successfully!");
		}
	}
	
	
	
}

