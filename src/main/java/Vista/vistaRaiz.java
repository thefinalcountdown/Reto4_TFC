package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Modelo.Ubicacion;

import java.awt.Dimension;
import java.awt.Font;

public class vistaRaiz extends JPanel {
	
	public JLabel lblNewLabel;
	public JLabel lblDnde;
	public JLabel lblHuspedes;
	public static JComboBox comboBoxUbicacion = new JComboBox();
	public static JButton btnSum = new JButton("+");
	public static JButton btnRest = new JButton("-");
	public static JTextField txthuesped;
	public static JButton btnBuscar;
	public static int num = 0;
	
	/**
	 * Create the panel.
	 */
	public vistaRaiz() {
		
		setLayout(null);
		
		lblNewLabel = new JLabel("RESERVA TUS ALOJAMIENTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(25, 23, 401, 31);
		add(lblNewLabel);
		
		lblDnde = new JLabel("DONDE");
		lblDnde.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDnde.setBounds(26, 71, 69, 31);
		add(lblDnde);
		
		comboBoxUbicacion = new JComboBox();
		comboBoxUbicacion.setBounds(25, 97, 402, 29);
		add(comboBoxUbicacion);
		
		lblHuspedes = new JLabel("HUESPEDES");
		lblHuspedes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHuspedes.setBounds(25, 142, 109, 31);
		add(lblHuspedes);
		
		txthuesped = new JTextField("0");
		txthuesped.setBounds(72, 185, 51, 26);
		add(txthuesped);
		txthuesped.setEditable(false);
		
		btnSum.setBounds(125, 185, 43, 29);
		add(btnSum);
		
		btnRest.setBounds(25, 185, 43, 29);
		add(btnRest);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(329, 250, 97, 25);
		add(btnBuscar);	
		
		
		
	}
	
	public void comboboxUbicacion(ArrayList<Ubicacion> ubicaciones){
		for(int i=0; i< ubicaciones.size(); i++) {
			comboBoxUbicacion.addItem(ubicaciones.get(i).getUbicacion());
		}
	}
	
	}

