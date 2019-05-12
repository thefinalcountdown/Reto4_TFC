package Vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	public JPanel contentPane;

	public vistaBienvenida bienvenida;
	public vistaLogin login;
	public vistaRegistro registro;
	public vistaModificar modificar;
	public vistaRaiz raiz;
	public vistaReserva reserva;
	public vistaPago pago;
	public vistaHoteles alojamiento;

	public Ventana() {
		setLocationRelativeTo(null);
		setTitle("Reserva de hoteles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1200, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		bienvenida = new vistaBienvenida();
		contentPane.add(bienvenida);
		bienvenida.setLayout(null);

		login = new vistaLogin();
		contentPane.add(login);
		login.setLayout(null);

		registro = new vistaRegistro();
		contentPane.add(registro);
		registro.setLayout(null);

		modificar = new vistaModificar();
		contentPane.add(modificar);
		modificar.setLayout(null);

		raiz = new vistaRaiz();
		contentPane.add(raiz);
		raiz.setLayout(null);

		reserva = new vistaReserva();
		contentPane.add(reserva);
		reserva.setLayout(null);

		pago = new vistaPago();
		contentPane.add(pago);
		pago.setLayout(null);

		alojamiento = new vistaHoteles();
		contentPane.add(alojamiento);
		alojamiento.setLayout(null);
	}

	public void cambio_panel(JPanel ocultar, JPanel mostrar) {
		ocultar.setVisible(false);
		mostrar.setVisible(true);
	}
}
