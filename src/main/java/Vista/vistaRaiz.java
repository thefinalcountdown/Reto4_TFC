package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class vistaRaiz extends JPanel {
	
	public JLabel lblNewLabel;
	public JLabel lblDnde;
	public JLabel lblHuspedes;
	public JComboBox comboBoxUbicacion;
	public JButton btnSum = new JButton("+");
	public JButton btnRest = new JButton("-");
	public JTextField txthuesped;
	public JButton btnBuscar;
	private JLabel lblFecha;
	public JDateChooser fechaIn;
	public JDateChooser fechaOut;
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
		
		comboBoxUbicacion = new JComboBox();
		comboBoxUbicacion.setBounds(24, 129, 402, 29);
		add(comboBoxUbicacion);
		
		lblHuspedes = new JLabel("HUESPEDES");
		lblHuspedes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHuspedes.setBounds(33, 188, 109, 31);
		add(lblHuspedes);
		
		txthuesped = new JTextField("1");
		txthuesped.setBounds(75, 231, 51, 26);
		add(txthuesped);
		txthuesped.setEditable(false);
		
		btnSum.setBounds(128, 231, 43, 29);
		add(btnSum);
		
		btnRest.setBounds(33, 231, 43, 29);
		add(btnRest);

		//Entrada
		lblFecha = new JLabel("FECHA ENTRADA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha.setBounds(33, 290, 138, 31);
		add(lblFecha);
		
		JCalendar calendarIn = new JCalendar();
		calendarIn.setBounds(200, 231, 200, 270);
		calendarIn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		calendarIn.setWeekOfYearVisible(false);
		calendarIn.setMaxDayCharacters(3);
		calendarIn.setMinSelectableDate(new Date());
		calendarIn.setSundayForeground(Color.BLUE);
		
		fechaIn = new JDateChooser(calendarIn, null, null, null);
		fechaIn.setBounds(33, 330, 130, 30);
		add(fechaIn);
		
		
		//Salida
		lblFecha = new JLabel("FECHA SALIDA");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha.setBounds(200, 290, 130, 31);
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
		fechaOut.setBounds(200, 330, 130, 30);
		add(fechaOut);
		
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(686, 514, 198, 48);
		add(btnBuscar);
		btnBuscar.setEnabled(false);
		
	
		
		
		
		
		
	}
	
	
}

