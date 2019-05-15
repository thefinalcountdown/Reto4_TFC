package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

import metodos.GestorBD;

public class Dormitorio extends Habitacion {

	public static ArrayList<Dormitorio> dormitorios = new ArrayList<Dormitorio>();

	private int camaIndividual;
	private int camaInfantil;
	private int camaMatrimonio;

	public Dormitorio(String cod_habitacion, float metrosCuadrados, String tipo, String descripcion, float precio,
			int camaIndividual, int camaInfantil, int camaMatrimonio) {
		super(cod_habitacion, metrosCuadrados, descripcion, tipo, precio);

		this.camaIndividual = camaIndividual;
		this.camaInfantil = camaInfantil;
		this.camaMatrimonio = camaMatrimonio;
	}

	public Dormitorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCamaIndividual() {
		return camaIndividual;
	}

	public void setCamaIndividual(int camaIndividual) {
		this.camaIndividual = camaIndividual;
	}

	public int getCamaInfantil() {
		return camaInfantil;
	}

	public void setCamaInfantil(int camaInfantil) {
		this.camaInfantil = camaInfantil;
	}

	public int getCamaMatrimonio() {
		return camaMatrimonio;
	}

	public void setCamaMatrimonio(int camaMatrimonio) {
		this.camaMatrimonio = camaMatrimonio;
	}

	public ArrayList<Dormitorio> obtenerDormitorios(int cod_hotel, String fecha_entrada, String fecha_salida)
			throws Exception {

		String sentencia = "select H.Cod_Habitacion, H.Superficie, H.Tipo_habitacion, H.Descripcion, H.Precio, C.Individual, C.Infantil,C.Matrimonio, H.Cod_Alojamiento\n"
				+ "from Habitacion H inner join Camas C \n" + "on H.Cod_Habitacion = C.Cod_Habitacion \n"
				+ "where Cod_Alojamiento = '%s' \n"
				+ "and H.Cod_Habitacion not in (select rh.Habitacion_Alojamiento_Num_Habitacion\n"
				+ "from Reserva_habitacion rh  inner join Habitacion H  on H.Cod_Habitacion=rh.Habitacion_Alojamiento_Num_Habitacion \n"
				+ "where FechaEntrada >= '%s' and FechaSalida <= '%s')";
		sentencia = String.format(sentencia, cod_hotel, fecha_entrada, fecha_salida);
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			dormitorios.add(new Dormitorio(result.getString("Cod_habitacion"), result.getFloat("Superficie"),
					result.getString("Tipo_habitacion"), result.getString("Descripcion"), result.getFloat("Precio"),
					result.getInt("Individual"), result.getInt("Infantil"), result.getInt("Matrimonio")));
		}
		return dormitorios;
	}

	@Override
	public String toString() {
		return "Dormitorio [, camaIndividual=" + camaIndividual + ", camaInfantil=" + camaInfantil + ", camaMatrimonio="
				+ camaMatrimonio + "]";
	}

}
