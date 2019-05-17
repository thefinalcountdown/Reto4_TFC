package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class vistaBienvenida extends JPanel {
	
	public JButton btnBienvenida = new JButton("");
	
	public vistaBienvenida() {
		setLayout(null);
		
		JLabel lblPulseParaComenzar = new JLabel("PULSE PARA COMENZAR SU RESERVA");
		lblPulseParaComenzar.setFont(new Font("Apple Color Emoji", Font.BOLD, 18));
		lblPulseParaComenzar.setBounds(452, 503, 385, 16);
		add(lblPulseParaComenzar);
		
		
		btnBienvenida.setIcon(new javax.swing.ImageIcon("Imagenes/gif-aviao.gif"));
		btnBienvenida.setBounds(6, 6, 1279, 600);
		add(btnBienvenida);
		
	}
}
