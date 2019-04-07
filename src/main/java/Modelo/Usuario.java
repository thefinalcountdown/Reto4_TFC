package Modelo;

public class Usuario {

	private String nombre;
	private String apellido;
	private String dni;
	private String clave;
	
	public Usuario(String nombre, String apellido, String dni, String clave) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.clave = clave;
	}
	
	public Usuario() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}
