package Vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class vistaLogin extends JPanel {

	public JButton btnLogin;
	public JButton btnRegistro;
	public JButton btnModificar;
	public JPasswordField passwordFieldLoginClave;
	public JFormattedTextField formattedTextFieldLoginDNI;
	private JLabel lblLoginDni;
	private JLabel lblLoginClave;
	private JLabel lblLoginUsuario;

	public vistaLogin() {

		setLayout(null);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(235, 128, 86, 32);
		add(btnLogin);
		
		btnRegistro = new JButton("Nuevo Registro");
		btnRegistro.setBounds(105, 265, 129, 51);
		add(btnRegistro);
		
		btnModificar = new JButton("Modificar Usuario");
		btnModificar.setBounds(323, 265, 129, 51);
		add(btnModificar);

		formattedTextFieldLoginDNI = new JFormattedTextField();
		formattedTextFieldLoginDNI.setBounds(235, 56, 86, 20);
		add(formattedTextFieldLoginDNI);

		passwordFieldLoginClave = new JPasswordField();
		passwordFieldLoginClave.setBounds(235, 87, 86, 20);
		add(passwordFieldLoginClave);

		lblLoginDni = new JLabel("DNI:");
		lblLoginDni.setBounds(119, 58, 28, 16);
		add(lblLoginDni);

		lblLoginClave = new JLabel("Contrase\u00F1a:");
		lblLoginClave.setBounds(119, 89, 75, 16);
		add(lblLoginClave);

		lblLoginUsuario = new JLabel("Login");
		lblLoginUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoginUsuario.setBounds(258, 11, 46, 14);
		add(lblLoginUsuario);

	}
}
