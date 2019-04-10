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
	public JButton btnActualizar;
	public JButton btnBorrarUsuario;
	public JButton btnCancelar;
	public JPasswordField passwordFieldNuevaClave;
	public JPasswordField passwordFieldActualizarClave;
	public JPasswordField passwordFieldLoginClave;
	public JFormattedTextField formattedTextFieldLoginDNI;
	public JFormattedTextField formattedTextFieldActualizarDNI;
	private JLabel lblLoginDni;
	private JLabel lblLoginClave;
	private JLabel lblActualizarDNI;
	private JLabel lblActualizarClave;
	private JLabel lblActualizarUsuario;
	private JLabel lblLoginUsuario;
	private JLabel lblNuevaClave;

	public vistaLogin() {

		setLayout(null);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(537, 152, 89, 23);
		add(btnLogin);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setHorizontalAlignment(SwingConstants.LEADING);
		btnActualizar.setBounds(119, 150, 89, 23);
		add(btnActualizar);

		btnBorrarUsuario = new JButton("Borrar");
		btnBorrarUsuario.setBounds(537, 188, 89, 23);
		add(btnBorrarUsuario);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(91, 250, 89, 23);
		add(btnCancelar);

		formattedTextFieldLoginDNI = new JFormattedTextField();
		formattedTextFieldLoginDNI.setBounds(540, 40, 86, 20);
		add(formattedTextFieldLoginDNI);

		formattedTextFieldActualizarDNI = new JFormattedTextField();
		formattedTextFieldActualizarDNI.setBounds(171, 40, 86, 20);
		add(formattedTextFieldActualizarDNI);

		passwordFieldNuevaClave = new JPasswordField();
		passwordFieldNuevaClave.setBounds(171, 102, 86, 20);
		add(passwordFieldNuevaClave);

		passwordFieldActualizarClave = new JPasswordField();
		passwordFieldActualizarClave.setBounds(171, 71, 86, 20);
		add(passwordFieldActualizarClave);

		passwordFieldLoginClave = new JPasswordField();
		passwordFieldLoginClave.setBounds(540, 71, 86, 20);
		add(passwordFieldLoginClave);

		lblLoginDni = new JLabel("DNI:");
		lblLoginDni.setBounds(449, 43, 28, 16);
		add(lblLoginDni);

		lblLoginClave = new JLabel("Contrase\u00F1a:");
		lblLoginClave.setBounds(449, 74, 75, 16);
		add(lblLoginClave);

		lblActualizarDNI = new JLabel("DNI:");
		lblActualizarDNI.setBounds(23, 43, 28, 16);
		add(lblActualizarDNI);

		lblActualizarClave = new JLabel("Contrase\u00F1a:");
		lblActualizarClave.setBounds(23, 74, 75, 16);
		add(lblActualizarClave);

		lblActualizarUsuario = new JLabel("Actualizar Usuario");
		lblActualizarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblActualizarUsuario.setBounds(66, 11, 118, 14);
		add(lblActualizarUsuario);

		lblLoginUsuario = new JLabel("Login");
		lblLoginUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoginUsuario.setBounds(566, 11, 46, 14);
		add(lblLoginUsuario);

		lblNuevaClave = new JLabel("Contrase\u00F1a Nueva:");
		lblNuevaClave.setBounds(23, 105, 118, 16);
		add(lblNuevaClave);

	}
}
