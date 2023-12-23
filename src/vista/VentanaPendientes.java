package vista;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import JavaMVCControllers.HelloWorldController;
import JavaMVCModels.OrdenModel;

public class VentanaPendientes extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JList<String> list;
	private JScrollBar scrollBar;
	private DefaultListModel<String> model;
	private JButton okButton;
	private JButton cancelButton;
	private HelloWorldController control;
	private JButton btnProcesados;
	private int index;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			VentanaPendientes dialog = new VentanaPendientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPendientes() {
		setBounds(100, 100, 644, 493);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 628, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 421, 628, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			
			btnProcesados = new JButton("Abrir Ventana Procesados");
			btnProcesados.addActionListener(this);
			buttonPane.add(btnProcesados);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(this);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblStarbuzz = new JLabel("STARBUZZ COFEE");
			lblStarbuzz.setFont(new Font("Yu Gothic", Font.BOLD, 30));
			lblStarbuzz.setBounds(10, 11, 286, 49);
			getContentPane().add(lblStarbuzz);
		}
		{
			JLabel lblPedidosPendientes = new JLabel("Pedidos Pendientes");
			lblPedidosPendientes.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblPedidosPendientes.setBounds(20, 39, 176, 33);
			getContentPane().add(lblPedidosPendientes);
		}
		{
			list = new JList<String>();
			model = new DefaultListModel<String>();
			list.setFont(new Font("Verdana", Font.PLAIN, 15));
			list.setBounds(0, 71, 601, 339);
			getContentPane().add(list);
		}
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(601, 71, 17, 339);
		getContentPane().add(scrollBar);
	}
	public void agregarPedidos(OrdenModel orden) {
		 model.addElement(orden.muestraBasica());
		 list.setModel(model);
	}
	
	public void eliminarPedidos(int index) {
		 model.remove(index);
		 list.setModel(model);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == cancelButton) {
		control.abreVentanaPrincipal();
		model.removeAllElements();
		dispose();
	}
	if(e.getSource() == okButton) {
		index = list.getSelectedIndex();
		if(list.getSelectedIndex()>-1) {
			int index = list.getSelectedIndex();
			control.abreVentanaOrden(index);
			dispose();
		}else {
			JOptionPane.showMessageDialog(null,"No hay ordenes en lista");
		}
		
	}
	if(e.getSource() == btnProcesados) {
		try {
			control.abrirVentanaProcesados();
			model.removeAllElements();
			dispose();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
	}
	
	
	public int getSelectedIndexVP() {
	if(index>=1) {
		return index;
	}
	else
		return 1;
	}

	public void setControl(HelloWorldController controller) {
		// TODO Auto-generated method stub
		this.control = controller;
	}
	
	public void resetGI() {
		model.removeAllElements();
	}
}
