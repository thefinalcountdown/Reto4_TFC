package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class vistaReserva extends JPanel
{
	public JButton Cancelar_Reserva = new JButton("Cancelar");
	public  JButton Continuar_Reserva = new JButton("Continuar");
	private JLabel lblHotelSeleccionado;
	private JLabel lblPrecio;
	private JLabel lblNumeroPersonas;
	private JLabel lblUbicacion;
	private JLabel lblFechaDeEntrada;
	private JLabel lblFechaDeSalida;
	private JLabel lblNumeroHabitaciones;
	public JTextField textField_ubicacion;
	public JTextField textField_numpersonas;
	public JTextField textField_precio;
	public JTextField textField_hotelseleccionado;
	public JTextField textField_fechaDeEntrada;
	public JTextField textField_fechaDeSalida;
	public JTextField textField_NumeroHabitaciones;
	
	public vistaReserva()
	{
		setLayout(null);
		
		Continuar_Reserva.setBounds(686, 514, 198, 48);
		add(Continuar_Reserva);
		
		Cancelar_Reserva.setBounds(6, 514, 198, 48);
		add(Cancelar_Reserva);
		
		lblHotelSeleccionado = new JLabel("Hotel seleccionado:");
		lblHotelSeleccionado.setBounds(238, 98, 124, 16);
		add(lblHotelSeleccionado);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(320, 146, 42, 16);
		add(lblPrecio);
		
		lblNumeroPersonas = new JLabel("Numero personas:");
		lblNumeroPersonas.setBounds(247, 194, 115, 16);
		add(lblNumeroPersonas);
		
		lblUbicacion = new JLabel("Ubicacion:");
		lblUbicacion.setBounds(296, 298, 66, 16);
		add(lblUbicacion);
		
		textField_ubicacion = new JTextField();
		textField_ubicacion.setEditable(false);
		textField_ubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_ubicacion.setBounds(495, 293, 214, 26);
		add(textField_ubicacion);
		textField_ubicacion.setColumns(10);
		
		textField_numpersonas = new JTextField();
		textField_numpersonas.setEditable(false);
		textField_numpersonas.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_numpersonas.setColumns(10);
		textField_numpersonas.setBounds(495, 189, 214, 26);
		add(textField_numpersonas);
		
		textField_precio = new JTextField();
		textField_precio.setEditable(false);
		textField_precio.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_precio.setColumns(10);
		textField_precio.setBounds(495, 141, 214, 26);
		add(textField_precio);
		
		textField_hotelseleccionado = new JTextField();
		textField_hotelseleccionado.setEditable(false);
		textField_hotelseleccionado.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_hotelseleccionado.setColumns(10);
		textField_hotelseleccionado.setBounds(495, 93, 214, 26);
		add(textField_hotelseleccionado);
		
		lblFechaDeEntrada = new JLabel("Fecha de entrada:");
		lblFechaDeEntrada.setBounds(252, 350, 110, 16);
		add(lblFechaDeEntrada);
		
		lblFechaDeSalida = new JLabel("Fecha de salida:");
		lblFechaDeSalida.setBounds(262, 404, 100, 16);
		add(lblFechaDeSalida);
		
		textField_fechaDeEntrada = new JTextField();
		textField_fechaDeEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_fechaDeEntrada.setEditable(false);
		textField_fechaDeEntrada.setColumns(10);
		textField_fechaDeEntrada.setBounds(495, 345, 214, 26);
		add(textField_fechaDeEntrada);
		
		textField_fechaDeSalida = new JTextField();
		textField_fechaDeSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_fechaDeSalida.setEditable(false);
		textField_fechaDeSalida.setColumns(10);
		textField_fechaDeSalida.setBounds(495, 399, 214, 26);
		add(textField_fechaDeSalida);
		
		lblNumeroHabitaciones = new JLabel("Numero habitaciones:");
		lblNumeroHabitaciones.setBounds(227, 245, 138, 16);
		add(lblNumeroHabitaciones);
		
		textField_NumeroHabitaciones = new JTextField();
		textField_NumeroHabitaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_NumeroHabitaciones.setEditable(false);
		textField_NumeroHabitaciones.setColumns(10);
		textField_NumeroHabitaciones.setBounds(495, 240, 214, 26);
		add(textField_NumeroHabitaciones);
	}
}
