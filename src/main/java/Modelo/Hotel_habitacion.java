package Modelo;

import java.sql.ResultSet;

import metodos.GestorBD;

public class Hotel_habitacion{

	int Cod_hotel;
	String Habitacion1;
	String Habitacion2;
	String Habitacion3;
	String Habitacion4;
	String Habitacion5;
	String Habitacion6;
	String Habitacion7;
	String Habitacion8;
	String Habitacion9;
	String Habitacion10;
	
	public Hotel_habitacion() {
		
	}

	public Hotel_habitacion(int cod_hotel, String habitacion1, String habitacion2, String habitacion3,
			String habitacion4, String habitacion5, String habitacion6, String habitacion7, String habitacion8,
			String habitacion9, String habitacion10) {
		this.Cod_hotel = cod_hotel;
		this.Habitacion1 = habitacion1;
		this.Habitacion2 = habitacion2;
		this.Habitacion3 = habitacion3;
		this.Habitacion4 = habitacion4;
		this.Habitacion5 = habitacion5;
		this.Habitacion6 = habitacion6;
		this.Habitacion7 = habitacion7;
		this.Habitacion8 = habitacion8;
		this.Habitacion9 = habitacion9;
		this.Habitacion10 = habitacion10;
	}
	
//	public Hotel_habitacion obtenerHabitaciones(int i, Hotel_habitacion hotelSeleccionado)throws Exception {
//
//		String sentencia = "select * from Hotel_habitacion where Cod_Hotel='%s'";
//		sentencia = String.format(sentencia, i);
//		ResultSet result = GestorBD.consulta(sentencia);
//		while (result.next()) {
//			hotelSeleccionado=new Hotel_habitacion(result.getInt("Cod_Hotel"), result.getString("Habitacion1"), result.getString("Habitacion2"),
//					result.getString("Habitacion3"), result.getString("Habitacion4"), result.getString("Habitacion5"), 
//					result.getString("Habitacion6"), result.getString("Habitacion7"), result.getString("Habitacion8"), 
//					result.getString("Habitacion9"), result.getString("Habitacion10"));
//System.out.println("holi"+result.getInt("Cod_Hotel"));
//		}
//return hotelSeleccionado;
//	}

	public int getCod_hotel() {
		return Cod_hotel;
	}

	public void setCod_hotel(int cod_hotel) {
		Cod_hotel = cod_hotel;
	}

	public String getHabitacion1() {
		return Habitacion1;
	}

	public void setHabitacion1(String habitacion1) {
		Habitacion1 = habitacion1;
	}

	public String getHabitacion2() {
		return Habitacion2;
	}

	public void setHabitacion2(String habitacion2) {
		Habitacion2 = habitacion2;
	}

	public String getHabitacion3() {
		return Habitacion3;
	}

	public void setHabitacion3(String habitacion3) {
		Habitacion3 = habitacion3;
	}

	public String getHabitacion4() {
		return Habitacion4;
	}

	public void setHabitacion4(String habitacion4) {
		Habitacion4 = habitacion4;
	}

	public String getHabitacion5() {
		return Habitacion5;
	}

	public void setHabitacion5(String habitacion5) {
		Habitacion5 = habitacion5;
	}

	public String getHabitacion6() {
		return Habitacion6;
	}

	public void setHabitacion6(String habitacion6) {
		Habitacion6 = habitacion6;
	}

	public String getHabitacion7() {
		return Habitacion7;
	}

	public void setHabitacion7(String habitacion7) {
		Habitacion7 = habitacion7;
	}

	public String getHabitacion8() {
		return Habitacion8;
	}

	public void setHabitacion8(String habitacion8) {
		Habitacion8 = habitacion8;
	}

	public String getHabitacion9() {
		return Habitacion9;
	}

	public void setHabitacion9(String habitacion9) {
		Habitacion9 = habitacion9;
	}

	public String getHabitacion10() {
		return Habitacion10;
	}

	public void setHabitacion10(String habitacion10) {
		Habitacion10 = habitacion10;
	}

	@Override
	public String toString() {
		return "Hotel_habitacion [Cod_hotel=" + Cod_hotel + ", Habitacion1=" + Habitacion1 + ", Habitacion2="
				+ Habitacion2 + ", Habitacion3=" + Habitacion3 + ", Habitacion4=" + Habitacion4 + ", Habitacion5="
				+ Habitacion5 + ", Habitacion6=" + Habitacion6 + ", Habitacion7=" + Habitacion7 + ", Habitacion8="
				+ Habitacion8 + ", Habitacion9=" + Habitacion9 + ", Habitacion10=" + Habitacion10 + "]";
	}
	
	
}
