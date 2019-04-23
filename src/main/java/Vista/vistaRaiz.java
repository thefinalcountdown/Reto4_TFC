package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Font;

public class vistaRaiz extends JPanel {
	
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
	private JTextField textField;
	private JTextField textField_1;
	//private JDateChooser fechaOut = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
	/**
	 * Create the panel.
	 */
	public vistaRaiz() {
		
		setLayout(null);
		
		lblNewLabel = new JLabel("RESERVA TUS ALOJAMIENTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(33, 23, 401, 31);
		add(lblNewLabel);
		
		lblDnde = new JLabel("DONDE");
		lblDnde.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDnde.setBounds(33, 103, 69, 31);
		add(lblDnde);
		
		//ComboBox ubicaciones
		comboBoxUbicacion = new JComboBox();
		comboBoxUbicacion.setBounds(24, 129, 402, 29);
		add(comboBoxUbicacion);

		//Fecha Entrada
		lblFecha = new JLabel("FECHA ENTRADA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha.setBounds(33, 368, 138, 31);
		add(lblFecha);
		
		JCalendar calendarIn = new JCalendar();
		calendarIn.setBounds(200, 231, 200, 270);
		calendarIn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		calendarIn.setWeekOfYearVisible(false);
		calendarIn.setMaxDayCharacters(3);
		calendarIn.setMinSelectableDate(new Date());
		calendarIn.setSundayForeground(Color.BLUE);
		
		fechaIn = new JDateChooser(calendarIn, null, null, null);
		fechaIn.setBounds(33, 408, 130, 30);
		add(fechaIn);
		
		
		//Fecha Salida
		lblFecha = new JLabel("FECHA SALIDA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha.setBounds(200, 368, 130, 31);
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
		fechaOut.setBounds(200, 408, 130, 30);
		add(fechaOut);
		
		
		//NUMERO ADULTOS
		lblHuspedes = new JLabel("ADULTOS");
		lblHuspedes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHuspedes.setBounds(33, 188, 109, 31);
		add(lblHuspedes);
		
		txthuesped = new JTextField("1");
		txthuesped.setBounds(75, 231, 51, 26);
		add(txthuesped);
		txthuesped.setEditable(false);
		
		btnSumAdult.setBounds(128, 231, 43, 29);
		add(btnSumAdult);
		
		btnRestAdult.setBounds(33, 231, 43, 29);
		add(btnRestAdult);
		btnRestAdult.setEnabled(false);
		
		
		//NUMERO NIÑOS
		lblKids = new JLabel("NIÑOS");
		lblKids.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKids.setBounds(234, 188, 109, 31);
		add(lblKids);
		
		btnRestKids.setBounds(234, 231, 43, 29);
		add(btnRestKids);
		btnRestKids.setEnabled(false);
		
		txtKids = new JTextField("0");
		txtKids.setEditable(false);
		
		txtKids.setBounds(276, 231, 51, 26);
		add(txtKids);
		
		btnSumKids.setBounds(329, 231, 43, 29);
		add(btnSumKids);
		
		
		//NUMERO HABITACIONES
		lblHabitaciones = new JLabel("HABITACIONES");
		lblHabitaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHabitaciones.setBounds(33, 301, 109, 31);
		add(lblHabitaciones);
		
		btnRestHab.setBounds(159, 301, 43, 29);
		add(btnRestHab);
		btnRestHab.setEnabled(false);
		
		txtHab = new JTextField("1");
		txtHab.setEditable(false);
		txtHab.setBounds(201, 301, 51, 26);
		add(txtHab);
		
		btnSumHab.setBounds(254, 301, 43, 29);
		add(btnSumHab);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(686, 514, 198, 48);
		add(btnBuscar);
		btnBuscar.setEnabled(false);
			
		
	}
}