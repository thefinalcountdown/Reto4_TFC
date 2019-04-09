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
	private ArrayList<String> al = new ArrayList<String>();
	public static ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
	
	public ArrayList<Hotel> llenarLista(String ubicacion) throws Exception {
		System.out.println("hola");
		hoteles = obtenerHoteles(ubicacion);

		for (int index = 0; index < hoteles.size(); index++) {
			makeObj(hoteles.get(index).getNombre(),hoteles.get(index).getUbicacion());
			al.add(hoteles.get(index).getNombre()+" "+hoteles.get(index).getUbicacion());
			
			System.out.println(al.get(index) + "hola2");
		}
		return hoteles;
	}

	public static ArrayList<Hotel> obtenerHoteles(String ubicacion) throws Exception {

		String sentencia = "select * from hoteles where ubicacion='%s'";
		sentencia = String.format(sentencia, ubicacion);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			hoteles.add(new Hotel(result.getString("nombre"), result.getString("ubicacion"), result.getFloat("precio"),
					result.getInt("Cod_Hotel"), result.getInt("estrellas")));
			System.out.println(hoteles.get(0) + "hey");
		}

		System.out.println(hoteles.get(0));

		return hoteles;

	}

	public static Object makeObj(final String item, String item2) {
		return new Object() {
			public String toString() {
				return item+" "+item2;
			}
		};
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return al.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return al.get(index);
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
