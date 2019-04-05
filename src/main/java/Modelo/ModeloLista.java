package Modelo;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ModeloLista implements ListModel{
	private ArrayList<String> misNombreHoteles = new ArrayList<String>();
	
	public void rellenarModel() {
		System.out.println("golla");
		ArrayList<Hotel> Hotel = new ArrayList<Hotel>();
		Hotel.add(new Hotel("Villa de Bilbao","Bilbao",1,2,3));
		for (int index = 0; index < Hotel.size(); index++) {
			misNombreHoteles.add(Hotel.get(index).getNombre());
		}
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
