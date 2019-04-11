package Vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class vistaModificar extends JPanel {
	public JButton btnBorrarUsuario;
	public JButton btnActualizar;
	public JFormattedTextField formattedTextFieldActualizarDNI;
	public JPasswordField passwordFieldNuevaClave;
	public JPasswordField passwordFieldActualizarClave;
	private JLabel lblActualizarDNI;
	private JLabel lblActualizarClave;
	private JLabel lblActualizarUsuario;
	private JLabel lblNuevaClave;
	private JLabel lblBorrarDni;
	private JLabel lblBorrarClave;
	private JLabel lblBorrarUsuario;
	public JPasswordField passwordFieldBorrarDni;
	public JFormattedTextField formattedTextFieldBorrarDni;
	public JButton btnVolver;

	public vistaModificar() {

		setLayout(null);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setHorizontalAlignment(SwingConstants.LEADING);
		btnActualizar.setBounds(175, 189, 89, 23);
		add(btnActualizar);

		btnBorrarUsuario = new JButton("Borrar");
		btnBorrarUsuario.setBounds(405, 189, 89, 23);
		add(btnBorrarUsuario);

		formattedTextFieldActualizarDNI = new JFormattedTextField();
		formattedTextFieldActualizarDNI.setBounds(175, 46, 86, 20);
		add(formattedTextFieldActualizarDNI);

		passwordFieldNuevaClave = new JPasswordField();
		passwordFieldNuevaClave.setBounds(175, 143, 86, 20);
		add(passwordFieldNuevaClave);

		passwordFieldActualizarClave = new JPasswordField();
		passwordFieldActualizarClave.setBounds(175, 97, 86, 20);
		add(passwordFieldActualizarClave);

		lblActualizarDNI = new JLabel("DNI:");
		lblActualizarDNI.setBounds(22, 48, 28, 16);
		add(lblActualizarDNI);

		lblActualizarClave = new JLabel("Contrase\u00F1a:");
		lblActualizarClave.setBounds(22, 99, 75, 16);
		add(lblActualizarClave);

		lblActualizarUsuario = new JLabel("Actualizar Usuario");
		lblActualizarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblActualizarUsuario.setBounds(79, 11, 118, 14);
		add(lblActualizarUsuario);

		lblNuevaClave = new JLabel("Contrase\u00F1a Nueva:");
		lblNuevaClave.setBounds(22, 145, 118, 16);
		add(lblNuevaClave);

		formattedTextFieldBorrarDni = new JFormattedTextField();
		formattedTextFieldBorrarDni.setBounds(408, 46, 86, 20);
		add(formattedTextFieldBorrarDni);

		passwordFieldBorrarDni = new JPasswordField();
		passwordFieldBorrarDni.setBounds(408, 94, 86, 20);
		add(passwordFieldBorrarDni);

		lblBorrarDni = new JLabel("DNI:");
		lblBorrarDni.setBounds(335, 49, 28, 16);
		add(lblBorrarDni);

		lblBorrarClave = new JLabel("Contrase\u00F1a:");
		lblBorrarClave.setBounds(323, 100, 75, 16);
		add(lblBorrarClave);

		lblBorrarUsuario = new JLabel("Borrar Usuario");
		lblBorrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBorrarUsuario.setBounds(346, 12, 118, 14);
		add(lblBorrarUsuario);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(89, 277, 89, 23);
		add(btnVolver);
	}
}
