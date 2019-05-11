package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

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

	public vistaRegistro() {
		setLayout(null);

		btnRegistro = new JButton("Registrar");
		btnRegistro.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnRegistro.setBounds(640, 455, 184, 62);
		add(btnRegistro);

		btnCancelar = new JButton("Cancelar");
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
		formattedTextFieldDNI.setBounds(450, 140, 130, 23);
		add(formattedTextFieldDNI);

		formattedTextFieldNombre = new JFormattedTextField();
		formattedTextFieldNombre.setBounds(450, 198, 130, 23);
		add(formattedTextFieldNombre);

		formattedTextFieldApellido = new JFormattedTextField();
		formattedTextFieldApellido.setBounds(450, 254, 130, 23);
		add(formattedTextFieldApellido);

		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setBounds(450, 310, 130, 23);
		add(passwordFieldClave);

		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDni.setBounds(356, 142, 31, 19);
		add(lblDni);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNombre.setBounds(325, 200, 62, 19);
		add(lblNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblApellido.setBounds(325, 256, 62, 19);
		add(lblApellido);

		lblClave = new JLabel("Clave:");
		lblClave.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblClave.setBounds(344, 312, 43, 19);
		add(lblClave);

		lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(396, 67, 107, 25);
		add(lblNewLabel);
	}
}
