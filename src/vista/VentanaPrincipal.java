package vista;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JavaMVCControllers.HelloWorldController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblStarbuzz;
	private JButton btnOrdenar;
	private JButton btnCerrarSesion;
	private JButton btnPendientes;
	

	
	private HelloWorldController control;

	/**
	 * Launch the application.
	 */
	

	public HelloWorldController getControl() {
		return control;
	}

	public void setControl(HelloWorldController control) {
		this.control = control;
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStarbuzz = new JLabel("STARBUZZ COFEE");
		lblStarbuzz.setBounds(48, 11, 286, 49);
		contentPane.add(lblStarbuzz);
		lblStarbuzz.setFont(new Font("Yu Gothic", Font.BOLD, 30));
		
		btnOrdenar= new JButton("Ordenar");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					control.abreVentanaPedidos();
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnOrdenar.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		btnOrdenar.setBounds(69, 128, 265, 63);
		contentPane.add(btnOrdenar);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.ventanaLogin();
				dispose();
			}
		});
		btnCerrarSesion.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		btnCerrarSesion.setBounds(69, 307, 265, 63);
		contentPane.add(btnCerrarSesion);
		
		btnPendientes = new JButton("Ver pedidos pendientes");
		btnPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					control.abreVentanaPendientes();
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnPendientes.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		btnPendientes.setBounds(69, 220, 265, 63);
		contentPane.add(btnPendientes);
	}

	
	

	public JButton getBtnOrdenar() {
		return btnOrdenar;
	}

	public void setBtnOrdenar(JButton btnOrdenar) {
		this.btnOrdenar = btnOrdenar;
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	public JButton getBtnPendientes() {
		return btnPendientes;
	}

	public void setBtnPendientes(JButton btnPendientes) {
		this.btnPendientes = btnPendientes;
	}

}
