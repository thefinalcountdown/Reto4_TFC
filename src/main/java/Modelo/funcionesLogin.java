package Modelo;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class funcionesLogin {
	// Comprobar que los campos de la vistalogin no esten vacios.
	public static boolean comprobarCampos(String dni, String nombre, String apellido, String clave) {
		String sentencia = "insert into Usuario(DNI, Nombre, Apellido, Clave)" + "values(\"" + dni + "\", \"" + nombre
				+ "\", \"" + apellido + "\", \"" + clave + "\")";

		if (dni.equals("") || nombre.equals("") || apellido.equals("") || clave.equals("")) {
			return true;
		} else {
			return false;
		}

	}

	// rellena el usuario con los datos de la BD
	public static void rellenarUsuario(ResultSet result) {

		try {
			while (result.next()) {

				String dni = result.getString("DNI");
				String nombre = result.getString("Nombre");
				String apellido = result.getString("Apellido");
				String clave = result.getString("Clave");
				Usuario usuario = new Usuario(dni, nombre, apellido, clave);
				usuario.setDni(dni);
				usuario.setNombre(nombre);
				usuario.setApellido(apellido);
				usuario.setClave(clave);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo hacer la consulta a la base de datos");
		}

	}

	public static String sentenciaInsertarUsuario(String dni, String nombre, String apellido, String clave) {
		return "insert into Usuario(DNI, Nombre, Apellido, Clave) values(\"" + dni + "\", \"" + nombre + "\", \""
				+ apellido + "\", \"" + clave + "\")";
	}

	// sentencia para comprobar usuario login, si es falso, clave mala
	public static String sentenciaLogin(String dni, String clave) {
		return "select * from Usuario where DNI=\"" + dni + "\" and Clave=\"" + clave + "\"";
	}

	public static boolean comprobarLogin(ResultSet result) {
		try {
			if (result.next() == true) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Comprobar si el DNI existe a la hora de loguearse, borrar, o actualizar el
	// usuario.
	public static String sentenciaCombrobarDni(String dni) {
		return "select DNI from Usuario where DNI=\"" + dni + "\"";
	}

	public static boolean comprobarDni(ResultSet result) {
		try {
			return result.first();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// sentencia para borrar usuario
	public static String sentenciaBorrarUsuario(String dni, String clave) {
		return "delete from Usuario where DNI=\"" + dni + "\" and Clave=\"" + clave + "\"";
	}

	// sentencia actualizar usuario
	public static String sentenciaActualizarUsuario(String dni, String clave, String nuevaclave) {
		return "update Usuario set Clave=\"" + nuevaclave + "\" where DNI=\"" + dni + "\" and Clave=\"" + clave + "\"";

	}
}
