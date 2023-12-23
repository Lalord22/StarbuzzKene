package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.sound.midi.ControllerEventListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JavaMVCControllers.HelloWorldController;
import JavaMVCModels.OrdenModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JList;

public class Orden extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private HelloWorldController control;
	private JLabel lbNombre_;
	private JLabel lblOrdenN_;
	private JLabel lblEstado;
	private JLabel lblTotal;
	private JLabel lblStatus;
	DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> list = new JList<>( model );
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Orden dialog = new Orden();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Orden() {
		setTitle("Orden");
		setBounds(100, 100, 601, 447);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblStarbuzz = new JLabel("STARBUZZ COFEE");
			lblStarbuzz.setFont(new Font("Yu Gothic", Font.BOLD, 30));
			lblStarbuzz.setBounds(10, 11, 286, 49);
			contentPanel.add(lblStarbuzz);
		}
		{
			JLabel lblNewLabel = new JLabel("Orden N.");
			lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblNewLabel.setBounds(10, 59, 116, 38);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Verdana", Font.PLAIN, 15)); 
			lblNombre.setBounds(10, 108, 116, 38);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblPedido = new JLabel("Pedido");
			lblPedido.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblPedido.setBounds(10, 157, 116, 38);
			contentPanel.add(lblPedido);
		}
		{
			lblOrdenN_ = new JLabel("");
			lblOrdenN_.setBackground(Color.WHITE);
			lblOrdenN_.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblOrdenN_.setBounds(108, 59, 217, 38);
			contentPanel.add(lblOrdenN_);
		}
		{
			lbNombre_ = new JLabel("");
			lbNombre_.setFont(new Font("Verdana", Font.PLAIN, 15));
			lbNombre_.setBackground(Color.WHITE);
			lbNombre_.setBounds(108, 122, 217, 38);
			contentPanel.add(lbNombre_);
		}
		
		lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblEstado.setBounds(347, 11, 79, 38);
		contentPanel.add(lblEstado);
		
		JLabel costoLbl = new JLabel("Total: ");
		costoLbl.setFont(new Font("Verdana", Font.PLAIN, 15));
		costoLbl.setBounds(357, 59, 116, 38);
		contentPanel.add(costoLbl);
		
		lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblTotal.setBackground(Color.WHITE);
		lblTotal.setBounds(423, 59, 116, 38);
		contentPanel.add(lblTotal);
		
		 lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblStatus.setBackground(Color.WHITE);
		lblStatus.setBounds(436, 11, 116, 38);
		contentPanel.add(lblStatus);
		
		
		list.setBounds(93, 170, 424, 173);
		contentPanel.add(list);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Procesar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//update al row aca 
						try {
							control.setStatus(control.getSelectedIndex()); //cambia status a Procesada
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						control.eliminarPendientes();
						JOptionPane.showMessageDialog(null, "Orden procesada con exito");
						try {
							control.abreVentanaPendientes();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							control.abreVentanaPendientes();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void fillList(OrdenModel orden) {
		int cantProductos = orden.getCan();
		for(int i=0;i<cantProductos;i++) {
			model.addElement(orden.imprimeProductoPos(i));
		}
	}
	
	
	public void setOrden(OrdenModel orden) {
		lblOrdenN_.setText(String.valueOf(orden.getNumeroOrden()));
		lbNombre_.setText(orden.getNomCliente());
		//fillList(orden);
		model.addElement(orden.getDescripcionBebidas());
		lblStatus.setText(orden.getStatus());
		lblTotal.setText(String.valueOf(orden.getCuenta()));
		
	}

	public void setControl(HelloWorldController controller) {
		this.control = controller;
		
	}
	public void resetList() {
		model.removeAllElements();
	}
	
}
