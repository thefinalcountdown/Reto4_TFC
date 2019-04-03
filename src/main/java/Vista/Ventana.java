package Vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame
{
	private JPanel contentPane = new JPanel();
	
	public vistaPago pago;
	
	public Ventana() 
	{
		setLocationRelativeTo(null);
		setTitle("Hola");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		
		pago = new vistaPago();
		contentPane.add(pago, "name_30846681032716");
	}
}
