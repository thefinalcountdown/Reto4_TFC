package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class funcionesRegistro {

	public boolean comprobarCampos(String dni, String nombre, String apellido, String clave) {
		// String sentencia = "insert into Usuario(DNI, Nombre, Apellido, Clave)" +
		// "values(\"" + dni + "\", \"" + nombre
		// + "\", \"" + apellido + "\", \"" + clave + "\")";

		if (dni.equals("") || nombre.equals("") || apellido.equals("") || clave.equals("")) {
			return true;
		} else {
			return false;
		}

	}

	public String sentenciaInsertarUsuario(String dni, String nombre, String apellido, String clave) {
		return "insert into Usuario(DNI, Nombre, Apellido, Clave) values(\"" + dni.toUpperCase() + "\", \""
				+ nombre.toUpperCase() + "\", \"" + apellido.toUpperCase() + "\", \"" + AES.encrypt(clave, "llave")
				+ "\")";
	}

	public boolean validarNIF(String nif) {

		boolean correcto = false;
		Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		Matcher matcher = pattern.matcher(nif);
		if (matcher.matches()) {
			String letra = matcher.group(2);
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int index = Integer.parseInt(matcher.group(1));
			index = index % 23;
			String reference = letras.substring(index, index + 1);
			if (reference.equalsIgnoreCase(letra)) {
				correcto = true;
			} else {
				correcto = false;
			}
		} else {
			correcto = false;
		}
		return correcto;
	}
}
