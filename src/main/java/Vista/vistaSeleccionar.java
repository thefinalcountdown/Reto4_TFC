package Vista;

import javax.swing.JPanel;
import javax.swing.JButton;

public class vistaSeleccionar extends JPanel {

	public JButton btnRegistro;
	public JButton btnIrLogin;

	public vistaSeleccionar() {
		setLayout(null);

		btnRegistro = new JButton("Nuevo Registro");
		btnRegistro.setBounds(67, 120, 129, 51);
		add(btnRegistro);

		btnIrLogin = new JButton("Ir a Login");
		btnIrLogin.setBounds(268, 120, 129, 51);
		add(btnIrLogin);
	}
}
