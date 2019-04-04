package Modelo;

import javax.swing.JTextField;

public class Ubicacion {
	private String ubicacion;
	private int numeroHuespedes;
	private JTextField txthuesped;
	
	
	public Ubicacion() {
	}
	
	public Ubicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public Ubicacion(String ubicacion, int numeroHuespedes) {
		this.ubicacion = ubicacion;
		this.numeroHuespedes = numeroHuespedes;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getNumeroHuespedes() {
		return numeroHuespedes;
	}

	public void setNumeroHuespedes(int numeroHuespedes) {
		this.numeroHuespedes = numeroHuespedes;
	}
	


}
