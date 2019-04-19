package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class funcionesLogin {
	// Comprobar que los campos de la vistalogin no esten vacios.
	public boolean comprobarCampos(String dni, String nombre, String apellido, String clave) 
	{
		String sentencia = "insert into Usuario(DNI, Nombre, Apellido, Clave)" + "values(\"" + dni + "\", \"" + nombre
				+ "\", \"" + apellido + "\", \"" + clave + "\")";

		if (dni.equals("") || nombre.equals("") || apellido.equals("") || clave.equals("")) 
		{
			return true;
		}
		else
		{
			return false;
		}

	}
//
//	// rellena el usuario con los datos de la BD
//	public void rellenarUsuario(ResultSet result) 
//	{
//
//		try 
//		{
//			while (result.next()) 			
//			{
//
//				String dni = result.getString("DNI");
//				String nombre = result.getString("Nombre");
//				String apellido = result.getString("Apellido");
//				String clave = result.getString("Clave");
//				Usuario usuario = new Usuario(dni, nombre, apellido, clave);
//			}
//		} 
//		catch (SQLException e) 
//		{
//			JOptionPane.showMessageDialog(null, "No se pudo hacer la consulta a la base de datos");
//		}
//
//	}

	public String sentenciaInsertarUsuario(String dni, String nombre, String apellido, String clave) 
	{
		return "insert into Usuario(DNI, Nombre, Apellido, Clave) values(\"" + dni.toUpperCase() + "\", \"" + nombre.toUpperCase() + "\", \""
				+ apellido.toUpperCase() + "\", \"" + clave + "\")";
	}

	// sentencia para comprobar usuario login, si es falso, clave mala
	public String sentenciaLogin(String dni, String clave) 
	{
		return "select * from Usuario where DNI=\"" + dni.toUpperCase() + "\" and Clave=\"" + clave + "\"";
	}

	public boolean comprobarLogin(ResultSet result) 
	{
		try 
		{
			if (result.next() == true)
			{
				return true;
			}
			else 
			{
				return false;
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	// Comprobar si el DNI existe a la hora de loguearse, borrar, o actualizar el
	// usuario.
	public String sentenciaCombrobarDni(String dni) 
	{
		return "select DNI from Usuario where DNI=\"" + dni + "\"";
	}

	public boolean comprobarDni(ResultSet result) 
	{
		try
		{
			return result.first();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	// sentencia para borrar usuario
	public String sentenciaBorrarUsuario(String dni, String clave) 
	{
		return "delete from Usuario where DNI=\"" + dni.toUpperCase() + "\" and Clave=\"" + clave + "\"";
	}

	// sentencia actualizar usuario
	public String sentenciaActualizarUsuario(String dni, String clave, String nuevaclave) 
	{
		return "update Usuario set Clave=\"" + nuevaclave + "\" where DNI=\"" + dni.toUpperCase() + "\" and Clave=\"" + clave + "\"";

	}
}
