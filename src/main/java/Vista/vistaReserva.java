package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class vistaReserva extends JPanel
{
	private JLabel lblDniUsuario;
	private JLabel lblNombreUsuario;
	private JLabel lblHotelSeleccionado;
	private JLabel lblPrecio;
	private JLabel lblNumeroPersonas;
	private JLabel lblNumeroHabitaciones;
	private JLabel lblUbicacion;
	private JLabel lblFechaDeEntrada;
	private JLabel lblFechaDeSalida;
	public JTextField textField_DNIUsuario;
	public JTextField textField_NombreUsuario;
	public JTextField textField_hotelseleccionado;
	public JTextField textField_precio;
	public JTextField textField_numpersonas;
	public JTextField textField_NumeroHabitaciones;
	public JTextField textField_ubicacion;
	public JTextField textField_fechaDeEntrada;
	public JTextField textField_fechaDeSalida;	
	public JButton Cancelar_Reserva = new JButton("Cancelar");
	public  JButton Continuar_Reserva = new JButton("Continuar");
	
	
	public vistaReserva()
	{
		setLayout(null);
		
		Continuar_Reserva.setBounds(686, 514, 198, 48);
		add(Continuar_Reserva);
		
		Cancelar_Reserva.setBounds(6, 514, 198, 48);
		add(Cancelar_Reserva);
		
		lblHotelSeleccionado = new JLabel("Hotel seleccionado:");
		lblHotelSeleccionado.setBounds(247, 134, 124, 16);
		add(lblHotelSeleccionado);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(329, 182, 42, 16);
		add(lblPrecio);
		
		lblNumeroPersonas = new JLabel("Numero personas:");
		lblNumeroPersonas.setBounds(256, 230, 115, 16);
		add(lblNumeroPersonas);
		
		lblUbicacion = new JLabel("Ubicacion:");
		lblUbicacion.setBounds(305, 334, 66, 16);
		add(lblUbicacion);
		
		textField_ubicacion = new JTextField();
		textField_ubicacion.setEditable(false);
		textField_ubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_ubicacion.setBounds(504, 329, 214, 26);
		add(textField_ubicacion);
		textField_ubicacion.setColumns(10);
		
		textField_numpersonas = new JTextField();
		textField_numpersonas.setEditable(false);
		textField_numpersonas.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_numpersonas.setColumns(10);
		textField_numpersonas.setBounds(504, 225, 214, 26);
		add(textField_numpersonas);
		
		textField_precio = new JTextField();
		textField_precio.setEditable(false);
		textField_precio.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_precio.setColumns(10);
		textField_precio.setBounds(504, 177, 214, 26);
		add(textField_precio);
		
		textField_hotelseleccionado = new JTextField();
		textField_hotelseleccionado.setEditable(false);
		textField_hotelseleccionado.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_hotelseleccionado.setColumns(10);
		textField_hotelseleccionado.setBounds(504, 129, 214, 26);
		add(textField_hotelseleccionado);
		
		lblFechaDeEntrada = new JLabel("Fecha de entrada:");
		lblFechaDeEntrada.setBounds(261, 386, 110, 16);
		add(lblFechaDeEntrada);
		
		lblFechaDeSalida = new JLabel("Fecha de salida:");
		lblFechaDeSalida.setBounds(271, 440, 100, 16);
		add(lblFechaDeSalida);
		
		textField_fechaDeEntrada = new JTextField();
		textField_fechaDeEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_fechaDeEntrada.setEditable(false);
		textField_fechaDeEntrada.setColumns(10);
		textField_fechaDeEntrada.setBounds(504, 381, 214, 26);
		add(textField_fechaDeEntrada);
		
		textField_fechaDeSalida = new JTextField();
		textField_fechaDeSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_fechaDeSalida.setEditable(false);
		textField_fechaDeSalida.setColumns(10);
		textField_fechaDeSalida.setBounds(504, 435, 214, 26);
		add(textField_fechaDeSalida);
		
		lblNumeroHabitaciones = new JLabel("Numero habitaciones:");
		lblNumeroHabitaciones.setBounds(236, 281, 138, 16);
		add(lblNumeroHabitaciones);
		
		textField_NumeroHabitaciones = new JTextField();
		textField_NumeroHabitaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_NumeroHabitaciones.setEditable(false);
		textField_NumeroHabitaciones.setColumns(10);
		textField_NumeroHabitaciones.setBounds(504, 276, 214, 26);
		add(textField_NumeroHabitaciones);
		
		lblNombreUsuario = new JLabel("Nombre usuario:");
		lblNombreUsuario.setBounds(266, 92, 105, 16);
		add(lblNombreUsuario);
		
		textField_NombreUsuario = new JTextField();
		textField_NombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_NombreUsuario.setEditable(false);
		textField_NombreUsuario.setColumns(10);
		textField_NombreUsuario.setBounds(504, 87, 214, 26);
		add(textField_NombreUsuario);
		
		textField_DNIUsuario = new JTextField();
		textField_DNIUsuario.setEditable(false);
		textField_DNIUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_DNIUsuario.setColumns(10);
		textField_DNIUsuario.setBounds(504, 41, 214, 26);
		add(textField_DNIUsuario);
		
		lblDniUsuario = new JLabel("DNI usuario:");
		lblDniUsuario.setBounds(292, 46, 79, 16);
		add(lblDniUsuario);
	}
}
