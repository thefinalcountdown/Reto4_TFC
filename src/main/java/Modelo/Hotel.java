package Modelo;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class Hotel extends Alojamiento implements ListModel{


	int estrellas;
	
	
	

	public Hotel(String nombre, String ubicacion, float precio, int cod_alojamiento) {
		super(nombre, ubicacion, precio, cod_alojamiento);
		// TODO Auto-generated constructor stub
	}
	

	public Hotel(String nombre, String ubicacion, float precio, int cod_alojamiento, int estrellas) {
		super(nombre, ubicacion, precio, cod_alojamiento);
		this.estrellas=estrellas;
	}
	
//	public static void rellenarModel(String nombre, String ubicacion, float precio, int cod_alojamiento, int estrellas) {
//		ArrayList<String> misNombreHoteles = new ArrayList<String>();
//		ArrayList<Hotel> Hotel = new ArrayList<Hotel>();
//		Hotel.add(new Hotel(nombre, ubicacion, precio, cod_alojamiento, estrellas));
//		for (int index = 0; index < Hotel.size(); index++) {
//			misNombreHoteles.add(Hotel.get(index).getNombre());
//		}
//		
//	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	@Override
	public String toString() {
		return "Hotel [estrellas=" + estrellas + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", precio="
				+ precio + ", Cod_alojamiento=" + Cod_alojamiento + "]";
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
