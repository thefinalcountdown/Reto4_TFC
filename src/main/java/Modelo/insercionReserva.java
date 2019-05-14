package Modelo;

import java.util.ArrayList;

import metodos.GestorBD;

public class insercionReserva
{
	public insercionReserva()
	{
		
	}
	
	public void insertarReserva(ArrayList<Reserva_habitacion> reserva_habitacion, ArrayList<String> reserva)
	{
		String nombre_usuario = "";
		
		for (int cont = 0; cont < reserva.get(9).length(); cont++)
		{
			if (reserva.get(9).charAt(cont+1) != ' ')
			{
				nombre_usuario += reserva.get(9).charAt(cont);
			}
			else
			{
				nombre_usuario += reserva.get(9).charAt(cont);
				break;
			}
		}
		
		String sentencia = "insert into Reserva(Cod_Alojamiento, NombreAlojamiento, Precio, NumPersonas, NumHabitaciones, "
				+ " Ubicacion, FechaEntrada, FechaSalida, Usuario_DNI, Usuario) values ("+ Integer.parseInt(reserva.get(0)) 
				+ ",'"+ reserva.get(1) + "'," + Float.parseFloat(reserva.get(2)) + "," + Integer.parseInt(reserva.get(3))
				+ "," + Integer.parseInt(reserva.get(4)) + ",'" + reserva.get(5) + "','" + reserva.get(6) + "','" + reserva.get(7) + 
				"','" + reserva.get(8) + "','" + nombre_usuario + "')";
		
		GestorBD.insertarDatos(sentencia);
		
		
		String sentencia2;
		
		
		for(int cont=0; cont < reserva_habitacion.size(); cont++)
		{
			sentencia2 = "insert into Reserva_Habitacion values('" + reserva_habitacion.get(cont).getNum_habitacion() 
					+ "', '" + reserva_habitacion.get(cont).getFecha_entrada() + "', '" 
					+ reserva_habitacion.get(cont).getFecha_salida() + "')";
			GestorBD.insertarDatos(sentencia2);
			
		}	
	}
}
