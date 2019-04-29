package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import Vista.Ventana;
import metodos.GestorBD;

public class ModeloListaHabitaciones implements ListModel {
	Ventana ventana;
	public ArrayList<String> arrayString = new ArrayList<String>();
	public static ArrayList<Dormitorio> dormitorios = new ArrayList<Dormitorio>();
	

	public void llenarLista(int cod_hotel) throws Exception {
		dormitorios = obtenerHabitaciones(cod_hotel);

		
		for (int index = 0; index < dormitorios.size(); index++) 
		{
			makeObj(dormitorios.get(index).getCamaIndividual(), dormitorios.get(index).getCamaInfantil(), 
					dormitorios.get(index).getCamaMatrimonio());
			arrayString.add("Cama individual: "+dormitorios.get(index).getCamaIndividual()+ "  Cama infantil: " + dormitorios.get(index).getCamaInfantil()
					+" Cama de matrimonio: "+dormitorios.get(index).getCamaMatrimonio());
		}
	}
	
	public void vaciarLista(){
		
		for(int index = arrayString.size()-1; index >= 0; index--)
		{
			dormitorios.remove(index);
			arrayString.remove(index);
		}
	}
	
	public static Object makeObj(int item2, int item3, int item4) {
		return new Object() {
			public String toString() 
			{
				return ""+item2+item3+item4;
			}
		};
	}
	
	
	
	public static ArrayList<Dormitorio> obtenerHabitaciones(int cod_hotel) throws Exception {

		String sentencia = "select * from Hab_Dormitorio inner join Habitacion_hotel on Hab_Dormitorio.Cod_Habitacion\n" + 
				"= Habitacion_hotel.Tipo_Habitacion where Cod_Hotel = %s";
		sentencia= String.format(sentencia, cod_hotel);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) 
		{
			dormitorios.add(new Dormitorio(result.getString("Cod_Habitacion"), result.getFloat("Superficie"),
					result.getInt("Cama_individual"), result.getInt("Cama_infantil"), result.getInt("Cama_matrimonio")));
		}
		
		return dormitorios;

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
