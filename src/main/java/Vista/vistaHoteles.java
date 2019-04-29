package Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Modelo.Hotel;

import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Font;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class vistaHoteles extends JPanel {

	public  JList<Hotel> listaHoteles = new JList<Hotel>();
	JScrollPane scrollPane = new JScrollPane();
	JScrollPane scrollPane_1 = new JScrollPane();
	public JList listaHabitaciones= new JList();

	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnContinuar = new JButton("Continuar");
	public JButton btnHabitaciones = new JButton("->");

	public vistaHoteles() {

		
		setLayout(null);
		scrollPane.setBounds(43, 35, 550, 350);
		add(scrollPane);
		scrollPane_1.setBounds(650, 60, 500, 289);
		add(scrollPane_1);
				scrollPane.setViewportView(listaHoteles);
		
		
		listaHoteles.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Seleccione un hotel:", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(235, 145, 168)));
		listaHoteles.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		listaHoteles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaHoteles.setFixedCellHeight(50);
		listaHoteles.setFixedCellWidth(100);

		btnCancelar.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCancelar.setBounds(72, 437, 138, 61);
		add(btnCancelar);

		btnContinuar.setBounds(512, 456, 97, 25);
		add(btnContinuar);
		
		btnHabitaciones.setBounds(602, 198, 36, 25);
		add(btnHabitaciones);
		

		
		
		scrollPane_1.setViewportView(listaHabitaciones);
		listaHabitaciones.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listaHabitaciones.setSelectedIndex(0);
		listaHabitaciones.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		listaHabitaciones.setFixedCellHeight(50);
		listaHabitaciones.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
								"Seleccione habitacion/es:", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(235, 145, 168)));

	}
}
