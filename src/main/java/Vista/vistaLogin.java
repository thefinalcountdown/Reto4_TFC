package Vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaLogin extends JPanel{
	
	public static JTextField textFieldNombre;
	public static JTextField textFieldApellido;
	public static JTextField textFieldDniRegistro;
	public static JTextField textFieldClaveRegistro;
	public static JTextField textFieldDniLogin;
	public static JTextField textFieldClaveLogin;
	public static JButton btnCancelar;
	public static JButton btnLogin;
	public static JButton btnRegistro;
	
	public vistaLogin() {
		
		setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(343, 300, 89, 23);
		add(btnCancelar);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(343, 219, 89, 23);
		add(btnLogin);
		
		btnRegistro = new JButton("Registrar");
		btnRegistro.setHorizontalAlignment(SwingConstants.LEADING);
		btnRegistro.setBounds(102, 267, 89, 23);
		add(btnRegistro);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(105, 79, 86, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(105, 128, 86, 20);
		add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldDniRegistro = new JTextField();
		textFieldDniRegistro.setBounds(105, 176, 86, 20);
		add(textFieldDniRegistro);
		textFieldDniRegistro.setColumns(10);
		
		textFieldClaveRegistro = new JTextField();
		textFieldClaveRegistro.setBounds(105, 220, 86, 20);
		add(textFieldClaveRegistro);
		textFieldClaveRegistro.setColumns(10);
		
		textFieldDniLogin = new JTextField();
		textFieldDniLogin.setBounds(346, 128, 86, 20);
		add(textFieldDniLogin);
		textFieldDniLogin.setColumns(10);
		
		textFieldClaveLogin = new JTextField();
		textFieldClaveLogin.setBounds(346, 176, 86, 20);
		add(textFieldClaveLogin);
		textFieldClaveLogin.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 82, 46, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 131, 46, 14);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(20, 179, 46, 14);
		add(lblDni);
		
		JLabel lblClave = new JLabel("Contrase\u00F1a:");
		lblClave.setBounds(20, 223, 85, 14);
		add(lblClave);
		
		JLabel lblLoginDni = new JLabel("DNI:");
		lblLoginDni.setBounds(265, 131, 46, 14);
		add(lblLoginDni);
		
		JLabel lblLoginClave = new JLabel("Contrase\u00F1a:");
		lblLoginClave.setBounds(265, 179, 71, 14);
		add(lblLoginClave);
	}
}
