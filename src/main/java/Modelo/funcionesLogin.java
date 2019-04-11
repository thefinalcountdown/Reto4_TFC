package Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	// sentencia para comprobar usuario login
	public static String sentenciaLogin(String logindni, String loginclave) {
		return "select * from Usuario where DNI=\"" + logindni + "\" and Clave=\"" + loginclave + "\"";
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

}
