package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import metodos.GestorBD;

public class Habitacion {

	public static ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
	
	String Cod_habitacion;
	float metrosCuadrados;
	String tipo;
	String descripcion;
	float precio;

	
	public Habitacion(String cod_habitacion, float metrosCuadrados, String tipo, String descripcion, float precio) {
		Cod_habitacion = cod_habitacion;
		this.metrosCuadrados = metrosCuadrados;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Habitacion() {
		// TODO Auto-generated constructor stub
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
	public ArrayList<Habitacion> obtenerHabitaciones(int cod_aloja, String fecha_entrada, String fecha_salida)
			throws Exception {

		String sentencia = "select H.Cod_Habitacion, H.Superficie, H.Tipo_habitacion, H.Descripcion, H.Precio, H.Cod_Alojamiento\n"
				+ "from Habitacion H \n"
				+ "where Cod_Alojamiento = '%s' \n"
				+ "and H.Cod_Habitacion not in (select rh.Habitacion_Alojamiento_Num_Habitacion\n"
				+ "from Reserva_habitacion rh  inner join Habitacion H  on H.Cod_Habitacion=rh.Habitacion_Alojamiento_Num_Habitacion \n"
				+ "where FechaEntrada >= '%s' and FechaSalida <= '%s')";
		sentencia = String.format(sentencia, cod_aloja, fecha_entrada, fecha_salida);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			habitaciones.add(new Habitacion(result.getString("Cod_habitacion"), result.getFloat("Superficie"),
					result.getString("Tipo_habitacion"), result.getString("Descripcion"), result.getFloat("Precio")
					));
		}
		return habitaciones;
	}

	@Override
	public String toString() {
		return "Habitacion [" + (Cod_habitacion != null ? "Cod_habitacion=" + Cod_habitacion + ", " : "")
				+ "metrosCuadrados=" + metrosCuadrados + ", " + (tipo != null ? "tipo=" + tipo + ", " : "")
				+ (descripcion != null ? "descripcion=" + descripcion + ", " : "") + "precio=" + precio + "]";
	}

	
}
