package Vista;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class vistaModificar extends JPanel {
	private static final long serialVersionUID = 1L;
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
		btnActualizar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnActualizar.setHorizontalAlignment(SwingConstants.LEADING);
		btnActualizar.setBounds(347, 430, 123, 29);
		add(btnActualizar);

		btnBorrarUsuario = new JButton("Borrar");
		btnBorrarUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnBorrarUsuario.setBounds(812, 432, 93, 29);
		add(btnBorrarUsuario);

		formattedTextFieldActualizarDNI = new JFormattedTextField();
		formattedTextFieldActualizarDNI.setBounds(429, 267, 115, 20);
		add(formattedTextFieldActualizarDNI);

		passwordFieldNuevaClave = new JPasswordField();
		passwordFieldNuevaClave.setBounds(429, 357, 115, 20);
		add(passwordFieldNuevaClave);

		passwordFieldActualizarClave = new JPasswordField();
		passwordFieldActualizarClave.setBounds(429, 309, 115, 20);
		add(passwordFieldActualizarClave);

		lblActualizarDNI = new JLabel("DNI:");
		lblActualizarDNI.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblActualizarDNI.setBounds(356, 267, 31, 19);
		add(lblActualizarDNI);

		lblActualizarClave = new JLabel("Antigua contraseña:");
		lblActualizarClave.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblActualizarClave.setBounds(243, 309, 144, 19);
		add(lblActualizarClave);

		lblActualizarUsuario = new JLabel("Actualizar Usuario");
		lblActualizarUsuario.setFont(new Font("Apple Color Emoji", Font.BOLD, 26));
		lblActualizarUsuario.setBounds(258, 148, 354, 25);
		add(lblActualizarUsuario);

		lblNuevaClave = new JLabel("Contrase\u00F1a Nueva:");
		lblNuevaClave.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNuevaClave.setBounds(252, 357, 135, 19);
		add(lblNuevaClave);

		formattedTextFieldBorrarDni = new JFormattedTextField();
		formattedTextFieldBorrarDni.setBounds(879, 269, 115, 20);
		add(formattedTextFieldBorrarDni);

		passwordFieldBorrarDni = new JPasswordField();
		passwordFieldBorrarDni.setBounds(879, 314, 115, 20);
		add(passwordFieldBorrarDni);

		lblBorrarDni = new JLabel("DNI:");
		lblBorrarDni.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblBorrarDni.setBounds(806, 269, 31, 19);
		add(lblBorrarDni);

		lblBorrarClave = new JLabel("Contrase\u00F1a:");
		lblBorrarClave.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblBorrarClave.setBounds(751, 314, 86, 19);
		add(lblBorrarClave);

		lblBorrarUsuario = new JLabel("Borrar Usuario");
		lblBorrarUsuario.setFont(new Font("Apple Color Emoji", Font.BOLD, 26));
		lblBorrarUsuario.setBounds(778, 150, 239, 25);
		add(lblBorrarUsuario);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnVolver.setBounds(103, 597, 144, 49);
		add(btnVolver);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Imagenes/bg.jpg"));
		background.setBounds(6, 6, 1279, 700);
		add(background);
	}
}
