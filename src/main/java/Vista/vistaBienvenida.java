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
		lblPulseParaComenzar.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblPulseParaComenzar.setBounds(452, 503, 304, 16);
		add(lblPulseParaComenzar);
		
		
		btnBienvenida.setIcon(new javax.swing.ImageIcon("Imagenes/gif-aviao.gif"));
		btnBienvenida.setBounds(6, 6, 1200, 600);
		add(btnBienvenida);
		
	}
}
