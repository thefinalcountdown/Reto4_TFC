package Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;

import Modelo.Hotel;
import Modelo.ModeloLista;

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

	public JButton btnSeleccionarHotel;
	private JTextArea textAreaHoteles;
	private ArrayList<String> al = new ArrayList<String>();
	ModeloLista ls=new ModeloLista();
	public  JList listaHoteles = new JList(ls);
	JScrollPane scrollPane = new JScrollPane(listaHoteles);
	public JButton btnCancelar = new JButton("Cancelar");
	
	
	
	public vistaHoteles() {
			setLayout(null);

			scrollPane.setBounds(200, 105, 300, 250);
			add(scrollPane);
			
			
			ls.rellenarModel();
			listaHoteles.setModel(ls);
			scrollPane.add(listaHoteles);
			
			listaHoteles.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
					"Seleccione un hotel:", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(235, 145, 168)));
			listaHoteles.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			listaHoteles.setSelectedIndex(0);
			listaHoteles.setBounds(200, 105, 300, 250);
			listaHoteles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaHoteles.setFixedCellHeight(50);
			listaHoteles.setFixedCellWidth(100);

			
			btnCancelar.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			btnCancelar.setBounds(50, 437, 138, 61);
			add(btnCancelar);

			
	}
}
