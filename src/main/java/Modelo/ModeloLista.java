package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import Vista.Ventana;
import metodos.GestorBD;

public class ModeloLista implements ListModel {
	Ventana ventana;
	public ArrayList<String> arrayString = new ArrayList<String>();
	public static ArrayList<Hotel> hoteles = new ArrayList<Hotel>();

	public void llenarLista(String ubicacion) throws Exception {
		hoteles = obtenerHoteles(ubicacion);

		for (int index = 0; index < hoteles.size(); index++) 
		{
			makeObj(hoteles.get(index).getNombre(), hoteles.get(index).getPrecio(), hoteles.get(index).getEstrellas());
			arrayString.add("Nombre: "+hoteles.get(index).getNombre() + "  Precio:" + hoteles.get(index).getPrecio()
					+"\u20ac  Estrellas: "+hoteles.get(index).getEstrellas());
		}
	}
	
	public void vaciarLista(){
		
		for(int index = arrayString.size()-1; index >= 0; index--)
		{
			hoteles.remove(index);
			arrayString.remove(index);
		}
		
	}

	
	public static ArrayList<Hotel> obtenerHoteles(String ubicacion) throws Exception {

		String sentencia = "select * from hoteles where ubicacion='%s'";
		sentencia = String.format(sentencia, ubicacion);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			hoteles.add(new Hotel(result.getString("nombre"), result.getString("ubicacion"), result.getFloat("precio"),
					result.getInt("Cod_Hotel"), result.getInt("estrellas")));
		}
		return hoteles;

	}

	public static Object makeObj(final String item, float item2, int item3) {
		return new Object() {
			public String toString() {
				return item+item2+item3;
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
