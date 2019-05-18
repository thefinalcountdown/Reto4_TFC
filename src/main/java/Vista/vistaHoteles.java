package Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import Modelo.Hotel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Font;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class vistaHoteles extends JPanel {

	private static final long serialVersionUID = 1L;
	public JList<Hotel> listaAlojamientos = new JList<Hotel>();
	JScrollPane scrollPane = new JScrollPane();
	public JScrollPane scrollPane_1 = new JScrollPane();
	
	public JTable habitaciones = new JTable();
	public DefaultTableModel modeloTabla;

	public JButton btnCancelar = new JButton("");
	public JButton btnContinuar = new JButton("");
	public JButton btnHabitaciones = new JButton("->");
	
	public JLabel lblTipo = new JLabel("<html>Seleccione el tipo de alojamiento:</html>");
	private String[] tipoAloj= {"Todos", "Apartamento", "Casa", "Hotel"};
	public JComboBox comboTipo = new JComboBox(tipoAloj);
//	public JButton btnTipo = new JButton("Filtrar");
	public JButton btn_habitacion_duda;
	public JPanel panel = new JPanel();
	public JTextArea texto_panel = new JTextArea();
	private final JLabel lblHabitaciones = new JLabel("<html>Seleccione tipo de habitaci\u00f3n:</html>");
	private String[] estrellas = {"Estrellas", "*****", "****", "***", "**", "*"};
	public JComboBox comboEstrellas = new JComboBox(estrellas);
	private final JLabel lblAlojamientos = new JLabel("ALOJAMIENTOS");
	private final JSeparator separator = new JSeparator();

	public vistaHoteles() {

		setLayout(null);
		
		btn_habitacion_duda = new JButton("?");
		btn_habitacion_duda.setBounds(1140, 528, 36, 37);
		btn_habitacion_duda.setVisible(false);
		
		add(btn_habitacion_duda);
		scrollPane.setBounds(12, 195, 550, 350);
		add(scrollPane);
		scrollPane_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_1.setBounds(657, 228, 522, 289);
		add(scrollPane_1);
		scrollPane.setViewportView(listaAlojamientos);

		listaAlojamientos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Seleccione un alojamiento:", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(235, 145, 168)));
		listaAlojamientos.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		listaAlojamientos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaAlojamientos.setFixedCellHeight(50);
		listaAlojamientos.setFixedCellWidth(100);
		lblAlojamientos.setFont(new Font("Apple Color Emoji", Font.BOLD, 26));
		lblAlojamientos.setBounds(511, 43, 201, 25);
		
		add(lblAlojamientos);
		separator.setForeground(Color.BLACK);
		separator.setBounds(244, 75, 750, 12);
		
		add(separator);
		btnCancelar.setIcon(new ImageIcon("/Users/marialaburu/MARIA/DAW/workspace/Reto4_TFC/Imagenes/cancelar.png"));
		btnCancelar.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCancelar.setBounds(29, 595, 184, 62);
		add(btnCancelar);
		btnContinuar.setIcon(new ImageIcon("/Users/marialaburu/MARIA/DAW/workspace/Reto4_TFC/Imagenes/continuar.png"));
		btnContinuar.setBounds(990, 592, 189, 62);
		add(btnContinuar);

		btnHabitaciones.setBounds(582, 383, 36, 25);
		add(btnHabitaciones);

		String columna[] = {""};
		modeloTabla = new DefaultTableModel(columna, 0) {	@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }};
		habitaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_1.setViewportView(habitaciones);
		
		habitaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		habitaciones.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		habitaciones.setRowHeight(50);
		habitaciones.setRowMargin(20);
		
		
		comboTipo.setBounds(209, 115, 167, 27);
		add(comboTipo);
		
		
		lblTipo.setBounds(37, 115, 199, 27);
		add(lblTipo);
		lblHabitaciones.setBounds(574, 302, 95, 84);
		
		add(lblHabitaciones);
		
		
		comboEstrellas.setVisible(false);
		comboEstrellas.setBounds(421, 115, 143, 27);
		add(comboEstrellas);
			
//		btnTipo.setBounds(453, 5, 117, 29);
//		add(btnTipo);
		
		
		texto_panel.setEditable(false);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Imagenes/bg.jpg"));
		background.setBounds(6, 6, 1279, 700);
		add(background);


	}
}
