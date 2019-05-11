package Modelo;

public abstract class Alojamiento {

	private String nombre;
	private String ubicacion;
	private int Cod_alojamiento;

	public Alojamiento()
	{
		
	}
	
	public Alojamiento(String nombre, String ubicacion, int cod_alojamiento) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.Cod_alojamiento = cod_alojamiento;
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
		return "Nombre alojamiento=" + nombre + " Ubicacion alojamiento=" + ubicacion + " Cod_alojamiento=" + Cod_alojamiento;
	}

}
