package Modelo;

public class Casa extends Alojamiento {

	private int Num_banos;
	private int Superficie;
	private int Piso;
	private double Precio;

	public Casa()
	{
		
	}
	
	public Casa(String nombre, String ubicacion, int cod_alojamiento, int num_banos, int superficie, int piso, double precio) {

		super(nombre, ubicacion, cod_alojamiento);
		this.Num_banos = num_banos;
		this.Superficie = superficie;
		this.Piso = piso;
		this.Precio = precio;
	}

	public int getNum_banos() {
		return Num_banos;
	}

	public void setNum_banos(int num_banos) {
		Num_banos = num_banos;
	}

	public int getSuperficie() {
		return Superficie;
	}

	public void setSuperficie(int superficie) {
		Superficie = superficie;
	}

	public int getPiso() {
		return Piso;
	}

	public void setPiso(int piso) {
		Piso = piso;
	}
	
	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	@Override
	public String toString() {
		return super.toString() + " Numero de ba\u00f1os=" + Num_banos + " Superficie casa=" + Superficie + " N\u00famero de piso=" + Piso;
	}

}
