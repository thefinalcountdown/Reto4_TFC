package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaRegistro extends JPanel {
	
	public JButton btnCancelar;
	public JButton btnRegistro;
	public JPasswordField passwordFieldClave;
	public JFormattedTextField formattedTextFieldDNI;
	public JFormattedTextField formattedTextFieldNombre;
	public JFormattedTextField formattedTextFieldApellido;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblClave;
	private JLabel lblNewLabel;

	public vistaRegistro() {
		setLayout(null);

		btnRegistro = new JButton("Registrar");
		btnRegistro.setBounds(324, 266, 89, 23);
		btnRegistro.setHorizontalAlignment(SwingConstants.LEADING);
		add(btnRegistro);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(41, 266, 89, 23);
		add(btnCancelar);
		
		formattedTextFieldDNI = new JFormattedTextField();
		formattedTextFieldDNI.setBounds(165, 60, 88, 23);
		add(formattedTextFieldDNI);
		
		formattedTextFieldNombre = new JFormattedTextField();
		formattedTextFieldNombre.setBounds(165, 101, 88, 23);
		add(formattedTextFieldNombre);
		
		formattedTextFieldApellido = new JFormattedTextField();
		formattedTextFieldApellido.setBounds(165, 145, 88, 23);
		add(formattedTextFieldApellido);
		
		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setBounds(165, 189, 88, 23);
		add(passwordFieldClave);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(57, 64, 46, 14);
		add(lblDni);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(57, 105, 46, 14);
		add(lblNombre);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(57, 149, 46, 14);
		add(lblApellido);
		
		lblClave = new JLabel("Clave:");
		lblClave.setBounds(57, 193, 46, 14);
		add(lblClave);
		
		lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(169, 11, 96, 23);
		add(lblNewLabel);
	}
}
