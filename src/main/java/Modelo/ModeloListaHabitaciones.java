package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import Vista.Ventana;
import metodos.GestorBD;

public class ModeloListaHabitaciones implements ListModel{
	Ventana ventana;
	public ArrayList<String> arrayString = new ArrayList<String>();
	public static ArrayList<Dormitorio> dormitorios = new ArrayList<Dormitorio>();
	

	public void llenarDormitorios(String ubicacion) throws Exception {
		dormitorios = obtenerHoteles(ubicacion);

		for (int index = 0; index < dormitorios.size(); index++) 
		{
			makeObj(dormitorios.get(index).getCamaIndividual(), dormitorios.get(index).getCamaInfantil(), dormitorios.get(index).getCamaMatrimonio());
			arrayString.add("Camas individuales: "+dormitorios.get(index).getCamaIndividual() + "  Camas de matrimonio:" + dormitorios.get(index).getCamaMatrimonio()
					+"  Camas infantiles: "+dormitorios.get(index).getCamaInfantil());
		}
	}
	
	public void vaciarLista(){
		
		for(int index = arrayString.size()-1; index >= 0; index--)
		{
			dormitorios.remove(index);
			arrayString.remove(index);
		}
		
	}

	
	public static ArrayList<Dormitorio> obtenerHoteles(String ubicacion) throws Exception {

		String sentencia = "select * from hoteles where ubicacion='%s'";
		sentencia = String.format(sentencia, ubicacion);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			dormitorios.add(new Hotel(result.getString("nombre"), result.getString("ubicacion"), result.getFloat("precio"),
					result.getInt("Cod_Hotel"), result.getInt("estrellas")));
		}
		return dormitorios;

	}

	public static Object makeObj(final int item, int item2, int item3) {
		return new Object() {
			public String toString() {
				return ""+item+item2+item3;
			}
		};
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return arrayString.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return arrayString.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}
	
}
