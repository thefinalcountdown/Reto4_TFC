package Modelo;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class funcionesLogin {
	// Comprobar que los campos de la vistalogin no esten vacios.
	public static boolean comprobarCampos(String dni, String nombre, String apellido, String clave) {
		String sentencia = "insert into usuario(DNI, Nombre, Apellido, Clave)" + "values(\"" + dni + "\", \"" + nombre
				+ "\", \"" + apellido + "\", \"" + clave + "\")";

		if (dni.equals("") || nombre.equals("") || apellido.equals("") || clave.equals("")) {
			return true;
		} else {
			return false;
		}

	}

	// Sentencia para comprobar que el usuario existe
	public static String sentenciaComprobarUsuario(String dni) {
		return "select * from Usuarios where DNI=\"" + dni + "\"";
	}

	// Si el usuario existe nos devolvera true, si no, sera false
	public static boolean comprobarUsuario(ResultSet result) {
		try {
			if (result.next() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo hacer la consulta a la Base de Datos");
		}
		return false;
	}

	// Sentencia para comprobar usuario y clave para actualizar, existe
	public static String sentenciaComprobarClave(String dniactualizar, String claveactualizar) {
		return "select from Usuario where DNI=\"" + dniactualizar + "\" and Clave=\"" + claveactualizar + "\"";
	}

	// Nos devolvera true si el usuario existe, si no, sera false
	public static boolean comprobarClave(ResultSet result) {
		try {
			if (result.next()) {
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo hacer la consulta a la base de datos");
			return false;
		}
		return false;
	}

	// Sentencia para actualizar usuario
	public static String sentenciaActualizar(String dniactualizar, String claveactualizar, String clavenueva) {
		return "update Usuario set Clave=\"" + clavenueva + "\" where DNI=\"" + dniactualizar + "\" and Clave=\""
				+ claveactualizar + "\"";
	}

	// sentencia para comprobar usuario login
	public static String sentenciaLogin(String logindni, String loginclave) {
		return "select * from Usuario where DNI=\"" + logindni + "\" and Clave=\"" + loginclave + "\"";
	}

	// si el usuario del login existe nos devolvera true, si no sera falso
	public static boolean login(ResultSet result) {
		try {
			if (result.next()) {
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo hacer la consulta a la base de datos");
			return false;
		}
		return false;
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
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo hacer la consulta a la base de datos");
		}

	}

	// Sentencia para rellenar el usuario
	public static String sentenciaInsertarUsuario(String dni, String nombre, String apellido, String clave) {
		return "insert into usuario(DNI, Nombre, Apellido, Clave) values(\"" + dni + "\", \"" + nombre + "\", \""
				+ apellido + "\", \"" + clave + "\"";
	}

	// Sentencia para borrar el usuario
	public static String sentenciaBorrarUsuario(String logindni, String loginclave) {
		return "delete from Usuario where DNI=\"" + logindni + "\" and Clave=\"" + loginclave + "\"";
	}
}
