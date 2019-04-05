package Vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame
{
	public JPanel contentPane;

	public vistaRaiz raiz;
	public vistaReserva reserva;
	public vistaPago pago;
	public vistaHoteles hotel;
	
	
	
	public Ventana() 
	{
		setLocationRelativeTo(null);
		setTitle("Reserva de hoteles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		raiz = new vistaRaiz();
		contentPane.add(raiz);
		raiz.setLayout(null);

		
		reserva = new vistaReserva();
		contentPane.add(reserva);
		reserva.setLayout(null);
		
		
		pago = new vistaPago();
		contentPane.add(pago);
		pago.setLayout(null);
		
		hotel= new vistaHoteles();
		contentPane.add(hotel, "Lista Hoteles");
		hotel.setLayout(null);
	}
	
	public void cambio_panel(JPanel ocultar, JPanel mostrar)
	{
		ocultar.setVisible(false);
		mostrar.setVisible(true);
	}
}
