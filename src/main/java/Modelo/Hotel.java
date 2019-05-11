package Modelo;

public class Hotel extends Alojamiento {

	private int estrellas;

	public Hotel()
	{
		super();
	}
	
	public Hotel(String nombre, String ubicacion, int cod_alojamiento) 
	{
		super(nombre, ubicacion, cod_alojamiento);
		// TODO Auto-generated constructor stub
	}

	public Hotel(String nombre, String ubicacion, int cod_alojamiento, int estrellas) {
		super(nombre, ubicacion, cod_alojamiento);
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
		return super.toString()+" Estrellas hotel=" + estrellas;
	}

}
