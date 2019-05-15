package Modelo;

public class Hotel_habitacion {

	int Cod_hotel;
	int Num_Habitacion;
	String Tipo_Habitacion;

	public Hotel_habitacion() {

	}

	public Hotel_habitacion(int cod_hotel, int num_habitacion, String tipo_habitacion) {
		this.Cod_hotel = cod_hotel;
		this.Num_Habitacion = num_habitacion;
		this.Tipo_Habitacion = tipo_habitacion;
	}

	public int getCod_hotel() {
		return Cod_hotel;
	}

	public void setCod_hotel(int cod_hotel) {
		Cod_hotel = cod_hotel;
	}

	public int getNum_Habitacion() {
		return Num_Habitacion;
	}

	public void setNum_Habitacion(int num_Habitacion) {
		Num_Habitacion = num_Habitacion;
	}

	public String getTipo_Habitacion() {
		return Tipo_Habitacion;
	}

	public void setTipo_Habitacion(String tipo_Habitacion) {
		Tipo_Habitacion = tipo_Habitacion;
	}

	@Override
	public String toString() {
		return "Hotel_habitacion [Cod_hotel=" + Cod_hotel + ", Num_Habitacion=" + Num_Habitacion + ", Tipo_Habitacion="
				+ Tipo_Habitacion + "]";
	}

}
