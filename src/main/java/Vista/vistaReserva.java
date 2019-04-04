package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;

public class vistaReserva extends JPanel
{
	public static JButton Cancelar_Reserva = new JButton("Cancelar");
	public static  JButton Continuar_Reserva = new JButton("Continuar");
	
	public vistaReserva()
	{
		setLayout(null);
		
		Continuar_Reserva.setBounds(686, 514, 198, 48);
		add(Continuar_Reserva);
		
		Cancelar_Reserva.setBounds(6, 514, 198, 48);
		add(Cancelar_Reserva);
	}
}
