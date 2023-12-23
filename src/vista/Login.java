package vista;
import JavaMVCModels.*;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import JavaMVCControllers.HelloWorldController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textBox;
	private HelloWorldController control;
	
	
	public Login() {
		setResizable(false);
		setTitle("Inicio Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel.setBounds(54, 89, 79, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblContrasea.setBounds(20, 125, 113, 25);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField(10);
		
		passwordField.setBounds(133, 129, 246, 20);
		contentPane.add(passwordField);
		
		textBox = new JTextField();
		textBox.setBounds(143, 93, 236, 20);
		contentPane.add(textBox);
		textBox.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("STARBUZZ COFEE");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 19));
		lblNewLabel_1.setBounds(133, 25, 198, 40);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textBox.getText();
				char [] pass = passwordField.getPassword();
				HelloWorldModel model = new HelloWorldModel();
				if(text.equals("lalo")) {
					if(model.isPasswordCorrect(pass)) {
						try {
							control.abreVentanaPrincipal();
							dispose(); 
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null,"Username or password invalid");
					}
					
				}else
					JOptionPane.showMessageDialog(null,"Username or password invalid");
			}
		});
		btnAceptar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnAceptar.setBounds(258, 183, 138, 25);
		contentPane.add(btnAceptar);
	}
	

	public void setController(HelloWorldController controller) {
		this.control = controller;
		
	}
}
