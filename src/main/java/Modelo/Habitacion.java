package Modelo;

public class Habitacion {

	private String Cod_habitacion;
	private float metrosCuadrados;
	private String tipo;
	private String descripcion;
	private float precio;

	
	public Habitacion()
	{
		
	}
	
	public Habitacion(String cod_habitacion, float metrosCuadrados, String tipo, String descripcion, float precio) {
		Cod_habitacion = cod_habitacion;
		this.metrosCuadrados = metrosCuadrados;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getCod_habitacion() {
		return Cod_habitacion;
	}

	public void setCod_habitacion(String cod_habitacion) {
		Cod_habitacion = cod_habitacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(float metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	@Override
	public String toString() {
		return "C\u00f3digo de habitaci\u00f3n=" + Cod_habitacion + " Metros cuadrados=" + metrosCuadrados + " Tipo="
				+ tipo + " Descripci\u00f3n=" + descripcion + " Precio=" + precio;
	}

	
}
