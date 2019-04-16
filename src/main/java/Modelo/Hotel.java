package Modelo;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class Hotel extends Alojamiento {

	int estrellas;

	public Hotel(String nombre, String ubicacion, float precio, int cod_alojamiento) {
		super(nombre, ubicacion, precio, cod_alojamiento);
		// TODO Auto-generated constructor stub
	}

	public Hotel(String nombre, String ubicacion, float precio, int cod_alojamiento, int estrellas) {
		super(nombre, ubicacion, precio, cod_alojamiento);
		this.estrellas = estrellas;
	}

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

}
