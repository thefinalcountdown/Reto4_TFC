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

public class vistaLogin extends JPanel{
	
	public static JTextField textFieldNombre;
	public static JTextField textFieldApellido;
	public static JTextField textFieldDniRegistro;
	public static JTextField textFieldDniLogin;
	public static JButton btnLogin;
	public static JButton btnRegistro;
	public static JButton btnActualizar;
	public static JButton btnBorrarUsuario;
	public static JTextField textFieldActualizarDNI;
	public static JPasswordField passwordFieldNuevaClave;
	public static JPasswordField passwordFieldActualizarClave;
	public static JPasswordField passwordFieldClaveRegistro;
	public static JPasswordField passwordFieldClaveLogin;
	
	public vistaLogin() {
		
		setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(343, 232, 89, 23);
		add(btnLogin);
		
		btnRegistro = new JButton("Registrar");
		btnRegistro.setHorizontalAlignment(SwingConstants.LEADING);
		btnRegistro.setBounds(102, 169, 89, 23);
		add(btnRegistro);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setHorizontalAlignment(SwingConstants.LEADING);
		btnActualizar.setBounds(316, 169, 89, 23);
		add(btnActualizar);
		
		btnBorrarUsuario = new JButton("Borrar");
		btnBorrarUsuario.setBounds(343, 266, 89, 23);
		add(btnBorrarUsuario);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(102, 40, 86, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(102, 71, 86, 20);
		add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldDniRegistro = new JTextField();
		textFieldDniRegistro.setBounds(102, 102, 86, 20);
		add(textFieldDniRegistro);
		textFieldDniRegistro.setColumns(10);
		
		textFieldDniLogin = new JTextField();
		textFieldDniLogin.setBounds(76, 233, 86, 20);
		add(textFieldDniLogin);
		textFieldDniLogin.setColumns(10);
		
		textFieldActualizarDNI = new JTextField();
		textFieldActualizarDNI.setColumns(10);
		textFieldActualizarDNI.setBounds(316, 40, 86, 20);
		add(textFieldActualizarDNI);
		
		passwordFieldNuevaClave = new JPasswordField();
		passwordFieldNuevaClave.setBounds(319, 133, 86, 20);
		add(passwordFieldNuevaClave);
		
		passwordFieldActualizarClave = new JPasswordField();
		passwordFieldActualizarClave.setBounds(316, 71, 86, 20);
		add(passwordFieldActualizarClave);
		
		passwordFieldClaveRegistro = new JPasswordField();
		passwordFieldClaveRegistro.setBounds(102, 133, 86, 20);
		add(passwordFieldClaveRegistro);
		
		passwordFieldClaveLogin = new JPasswordField();
		passwordFieldClaveLogin.setBounds(237, 233, 86, 20);
		add(passwordFieldClaveLogin);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 43, 46, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 74, 46, 14);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(20, 105, 46, 14);
		add(lblDni);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a:");
		lblClave.setBounds(20, 133, 85, 14);
		add(lblClave);
		
		JLabel lblLoginDni = new JLabel("DNI:");
		lblLoginDni.setBounds(20, 236, 46, 14);
		add(lblLoginDni);
		
		JLabel lblLoginClave = new JLabel("Contrase\u00F1a:");
		lblLoginClave.setBounds(172, 236, 71, 14);
		add(lblLoginClave);
		
		JLabel lblActualizarDNI = new JLabel("DNI:");
		lblActualizarDNI.setBounds(237, 43, 46, 14);
		add(lblActualizarDNI);
		
		JLabel lblActualizarClave = new JLabel("Contrase\u00F1a:");
		lblActualizarClave.setBounds(234, 71, 85, 14);
		add(lblActualizarClave);
		
		JLabel lblNuevoRegistro = new JLabel("Nuevo Registro");
		lblNuevoRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNuevoRegistro.setBounds(57, 11, 105, 14);
		add(lblNuevoRegistro);
		
		JLabel lblActualizarUsuario = new JLabel("Actualizar Usuario");
		lblActualizarUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblActualizarUsuario.setBounds(263, 11, 118, 14);
		add(lblActualizarUsuario);
		
		JLabel lblLoginUsuario = new JLabel("Login");
		lblLoginUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoginUsuario.setBounds(185, 203, 46, 14);
		add(lblLoginUsuario);
		
		JLabel lblNuevaClave = new JLabel("Contrase\u00F1a Nueva:");
		lblNuevaClave.setBounds(221, 136, 111, 14);
		add(lblNuevaClave);
	}
}
