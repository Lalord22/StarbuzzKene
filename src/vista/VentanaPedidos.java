package vista;
import decoratorDrinks.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import JavaMVCControllers.HelloWorldController;
import JavaMVCModels.HelloWorldModel;
import JavaMVCModels.OrdenModel;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;


public class VentanaPedidos extends JDialog implements ActionListener {	
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultListModel model;
	private JComboBox comboBebida;
	private JTextField nameField;
	private JList list;
	private JButton btnEliminar;
	private JButton btnEliminarTodo;
	private JButton btnAgregar;
	private JButton okButton;
	private JButton cancelButton;
	private Drink ventanaDrink;
	private OrdenModel orden = new OrdenModel();
	private HelloWorldController control= new HelloWorldController();
	private int toEdit;
	private boolean statusEditando = false;
	
	
	public OrdenModel getOrden() {
		return orden;
	}

	
	
	public void setControl(HelloWorldController control) {
		this.control = control;
	}

	JCheckBox chkEspuma = new JCheckBox("Espuma de Leche");
	JCheckBox chkSoja = new JCheckBox("Soja");
	JCheckBox chkMoca = new JCheckBox("Moca");
	JCheckBox chkLecheBatida = new JCheckBox("Leche Batida");
	
	public VentanaPedidos() {
		try {
			orden.setNumeroCuenta(control.giveNextOrderNumber());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setBounds(100, 100, 746, 664);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblStarbuzz = new JLabel("STARBUZZ COFEE");
			lblStarbuzz.setBounds(10, 11, 286, 49);
			lblStarbuzz.setFont(new Font("Yu Gothic", Font.BOLD, 30));
			contentPanel.add(lblStarbuzz);
		}
		model = new DefaultListModel();
		
		
		String beverage[] = {"-Seleccione-","House Blend","Espresso", "Dark Roast", "Decaf"};
		comboBebida = new JComboBox(beverage);
		comboBebida.setBounds(10, 127, 180, 32);
		comboBebida.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPanel.add(comboBebida);
		{
			JLabel lblNewLabel = new JLabel("Seleccion el tipo de bebida");
			lblNewLabel.setBounds(10, 99, 180, 31);
			contentPanel.add(lblNewLabel);
		}
		
		String extras[] = {"Sin extras","Steamed milk and mocha"};
		
		JLabel lblExtras = new JLabel("Extras");
		lblExtras.setBounds(10, 183, 180, 31);
		contentPanel.add(lblExtras);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(526, 210, 139, 32);
		btnAgregar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnAgregar.addActionListener(this);
		contentPanel.add(btnAgregar);
		
		list = new JList();
		list.setBounds(10, 267, 547, 267);
		list.setFont(new Font("Verdana", Font.PLAIN, 15));
		contentPanel.add(list);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(418, 549, 139, 32);
		btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		btnEliminarTodo = new JButton("Eliminar Todo");
		btnEliminarTodo.setBounds(258, 549, 139, 32);
		btnEliminarTodo.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnEliminarTodo.addActionListener(this);
		contentPanel.add(btnEliminarTodo);
		
		nameField = new JTextField();
		nameField.setBounds(10, 54, 276, 32);
		nameField.setFont(new Font("Verdana", Font.PLAIN, 15));
		nameField.setText("Nombre del Cliente");
		contentPanel.add(nameField);
		nameField.setColumns(10);
		chkEspuma.setBounds(20, 217, 153, 23);
		contentPanel.add(chkEspuma);
		chkSoja.setBounds(191, 217, 58, 23);
		contentPanel.add(chkSoja);
		chkMoca.setBounds(268, 217, 58, 23);
		contentPanel.add(chkMoca);
		chkLecheBatida.setSelected(true);
		chkLecheBatida.setBounds(372, 217, 148, 23);
		contentPanel.add(chkLecheBatida);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(329, 11, 372, 169);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnAsdasd = new JTextPane();
		txtpnAsdasd.setEditable(false);
		txtpnAsdasd.setText("\r\n\tBebidas\t\t Extras\r\nDark Roast .............\u20A12000\t| Espuma Leche ......\u20A1300\r\nDecaf     .................\u20A12000 | Leche batida ...... \u20A11000\r\nEspresso .................\u20A12000| Moca ................\u20A1500\r\nHouse Blend .............\u20A12000| Soja .......\u20A1600");
		txtpnAsdasd.setBounds(10, 11, 352, 147);
		panel.add(txtpnAsdasd);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 toEdit =  list.getSelectedIndex();
				 statusEditando = true;
				//System.out.print(toDelete);
				
			}
		});
		btnEditar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnEditar.setBounds(110, 549, 139, 32);
		contentPanel.add(btnEditar);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnEliminarTodo) {
			borrarLista();
		}
		if(e.getSource() == btnAgregar) {
			if(statusEditando) {
				if(toEdit > -1) {
					registraBebida();   // setea ventanaDrink a la bebida del menu
					model.remove(toEdit);   // la borra de la  lista visual 
					orden.agregaBebidaEnPos(ventanaDrink, toEdit);  // sustituye el producto y actualiza el precio en la orden
					try {
						control.editOrder(orden);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					statusEditando = false;
				}
			}else {
				if(nameField.getText()!="Nombre del Cliente" && nameField !=null) {
					registraBebida();
					orden.setNomCliente(nameField.getText());
					orden.agregarBebida(ventanaDrink);
					System.out.print(ventanaDrink.getDescription());
					orden.getDecripcionProductos();
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del cliente"
						     ,"Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		if(e.getSource() == cancelButton) {
			dispose();
			control.abreVentanaPrincipal();
		}
		if(e.getSource() == okButton) {
			if(statusEditando) {
				JOptionPane.showMessageDialog(null, "Debe terminar de editar y agregar la nueva bebida primero");
			}else {
				if(list.getModel().getSize()>0) {
					
					try {
						control.databaseADD(orden);                           //add to database
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//System.out.print(orden.getDecripcionProductos());
					control.agregarOrden(orden);
					borrarLista();
					dispose();
					control.abreVentanaPrincipal();
					
				}
	
			}
			
		}
		if(e.getSource() == btnEliminar) {
			int toDelete =  list.getSelectedIndex();
			//System.out.print(toDelete);
			if(toDelete > -1) {
				model.remove(toDelete);
				control.getModel().borrarProdEnPos(toDelete);
				orden.borrarBebidaEnPos(toDelete);
				try {
					control.editOrder(orden);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	private void eliminarExtra(int indice) {
		try {
		 if (indice>=0) {
		  model.removeElementAt(indice); 
		  
		  }
		}catch(Exception e){
		     JOptionPane.showMessageDialog(null, "Debe seleccionar un indice"
		     ,"Error", JOptionPane.ERROR_MESSAGE);
		     }
		  }
	
	private void borrarLista() {
		  model.clear();
		  control.getModel().EraseDrinks();
		}
	
	
	
	private void registraBebida() {
		Drink bebida = control.getModel().creaBebida(comboBebida.getSelectedIndex());
		Drink bebidaPreparada = control.getModel().creaBebida(comboBebida.getSelectedIndex());
		
		if(comboBebida.getSelectedIndex() != 0) {
			
			if(chkEspuma.isSelected()) {
				
				bebidaPreparada = control.getModel().decorarConEspuma(bebida);
			
			}
			if(chkSoja.isSelected()) {
				
				bebidaPreparada = control.getModel().decorarConSoja(bebida);
				
			}
			if(chkMoca.isSelected()) {
				
				bebidaPreparada = control.getModel().decorarConMoka(bebida);
			
			}
			if(chkLecheBatida.isSelected()) {
				
				bebidaPreparada = control.getModel().decorarConLecheBatida(bebida);
			
			}
			
	
			control.getModel().agregaProducto(bebidaPreparada,bebidaPreparada.cost());
			
			model.addElement(bebidaPreparada.getDescription());
			list.setModel(model);
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una bebida");
		}
		
		this.ventanaDrink = bebidaPreparada;
		
	}
}
