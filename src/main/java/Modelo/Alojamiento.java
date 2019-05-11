package Modelo;

import java.util.ArrayList;

public abstract class Alojamiento {

	String nombre;
	String ubicacion;
	int Cod_alojamiento;

	public Alojamiento(String nombre, String ubicacion, int cod_alojamiento) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		Cod_alojamiento = cod_alojamiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCod_alojamiento() {
		return Cod_alojamiento;
	}

	public void setCod_alojamiento(int cod_alojamiento) {
		Cod_alojamiento = cod_alojamiento;
	}

	@Override
	public String toString() {
		return "Alojamiento [nombre=" + nombre + ", ubicacion=" + ubicacion + ", Cod_alojamiento=" + Cod_alojamiento
				+ "]";
	}

}
