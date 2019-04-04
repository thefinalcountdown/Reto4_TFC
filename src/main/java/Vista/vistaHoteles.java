package Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;


import javax.swing.JButton;

import javax.swing.JList;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
public class vistaHoteles extends JPanel {

	/**
	 * Create the panel.
	 */
	JList list = new JList();
	public JButton btnSeleccionarHotel;
	private JTextArea textAreaHoteles;
	private ArrayList<String> al = new ArrayList<String>();
	public static JList listaLineas = new JList();
	JScrollPane scrollPane = new JScrollPane(listaLineas);
	public JButton btnCancelar = new JButton("Cancelar");

	
	public vistaHoteles() {
		setLayout(null);
			setLayout(null);

			btnSeleccionarParada = new JButton("Mostrar paradas");
			btnSeleccionarParada.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			btnSeleccionarParada.setBounds(518, 437, 138, 61);
			add(btnSeleccionarParada);

			scrollPane.setBounds(200, 105, 300, 250);
			add(scrollPane);

			listaLineas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
					"Seleccione la l\u00EDnea deseada:", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(235, 145, 168)));
			listaLineas.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			listaLineas.setSelectedIndex(0);
			listaLineas.setBounds(200, 105, 300, 250);
			listaLineas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaLineas.setFixedCellHeight(50);
			listaLineas.setFixedCellWidth(100);
			//add(listaLineas);

			
			btnCancelar.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			btnCancelar.setBounds(50, 437, 138, 61);
			add(btnCancelar);

	}
}
