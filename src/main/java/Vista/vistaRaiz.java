package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class vistaRaiz extends JPanel {
	private static final long serialVersionUID = 1L;
	public JLabel lblNewLabel;
	public JLabel lblDnde;
	public JLabel lblHuspedes;
	public JLabel lblKids;
	public JLabel lblHabitaciones;
	public JComboBox comboBoxUbicacion;
	public JButton btnSumAdult = new JButton("+");
	public JButton btnRestAdult = new JButton("-");
	public JButton btnSumKids = new JButton("+");
	public JButton btnRestKids = new JButton("-");
	public JButton btnRestHab = new JButton("-");
	public JButton btnSumHab = new JButton("+");
	public JTextField txthuesped;
	public JTextField txtKids;
	public JTextField txtHab;
	public JButton btnBuscar;
	private JLabel lblFecha;
	public JDateChooser fechaIn;
	public JDateChooser fechaOut;
	public Date fechaEntrada = new Date();
	public JCheckBox chckbxWifi;
	public JCheckBox chckbxPiscina;
	public JCheckBox chckbxSpa;
	public JCheckBox chckbxParking;
	public JCheckBox chckbxAireAcondicionado;
	public JCheckBox chckbxRestaurante;
	public JCheckBox chckbxBar;
	public JCheckBox chckbxGimnasio;
	private JSeparator separator_1;
	private JSeparator separator_2;

	/**
	 * Create the panel.
	 */
	public vistaRaiz() {
		
		setLayout(null);
		
		lblNewLabel = new JLabel("RESERVA TUS ALOJAMIENTOS");
		lblNewLabel.setFont(new Font("Apple Color Emoji", Font.BOLD, 26));
		lblNewLabel.setBounds(419, 54, 420, 31);
		add(lblNewLabel);
		
		lblDnde = new JLabel("DÓNDE");
		lblDnde.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDnde.setBounds(573, 121, 69, 31);
		add(lblDnde);
		
		//ComboBox ubicaciones
		comboBoxUbicacion = new JComboBox();
		comboBoxUbicacion.setBounds(413, 157, 402, 29);
		add(comboBoxUbicacion);
		
		//Fecha Entrada
		lblFecha = new JLabel("LLEGADA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha.setBounds(415, 331, 138, 31);
		add(lblFecha);
		
		JCalendar calendarIn = new JCalendar();
		calendarIn.setBounds(200, 231, 200, 270);
		calendarIn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		calendarIn.setWeekOfYearVisible(false);
		calendarIn.setMaxDayCharacters(3);
		calendarIn.setMinSelectableDate(new Date());
		calendarIn.setSundayForeground(Color.BLUE);

		fechaIn = new JDateChooser(calendarIn, null, null, null);
		fechaIn.setBounds(415, 371, 130, 30);
				
		add(fechaIn);
		
		//Fecha Salida
		lblFecha = new JLabel("SALIDA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha.setBounds(697, 334, 130, 31);
		add(lblFecha);
		
		JCalendar calendarOut = new JCalendar();
		calendarOut.setBounds(200, 231, 200, 270);
		calendarOut.setFont(new Font("Tahoma", Font.PLAIN, 10));
		calendarOut.setWeekOfYearVisible(false);
		calendarOut.setMaxDayCharacters(3);
		Date diaOut = new Date();
		diaOut = new Date(diaOut.getTime() + (1000 * 60 * 60 * 24));
		
		calendarOut.setMinSelectableDate(diaOut);
		calendarOut.setSundayForeground(Color.BLUE);
		
		fechaOut = new JDateChooser(calendarOut, null, null, null);
		fechaOut.setBounds(697, 371, 130, 30);
		add(fechaOut);
		
		
		//NUMERO ADULTOS
		lblHuspedes = new JLabel("ADULTOS");
		lblHuspedes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHuspedes.setBounds(360, 215, 76, 31);
		add(lblHuspedes);
		
		txthuesped = new JTextField("1");
		txthuesped.setBounds(475, 217, 51, 26);
		add(txthuesped);
		txthuesped.setEditable(false);
		
		btnSumAdult.setBounds(528, 216, 43, 29);
		add(btnSumAdult);
		
		btnRestAdult.setBounds(433, 216, 43, 29);
		add(btnRestAdult);
		btnRestAdult.setEnabled(false);
		
		
		//NUMERO NIÑOS
		lblKids = new JLabel("NIÑOS");
		lblKids.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKids.setBounds(379, 253, 59, 31);
		add(lblKids);
		
		btnRestKids.setBounds(433, 254, 43, 29);
		add(btnRestKids);
		btnRestKids.setEnabled(false);
		
		txtKids = new JTextField("0");
		txtKids.setEditable(false);
		
		txtKids.setBounds(477, 254, 51, 26);
		add(txtKids);
		
		btnSumKids.setBounds(531, 257, 43, 29);
		add(btnSumKids);
		
		
		//NUMERO HABITACIONES
		lblHabitaciones = new JLabel("Nº HABITACIONES");
		lblHabitaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHabitaciones.setBounds(699, 216, 131, 31);
		add(lblHabitaciones);
		
		btnRestHab.setBounds(699, 250, 43, 29);
		add(btnRestHab);
		btnRestHab.setEnabled(false);
		
		txtHab = new JTextField("1");
		txtHab.setEditable(false);
		txtHab.setBounds(741, 250, 51, 26);
		add(txtHab);
		
		btnSumHab.setBounds(794, 250, 43, 29);
		add(btnSumHab);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon("/Users/marialaburu/MARIA/DAW/workspace/Reto4_TFC/Imagenes/buscar.png"));
		btnBuscar.setBounds(513, 583, 184, 62);
		add(btnBuscar);
		btnBuscar.setEnabled(false);
		
		JLabel lblServiciosDeseados = new JLabel("SELECCIONE LOS SERVICIOS DESEADOS: ");
		lblServiciosDeseados.setBounds(487, 459, 252, 16);
		add(lblServiciosDeseados);
		
		chckbxWifi = new JCheckBox("WI-FI");
		chckbxWifi.setBounds(197, 494, 69, 23);
		add(chckbxWifi);
		
		chckbxPiscina = new JCheckBox("Piscina");
		chckbxPiscina.setBounds(278, 494, 76, 23);
		add(chckbxPiscina);
		
		chckbxSpa = new JCheckBox("Spa");
		chckbxSpa.setBounds(364, 494, 54, 23);
		add(chckbxSpa);
		
		chckbxParking = new JCheckBox("Parking");
		chckbxParking.setBounds(428, 494, 79, 23);
		add(chckbxParking);
		
		chckbxAireAcondicionado = new JCheckBox("Aire acondicionado");
		chckbxAireAcondicionado.setBounds(519, 494, 153, 23);
		add(chckbxAireAcondicionado);
		
		chckbxRestaurante = new JCheckBox("Restaurante");
		chckbxRestaurante.setBounds(684, 494, 106, 23);
		add(chckbxRestaurante);
		
		chckbxBar = new JCheckBox("Bar");
		chckbxBar.setBounds(802, 494, 51, 23);
		add(chckbxBar);
		
		chckbxGimnasio = new JCheckBox("Gimnasio");
		chckbxGimnasio.setBounds(865, 494, 91, 23);
		add(chckbxGimnasio);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(204, 481, 750, 12);
		add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(205, 522, 750, 12);
		add(separator_1);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Imagenes/bg.jpg"));
		background.setBounds(6, 6, 1279, 700);
		add(background);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(238, 97, 750, 12);
		add(separator_2);
		
		
		
		
			
		
	}
}