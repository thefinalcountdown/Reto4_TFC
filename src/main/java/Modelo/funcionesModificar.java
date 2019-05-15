package Modelo;

public class funcionesModificar {

	// sentencia para borrar usuario
		public String sentenciaBorrarUsuario(String dni, String clave) 
		{
			return "delete from Usuario where DNI=\"" + dni.toUpperCase() + "\" and Clave=\""+ AES.encrypt(clave, "llave") + "\"";
		}

		// sentencia actualizar usuario
		public String sentenciaActualizarUsuario(String dni, String clave, String nuevaclave) 
		{
			return "update Usuario set Clave=\"" + AES.encrypt(nuevaclave, "llave") + "\" where DNI=\"" + dni.toUpperCase()
					+ "\" and Clave=\"" + AES.encrypt(clave, "llave") + "\""; 

		}
}
