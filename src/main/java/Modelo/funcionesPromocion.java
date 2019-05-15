package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class funcionesPromocion {

	public String sentenciaCodigoPromocional(String codigo) {
		return "select Descuento from Promocion where Cod_Promocion = \""+ codigo +"\"";
	}
	
	public int consultarPromocion(ResultSet result) {
		int codigo = 0;
		try {
			while (result.next()) 			
			{
				codigo = result.getInt("Descuento");				
			}
			return codigo;
		} 
		catch (SQLException e) 
		{
			return codigo;
		}

	}
	
}
