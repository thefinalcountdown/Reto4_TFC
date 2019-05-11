package Vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

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

	public vistaLogin() {

		setLayout(null);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnLogin.setBounds(380, 276, 125, 37);
		add(btnLogin);
		
		btnRegistro = new JButton("Nuevo Registro");
		btnRegistro.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRegistro.setBounds(246, 384, 163, 29);
		add(btnRegistro);
		
		btnModificar = new JButton("Modificar Usuario");
		btnModificar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnModificar.setBounds(472, 384, 183, 29);
		add(btnModificar);

		formattedTextFieldLoginDNI = new JFormattedTextField();
		formattedTextFieldLoginDNI.setBounds(474, 150, 125, 29);
		add(formattedTextFieldLoginDNI);

		passwordFieldLoginClave = new JPasswordField();
		passwordFieldLoginClave.setBounds(474, 199, 125, 29);
		add(passwordFieldLoginClave);

		lblLoginDni = new JLabel("DNI:");
		lblLoginDni.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblLoginDni.setBounds(380, 150, 31, 19);
		add(lblLoginDni);

		lblLoginClave = new JLabel("Contrase\u00F1a:");
		lblLoginClave.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblLoginClave.setBounds(325, 203, 86, 19);
		add(lblLoginClave);

		lblLoginUsuario = new JLabel("Login");
		lblLoginUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginUsuario.setBounds(422, 65, 55, 25);
		add(lblLoginUsuario);

	}
}
