package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class vistaReserva extends JPanel
{
	public static JButton Cancelar_Reserva = new JButton("Cancelar");
	public static  JButton Continuar_Reserva = new JButton("Continuar");
	private JLabel lblHotelSeleccionado;
	private JLabel lblPrecio;
	private JLabel lblNumeroHabitaciones;
	private JLabel lblUbicacion;
	public static JTextField textField_ubicacion;
	public static JTextField textField_numpersonas;
	public static JTextField textField_precio;
	public static JTextField textField_hotelseleccionado;
	
	public vistaReserva()
	{
		setLayout(null);
		
		Continuar_Reserva.setBounds(686, 514, 198, 48);
		add(Continuar_Reserva);
		
		Cancelar_Reserva.setBounds(6, 514, 198, 48);
		add(Cancelar_Reserva);
		
		lblHotelSeleccionado = new JLabel("Hotel seleccionado:");
		lblHotelSeleccionado.setBounds(238, 144, 124, 16);
		add(lblHotelSeleccionado);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(320, 192, 42, 16);
		add(lblPrecio);
		
		lblNumeroHabitaciones = new JLabel("Numero personas:");
		lblNumeroHabitaciones.setBounds(247, 240, 115, 16);
		add(lblNumeroHabitaciones);
		
		lblUbicacion = new JLabel("Ubicacion:");
		lblUbicacion.setBounds(296, 298, 66, 16);
		add(lblUbicacion);
		
		textField_ubicacion = new JTextField();
		textField_ubicacion.setEditable(false);
		textField_ubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_ubicacion.setBounds(495, 293, 130, 26);
		add(textField_ubicacion);
		textField_ubicacion.setColumns(10);
		
		textField_numpersonas = new JTextField();
		textField_numpersonas.setEditable(false);
		textField_numpersonas.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_numpersonas.setColumns(10);
		textField_numpersonas.setBounds(495, 235, 130, 26);
		add(textField_numpersonas);
		
		textField_precio = new JTextField();
		textField_precio.setEditable(false);
		textField_precio.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_precio.setColumns(10);
		textField_precio.setBounds(495, 187, 130, 26);
		add(textField_precio);
		
		textField_hotelseleccionado = new JTextField();
		textField_hotelseleccionado.setEditable(false);
		textField_hotelseleccionado.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_hotelseleccionado.setColumns(10);
		textField_hotelseleccionado.setBounds(495, 139, 130, 26);
		add(textField_hotelseleccionado);
	}
}
