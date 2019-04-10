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
	public static JButton btnLogin;
	public static JButton btnActualizar;
	public static JButton btnBorrarUsuario;
	public static JButton btnCancelar;
	public static JPasswordField passwordFieldNuevaClave;
	public static JPasswordField passwordFieldActualizarClave;
	public static JPasswordField passwordFieldLoginClave;
	public static JFormattedTextField formattedTextFieldLoginDNI;
	public static JFormattedTextField formattedTextFieldActualizarDNI;

	public vistaLogin() {

		setLayout(null);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(323, 150, 89, 23);
		add(btnLogin);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setHorizontalAlignment(SwingConstants.LEADING);
		btnActualizar.setBounds(119, 150, 89, 23);
		add(btnActualizar);

		btnBorrarUsuario = new JButton("Borrar");
		btnBorrarUsuario.setBounds(323, 186, 89, 23);
		add(btnBorrarUsuario);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(91, 250, 89, 23);
		add(btnCancelar);

		formattedTextFieldLoginDNI = new JFormattedTextField();
		formattedTextFieldLoginDNI.setBounds(341, 40, 86, 20);
		add(formattedTextFieldLoginDNI);

		formattedTextFieldActualizarDNI = new JFormattedTextField();
		formattedTextFieldActualizarDNI.setBounds(119, 40, 86, 20);
		add(formattedTextFieldActualizarDNI);

		passwordFieldNuevaClave = new JPasswordField();
		passwordFieldNuevaClave.setBounds(119, 102, 86, 20);
		add(passwordFieldNuevaClave);

		passwordFieldActualizarClave = new JPasswordField();
		passwordFieldActualizarClave.setBounds(119, 71, 86, 20);
		add(passwordFieldActualizarClave);

		passwordFieldLoginClave = new JPasswordField();
		passwordFieldLoginClave.setBounds(341, 71, 86, 20);
		add(passwordFieldLoginClave);

		JLabel lblLoginDni = new JLabel("DNI:");
		lblLoginDni.setBounds(250, 43, 46, 14);
		add(lblLoginDni);

		JLabel lblLoginClave = new JLabel("Contrase\u00F1a:");
		lblLoginClave.setBounds(250, 74, 71, 14);
		add(lblLoginClave);

		JLabel lblActualizarDNI = new JLabel("DNI:");
		lblActualizarDNI.setBounds(23, 43, 46, 14);
		add(lblActualizarDNI);

		JLabel lblActualizarClave = new JLabel("Contrase\u00F1a:");
		lblActualizarClave.setBounds(23, 74, 85, 14);
		add(lblActualizarClave);

		JLabel lblActualizarUsuario = new JLabel("Actualizar Usuario");
		lblActualizarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblActualizarUsuario.setBounds(66, 11, 118, 14);
		add(lblActualizarUsuario);

		JLabel lblLoginUsuario = new JLabel("Login");
		lblLoginUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoginUsuario.setBounds(323, 11, 46, 14);
		add(lblLoginUsuario);

		JLabel lblNuevaClave = new JLabel("Contrase\u00F1a Nueva:");
		lblNuevaClave.setBounds(23, 105, 111, 14);
		add(lblNuevaClave);

	}
}
