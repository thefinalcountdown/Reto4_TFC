package Modelo;

public abstract class Alojamiento {


	protected String nombre;
	protected String ubicacion;
	protected int Cod_alojamiento;

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

		return "Alojamiento [nombre=" + nombre + ", ubicacion=" + ubicacion + ", Cod_alojamiento=" + Cod_alojamiento
				+ "]";

	}

}
