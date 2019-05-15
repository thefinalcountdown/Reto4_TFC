package Modelo;

public class Habitaciones {

	float metrosCuadrados;
	
	public Habitaciones(float MetrosCuadrados) {
		this.metrosCuadrados = MetrosCuadrados;
	}

	public float getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(float metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	
	
	@Override
	public String toString() {
		return toString()+" "+this.metrosCuadrados;
		//return "Habitaciones [metrosCuadrados=" + metrosCuadrados + "]";
	}
}

