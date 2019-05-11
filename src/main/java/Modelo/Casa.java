package Modelo;

public class Casa extends Alojamiento {

	private int Num_banos;
	private int Superficie;
	private int Piso;

	public Casa()
	{
		super();
	}
	
	public Casa(String nombre, String ubicacion, int cod_alojamiento, int num_banos, int superficie, int piso) {
		super(nombre, ubicacion, cod_alojamiento);
		Num_banos = num_banos;
		Superficie = superficie;
		Piso = piso;
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

	@Override
	public String toString() {
		return super.toString()+" Numero de ba\u00f1os=" + Num_banos + " Superficie casa=" + Superficie + " N\u00famero de piso=" + Piso;
	}

}
