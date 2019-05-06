package Modelo;

public class Casa extends Alojamiento {

	int Num_banos;
	int Superficie;
	int Piso;

	public Casa(String nombre, String ubicacion, float precio, int cod_alojamiento, int num_banos, int superficie,
			int piso) {
		super(nombre, ubicacion, precio, cod_alojamiento);
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

//	@Override
//	public String toString() {
//		return "Casa [Num_banos=" + Num_banos + ", Superficie=" + Superficie + ","+( Piso!=null ? "Piso=" + Piso + ", ":"")
//				+ (nombre != null ? "nombre=" + nombre + ", " : "")
//				+ (ubicacion != null ? "ubicacion=" + ubicacion + ", " : "") + "precio=" + precio + ", Cod_alojamiento="
//				+ Cod_alojamiento + "]";
//	}

}
