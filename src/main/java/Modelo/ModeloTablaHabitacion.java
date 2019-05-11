package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;


import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import metodos.GestorBD;

public class ModeloTablaHabitacion implements TableModel{

	
	public static ArrayList<Dormitorio> dormitorios = new ArrayList<Dormitorio>();

	public ArrayList<Dormitorio> obtenerDormitorios(String ubicacion) throws Exception {

		String sentencia = "select nombre, ubicacion, Cod_Alojamiento, num_banos, piso from Alojamiento A "
				+ "inner join Casa_apartamento CA on A.Cod_alojamiento=CA.Cod_Casa where ubicacion='%s'";
		sentencia = String.format(sentencia, ubicacion);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			dormitorios.add(new Dormitorio(result.getString("Cod_habitacion"), result.getFloat("Superficie"),
					result.getString("Tipo"), result.getString("Descripcion"), result.getFloat("Precio"),
					result.getInt("Individual"), result.getInt("Matrimonio"), result.getInt("Infantil")));
		}
		return dormitorios;
	}

	

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	

}
