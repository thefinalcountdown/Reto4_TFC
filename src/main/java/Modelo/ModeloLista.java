package Modelo;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import Vista.vistaRaiz;
import metodos.GestorBD;

public class ModeloLista implements ListModel{
	private static  ArrayList<String> lista= new ArrayList<String>();
	 static ArrayList<Hotel> hoteles = new ArrayList<Hotel>();

	public static ArrayList<Hotel> llenarLista()throws Exception{
	String ubicacionSeleccionada = vistaRaiz.comboBoxUbicacion.getSelectedItem().toString();
	 hoteles=GestorBD.obtenerHoteles1(ubicacionSeleccionada);
	 for (int index = 0; index < hoteles.size(); index++) {
			makeObj(hoteles.get(index).getNombre());
			lista.add(hoteles.get(index).getNombre());
		}
		return hoteles;
	
	}
	public static Object makeObj(final String item) {
		return new Object() {
			public String toString() {
				return item;
			}
		};
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
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
