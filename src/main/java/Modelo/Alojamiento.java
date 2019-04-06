package Modelo;

import java.util.ArrayList;

public abstract class Alojamiento {
	
	String nombre;
	String ubicacion;
	float precio;
	int Cod_alojamiento;
	ArrayList<Habitaciones> listaHabitaciones = new ArrayList<Habitaciones>();
	
	
	
	public Alojamiento(String nombre, String ubicacion, float precio, int cod_alojamiento, ArrayList<Habitaciones> ListaHabitaciones) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.precio = precio;
		this.listaHabitaciones = ListaHabitaciones;
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCod_alojamiento() {
		return Cod_alojamiento;
	}
	public void setCod_alojamiento(int cod_alojamiento) {
		Cod_alojamiento = cod_alojamiento;
	}
	public ArrayList<Habitaciones> getListaHabitaciones() {
		return listaHabitaciones;
	}
	
	public void setListaHabitaciones(ArrayList<Habitaciones> ListaHabitaciones) {
		listaHabitaciones = ListaHabitaciones;
	}
	
	@Override
	public String toString() {
		return "Alojamiento [nombre=" + nombre + ", ubicacion=" + ubicacion + ", precio=" + precio
				+ ", Cod_alojamiento=" + Cod_alojamiento + ", Lista habitaciones=" +listaHabitaciones+"]";
	}
	
	

}
