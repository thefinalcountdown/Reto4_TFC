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
		lblPulseParaComenzar.setFont(new Font("Apple Color Emoji", Font.BOLD, 28));
		lblPulseParaComenzar.setBounds(365, 153, 578, 58);
		add(lblPulseParaComenzar);
		
		
		btnBienvenida.setIcon(new javax.swing.ImageIcon("Imagenes/gif-aviao.gif"));
		btnBienvenida.setBounds(-13, -21, 1296, 800);
		add(btnBienvenida);
		
	}
}
