package Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;

import Controlador.controladorHotel;
import Modelo.Hotel;
import Modelo.ModeloLista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
public class vistaHoteles extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel contentPane;
	public controladorHotel lista=new controladorHotel();
	JScrollPane scrollPane = new JScrollPane(listaHoteles);
	public static JComboBox listaHoteles;
//	public static JList listaHoteles;
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnContinuar = new JButton("Continuar");
	

	
	public vistaHoteles() {
		


			
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			
//			setLayout(null);
//			scrollPane.setBounds(200, 105, 300, 250);
//			add(scrollPane);
//			listaHoteles = new JList(lista);
//			lista.rellenarModel();
//			listaHoteles.setModel(lista);
			
			listaHoteles=new JComboBox();
			add(listaHoteles);
			
			listaHoteles.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
					"Seleccione un hotel:", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(235, 145, 168)));
			listaHoteles.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			listaHoteles.setBounds(200, 105, 300, 250);
			
//			listaHoteles.setSelectedIndex(0);
//			listaHoteles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			listaHoteles.setFixedCellHeight(50);
//			listaHoteles.setFixedCellWidth(100);

			
			btnCancelar.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			btnCancelar.setBounds(72, 437, 138, 61);
			add(btnCancelar);
		
			
			
			btnContinuar.setBounds(512, 456, 97, 25);
			add(btnContinuar);	

			
	}
}
