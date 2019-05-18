package Vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.JSeparator;
import java.awt.Color;

public class vistaRegistro extends JPanel {
	private static final long serialVersionUID = 1L;
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
	private JSeparator separator;

	public vistaRegistro() {
		setLayout(null);

		btnRegistro = new JButton("");
		btnRegistro.setIcon(new ImageIcon("Imagenes/registrar.png"));
		btnRegistro.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRegistro.setBounds(893, 461, 184, 62);
		add(btnRegistro);

		btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon("Imagenes/cancelar.png"));
		btnCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnCancelar.setBounds(80, 455, 184, 62);
		add(btnCancelar);

		MaskFormatter formatterdni = null;
		try {
			formatterdni = new MaskFormatter("########U");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedTextFieldDNI = new JFormattedTextField(formatterdni);
		formattedTextFieldDNI.setBounds(165, 60, 88, 23);
		formattedTextFieldDNI = new JFormattedTextField();
		formattedTextFieldDNI.setBounds(596, 207, 130, 23);
		add(formattedTextFieldDNI);

		formattedTextFieldNombre = new JFormattedTextField();
		formattedTextFieldNombre.setBounds(596, 265, 130, 23);
		add(formattedTextFieldNombre);

		formattedTextFieldApellido = new JFormattedTextField();
		formattedTextFieldApellido.setBounds(596, 321, 130, 23);
		add(formattedTextFieldApellido);

		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setBounds(596, 377, 130, 23);
		add(passwordFieldClave);

		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDni.setBounds(502, 209, 31, 19);
		add(lblDni);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNombre.setBounds(471, 267, 62, 19);
		add(lblNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblApellido.setBounds(471, 323, 62, 19);
		add(lblApellido);

		lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblClave.setBounds(490, 379, 43, 19);
		add(lblClave);

		lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setFont(new Font("Apple Color Emoji", Font.BOLD, 26));
		lblNewLabel.setBounds(545, 96, 149, 25);
		add(lblNewLabel);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Imagenes/bg.jpg"));
		background.setBounds(6, 6, 1279, 700);
		add(background);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(244, 137, 750, 12);
		add(separator);
	}
}
