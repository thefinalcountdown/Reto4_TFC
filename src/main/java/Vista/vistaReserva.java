package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class vistaReserva extends JPanel
{
	public JButton Cancelar_Reserva = new JButton("Cancelar");
	public  JButton Continuar_Reserva = new JButton("Continuar");
	private JLabel lblDni;
	private JLabel lblUsuario;
	private JLabel lblHotelSeleccionado;
	private JLabel lblPrecio;
	private JLabel lblNumeroPersonas;
	private JLabel lblUbicacion;
	private JLabel lblFechaDeEntrada;
	private JLabel lblFechaDeSalida;
	private JLabel lblNumeroHabitaciones;
	public JTextField textField_DNI;
	public JTextField textField_usuario;
	public JTextField textField_ubicacion;
	public JTextField textField_numpersonas;
	public JTextField textField_precio;
	public JTextField textField_alojamientoseleccionado;
	public JTextField textField_fechaDeEntrada;
	public JTextField textField_fechaDeSalida;
	public JTextField textField_NumeroHabitaciones;
	public JFormattedTextField formattedTextFieldCodigo;
	private JLabel lblCodigo;
	public JButton btnCodigo;
	
	
	public vistaReserva()
	{
		setLayout(null);
		
		Continuar_Reserva.setBounds(686, 514, 198, 48);
		add(Continuar_Reserva);
		
		Cancelar_Reserva.setBounds(6, 514, 198, 48);
		add(Cancelar_Reserva);
		
		lblHotelSeleccionado = new JLabel("Hotel seleccionado:");
		lblHotelSeleccionado.setBounds(241, 156, 124, 16);
		add(lblHotelSeleccionado);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(323, 204, 42, 16);
		add(lblPrecio);
		
		lblNumeroPersonas = new JLabel("Numero personas:");
		lblNumeroPersonas.setBounds(250, 252, 115, 16);
		add(lblNumeroPersonas);
		
		lblUbicacion = new JLabel("Ubicacion:");
		lblUbicacion.setBounds(299, 356, 66, 16);
		add(lblUbicacion);
		
		textField_ubicacion = new JTextField();
		textField_ubicacion.setEditable(false);
		textField_ubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_ubicacion.setBounds(498, 351, 214, 26);
		add(textField_ubicacion);
		textField_ubicacion.setColumns(10);
		
		textField_numpersonas = new JTextField();
		textField_numpersonas.setEditable(false);
		textField_numpersonas.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_numpersonas.setColumns(10);
		textField_numpersonas.setBounds(498, 247, 214, 26);
		add(textField_numpersonas);
		
		textField_precio = new JTextField();
		textField_precio.setEditable(false);
		textField_precio.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_precio.setColumns(10);
		textField_precio.setBounds(498, 199, 214, 26);
		add(textField_precio);
		
		textField_alojamientoseleccionado = new JTextField();
		textField_alojamientoseleccionado.setEditable(false);
		textField_alojamientoseleccionado.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_alojamientoseleccionado.setColumns(10);
		textField_alojamientoseleccionado.setBounds(498, 151, 214, 26);
		add(textField_alojamientoseleccionado);
		
		lblFechaDeEntrada = new JLabel("Fecha de entrada:");
		lblFechaDeEntrada.setBounds(255, 408, 110, 16);
		add(lblFechaDeEntrada);
		
		lblFechaDeSalida = new JLabel("Fecha de salida:");
		lblFechaDeSalida.setBounds(265, 462, 100, 16);
		add(lblFechaDeSalida);
		
		textField_fechaDeEntrada = new JTextField();
		textField_fechaDeEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_fechaDeEntrada.setEditable(false);
		textField_fechaDeEntrada.setColumns(10);
		textField_fechaDeEntrada.setBounds(498, 403, 214, 26);
		add(textField_fechaDeEntrada);
		
		textField_fechaDeSalida = new JTextField();
		textField_fechaDeSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_fechaDeSalida.setEditable(false);
		textField_fechaDeSalida.setColumns(10);
		textField_fechaDeSalida.setBounds(498, 457, 214, 26);
		add(textField_fechaDeSalida);
		
		lblNumeroHabitaciones = new JLabel("Numero habitaciones:");
		lblNumeroHabitaciones.setBounds(230, 303, 138, 16);
		add(lblNumeroHabitaciones);
		
		textField_NumeroHabitaciones = new JTextField();
		textField_NumeroHabitaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_NumeroHabitaciones.setEditable(false);
		textField_NumeroHabitaciones.setColumns(10);
		textField_NumeroHabitaciones.setBounds(498, 298, 214, 26);
		add(textField_NumeroHabitaciones);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(337, 108, 28, 16);
		add(lblDni);
		
		textField_DNI = new JTextField();
		textField_DNI.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_DNI.setEditable(false);
		textField_DNI.setColumns(10);
		textField_DNI.setBounds(498, 103, 214, 26);
		add(textField_DNI);
		
		textField_usuario = new JTextField();
		textField_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_usuario.setEditable(false);
		textField_usuario.setColumns(10);
		textField_usuario.setBounds(498, 60, 214, 26);
		add(textField_usuario);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(313, 65, 52, 16);
		add(lblUsuario);
		
		formattedTextFieldCodigo = new JFormattedTextField();
		formattedTextFieldCodigo.setBounds(44, 60, 132, 26);
		add(formattedTextFieldCodigo);
		
		lblCodigo = new JLabel("Codigo Promocional:");
		lblCodigo.setBounds(44, 35, 124, 14);
		add(lblCodigo);
		
		btnCodigo = new JButton("Comprobar");
		btnCodigo.setBounds(64, 105, 89, 23);
		add(btnCodigo);
	}
}
