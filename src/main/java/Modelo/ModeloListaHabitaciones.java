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
		dormitorios = obtenerDormitorios(ubicacion);

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

	
	public static ArrayList<Dormitorio> obtenerDormitorios(String cod_hab) throws Exception {

		String sentencia = "select * from Hab_Dormitorio where Cod_Habitacion='%s'";
		sentencia = String.format(sentencia, cod_hab);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			dormitorios.add(new Dormitorio(result.getFloat("Superficie"), result.getString("Cod_Habitacion"), result.getInt("Cama_individual"),
					result.getInt("Cama_infantil"), result.getInt("Cama_matrimonio")));
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
