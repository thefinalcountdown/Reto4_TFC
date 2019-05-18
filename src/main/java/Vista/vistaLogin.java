package Vista;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.Color;

public class vistaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	public JButton btnLogin;
	public JButton btnRegistro;
	public JButton btnModificar;
	public JPasswordField passwordFieldLoginClave;
	public JFormattedTextField formattedTextFieldLoginDNI;
	private JLabel lblLoginDni;
	private JLabel lblLoginClave;
	private JLabel lblLoginUsuario;
	private JSeparator separator;

	public vistaLogin() {

		setLayout(null);

		btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon("Imagenes/login.png"));
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnLogin.setBounds(519, 354, 134, 37);
		add(btnLogin);
		
		btnRegistro = new JButton("");
		btnRegistro.setIcon(new ImageIcon("Imagenes/nuevoRegistro.png"));
		btnRegistro.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRegistro.setBounds(411, 526, 172, 37);
		add(btnRegistro);
		
		btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon("Imagenes/modificarUsuario.png"));
		btnModificar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnModificar.setBounds(637, 530, 172, 29);
		add(btnModificar);

		formattedTextFieldLoginDNI = new JFormattedTextField();
		formattedTextFieldLoginDNI.setBounds(630, 202, 125, 29);
		add(formattedTextFieldLoginDNI);

		passwordFieldLoginClave = new JPasswordField();
		passwordFieldLoginClave.setBounds(630, 251, 125, 29);
		add(passwordFieldLoginClave);

		lblLoginDni = new JLabel("DNI:");
		lblLoginDni.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblLoginDni.setBounds(536, 202, 31, 19);
		add(lblLoginDni);

		lblLoginClave = new JLabel("Contrase\u00F1a:");
		lblLoginClave.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblLoginClave.setBounds(481, 255, 86, 19);
		add(lblLoginClave);

		lblLoginUsuario = new JLabel("LOGIN");
		lblLoginUsuario.setFont(new Font("Apple Color Emoji", Font.BOLD, 26));
		lblLoginUsuario.setBounds(572, 117, 103, 25);
		add(lblLoginUsuario);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Imagenes/bg.jpg"));
		background.setBounds(6, 6, 1279, 700);
		add(background);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(237, 154, 750, 12);
		add(separator);
		

	}
}
