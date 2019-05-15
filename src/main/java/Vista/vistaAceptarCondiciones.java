package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class vistaAceptarCondiciones extends JPanel {

	public JCheckBox chckbxAceptarCondiciones;
	public JButton btnAceptar;
	
	public vistaAceptarCondiciones() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Condiciones y Terminos de Uso");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(217, 24, 254, 14);
		add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sergio\\eclipse-workspace\\Reto4_TFC\\Imagenes\\condiciones.PNG"));
		lblNewLabel.setBounds(64, 54, 493, 284);
		add(lblNewLabel);
		
		chckbxAceptarCondiciones = new JCheckBox("Acepto las Condiciones y Terminos de Uso");
		chckbxAceptarCondiciones.setBounds(74, 404, 244, 23);
		add(chckbxAceptarCondiciones);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(524, 449, 89, 23);
		add(btnAceptar);

	}
}
