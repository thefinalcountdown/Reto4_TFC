package Modelo;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import metodos.GestorBD;

public class fechasTarifas {

	
	
	public static ArrayList<LocalDate> obtenerDiasFestivos()  throws Exception {

		ArrayList<LocalDate> diasFestivos = new ArrayList<LocalDate>();
		String sentencia = "SELECT Fecha_inicio FROM Fechas WHERE Fecha_fin IS NULL;";
		
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			
			LocalDate diaFestivo = LocalDate.parse(result.getString("Fecha_inicio"));
			diasFestivos.add(diaFestivo);
		}
		return diasFestivos;

	}
	
	
	public static ArrayList<TemporadaAlta> obtenerTemporadasAltas()  throws Exception {

		ArrayList<TemporadaAlta> temporadasAltas = new ArrayList<TemporadaAlta>();
		String sentencia = "SELECT Fecha_inicio, Fecha_fin FROM Fechas WHERE (Descuento LIKE '0.2' AND Fecha_fin IS NOT NULL);";
		
		ResultSet result = GestorBD.consulta(sentencia);
		while (result.next()) {
			
			LocalDate inicioTempAlta = LocalDate.parse(result.getString("Fecha_inicio"));
			LocalDate finTempAlta = LocalDate.parse(result.getString("Fecha_fin"));
			TemporadaAlta tempAlta = new TemporadaAlta(inicioTempAlta, finTempAlta);
			temporadasAltas.add(tempAlta);
		}
		return temporadasAltas;

	}
	
	

}
