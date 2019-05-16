package Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import Modelo.Hotel;

import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Font;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;

public class vistaHoteles extends JPanel {

	private static final long serialVersionUID = 1L;
	public JList<Hotel> listaAlojamientos = new JList<Hotel>();

	JScrollPane scrollPane = new JScrollPane();
	public JScrollPane scrollPane_1 = new JScrollPane();
	
	public JTable habitaciones = new JTable();
	public DefaultTableModel modeloTabla;

	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnContinuar = new JButton("Continuar");
	public JButton btnHabitaciones = new JButton("->");
	
	public JButton btn_habitacion_duda;
	public JPanel panel = new JPanel();
	public JTextArea texto_panel = new JTextArea();

	public vistaHoteles() {

		setLayout(null);
		scrollPane.setBounds(43, 35, 550, 350);
		add(scrollPane);
		scrollPane_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_1.setBounds(641, 60, 522, 289);
		add(scrollPane_1);
		scrollPane.setViewportView(listaAlojamientos);

		listaAlojamientos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Seleccione un hotel:", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(235, 145, 168)));
		listaAlojamientos.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		listaAlojamientos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaAlojamientos.setFixedCellHeight(50);
		listaAlojamientos.setFixedCellWidth(100);

		btnCancelar.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCancelar.setBounds(72, 437, 138, 61);
		add(btnCancelar);

		btnContinuar.setBounds(612, 437, 138, 61);
		add(btnContinuar);

		btnHabitaciones.setBounds(602, 198, 36, 25);
		add(btnHabitaciones);

		String columna[] = {""};
		modeloTabla = new DefaultTableModel(columna, 0) {	@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }};
		habitaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane_1.setViewportView(habitaciones);
		
		habitaciones.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		habitaciones.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		habitaciones.setRowHeight(50);
		habitaciones.setRowMargin(20);
		
		btn_habitacion_duda = new JButton("?");
		btn_habitacion_duda.setBounds(1128, 361, 36, 37);
		btn_habitacion_duda.setVisible(false);
		
		add(btn_habitacion_duda);
		
		
		texto_panel.setEditable(false);
	
	

	}
	
	
	

}
