package Vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;

public class vistaReserva extends JPanel
{
	public JButton Cancelar_Reserva = new JButton("");
	public  JButton Continuar_Reserva = new JButton("");
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
	private JLabel lblReserva;
	private JSeparator separator;
	
	
	public vistaReserva()
	{
		setLayout(null);
		Continuar_Reserva.setIcon(new ImageIcon("/Users/marialaburu/MARIA/DAW/workspace/Reto4_TFC/Imagenes/continuar.png"));
		
		Continuar_Reserva.setBounds(966, 575, 184, 62);
		add(Continuar_Reserva);
		Cancelar_Reserva.setIcon(new ImageIcon("/Users/marialaburu/MARIA/DAW/workspace/Reto4_TFC/Imagenes/cancelar.png"));
		
		Cancelar_Reserva.setBounds(26, 575, 184, 62);
		add(Cancelar_Reserva);
		
		lblHotelSeleccionado = new JLabel("Hotel seleccionado:");
		lblHotelSeleccionado.setBounds(343, 237, 124, 16);
		add(lblHotelSeleccionado);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(425, 285, 42, 16);
		add(lblPrecio);
		
		lblNumeroPersonas = new JLabel("Numero personas:");
		lblNumeroPersonas.setBounds(352, 333, 115, 16);
		add(lblNumeroPersonas);
		
		lblUbicacion = new JLabel("Ubicacion:");
		lblUbicacion.setBounds(401, 437, 66, 16);
		add(lblUbicacion);
		
		textField_ubicacion = new JTextField();
		textField_ubicacion.setEditable(false);
		textField_ubicacion.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_ubicacion.setBounds(600, 432, 214, 26);
		add(textField_ubicacion);
		textField_ubicacion.setColumns(10);
		
		textField_numpersonas = new JTextField();
		textField_numpersonas.setEditable(false);
		textField_numpersonas.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_numpersonas.setColumns(10);
		textField_numpersonas.setBounds(600, 328, 214, 26);
		add(textField_numpersonas);
		
		textField_precio = new JTextField();
		textField_precio.setEditable(false);
		textField_precio.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_precio.setColumns(10);
		textField_precio.setBounds(600, 280, 214, 26);
		add(textField_precio);
		
		textField_alojamientoseleccionado = new JTextField();
		textField_alojamientoseleccionado.setEditable(false);
		textField_alojamientoseleccionado.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_alojamientoseleccionado.setColumns(10);
		textField_alojamientoseleccionado.setBounds(600, 232, 214, 26);
		add(textField_alojamientoseleccionado);
		
		lblFechaDeEntrada = new JLabel("Fecha de entrada:");
		lblFechaDeEntrada.setBounds(357, 489, 110, 16);
		add(lblFechaDeEntrada);
		
		lblFechaDeSalida = new JLabel("Fecha de salida:");
		lblFechaDeSalida.setBounds(367, 543, 100, 16);
		add(lblFechaDeSalida);
		
		textField_fechaDeEntrada = new JTextField();
		textField_fechaDeEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_fechaDeEntrada.setEditable(false);
		textField_fechaDeEntrada.setColumns(10);
		textField_fechaDeEntrada.setBounds(600, 484, 214, 26);
		add(textField_fechaDeEntrada);
		
		textField_fechaDeSalida = new JTextField();
		textField_fechaDeSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_fechaDeSalida.setEditable(false);
		textField_fechaDeSalida.setColumns(10);
		textField_fechaDeSalida.setBounds(600, 538, 214, 26);
		add(textField_fechaDeSalida);
		
		lblNumeroHabitaciones = new JLabel("Numero habitaciones:");
		lblNumeroHabitaciones.setBounds(332, 384, 138, 16);
		add(lblNumeroHabitaciones);
		
		textField_NumeroHabitaciones = new JTextField();
		textField_NumeroHabitaciones.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_NumeroHabitaciones.setEditable(false);
		textField_NumeroHabitaciones.setColumns(10);
		textField_NumeroHabitaciones.setBounds(600, 379, 214, 26);
		add(textField_NumeroHabitaciones);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(439, 189, 28, 16);
		add(lblDni);
		
		textField_DNI = new JTextField();
		textField_DNI.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_DNI.setEditable(false);
		textField_DNI.setColumns(10);
		textField_DNI.setBounds(600, 184, 214, 26);
		add(textField_DNI);
		
		textField_usuario = new JTextField();
		textField_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_usuario.setEditable(false);
		textField_usuario.setColumns(10);
		textField_usuario.setBounds(600, 141, 214, 26);
		add(textField_usuario);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(415, 146, 52, 16);
		add(lblUsuario);
		
		formattedTextFieldCodigo = new JFormattedTextField();
		formattedTextFieldCodigo.setBounds(41, 166, 132, 26);
		add(formattedTextFieldCodigo);
		
		lblCodigo = new JLabel("Codigo Promocional:");
		lblCodigo.setBounds(41, 141, 143, 14);
		add(lblCodigo);
		
		btnCodigo = new JButton("");
		btnCodigo.setIcon(new ImageIcon("/Users/marialaburu/MARIA/DAW/workspace/Reto4_TFC/Imagenes/comprobar.png"));
		btnCodigo.setBounds(51, 199, 112, 48);
		add(btnCodigo);
		
		lblReserva = new JLabel("RESERVA");
		lblReserva.setFont(new Font("Apple Color Emoji", Font.BOLD, 26));
		lblReserva.setBounds(475, 45, 124, 25);
		add(lblReserva);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(188, 75, 750, 12);
		add(separator);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Imagenes/bg.jpg"));
		background.setBounds(6, 6, 1279, 700);
		add(background);

	}
}
