package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	private String nombre = "Godofredo";
	private String apellido = "Ruiz";
	private String dni = "12345678Z";
	private String clave = "12345";
	
	private Usuario usuarioTest = new Usuario();
	

	@Test
	public void testUsuario() {
		Usuario usuarioTest = new Usuario(nombre, apellido, dni, clave);
		assertEquals(usuarioTest.getNombre(), nombre);
		assertEquals(usuarioTest.getApellido(), apellido);
		assertEquals(usuarioTest.getDni(), dni);
		assertEquals(usuarioTest.getClave(), clave);
	}


	@Test
	public void testNombre() {
		usuarioTest.setNombre(nombre);
		assertEquals(usuarioTest.getNombre(), nombre);
	}

	@Test
	public void testApellido() {
		usuarioTest.setApellido(apellido);
		assertEquals(usuarioTest.getApellido(), apellido);
	}

	@Test
	public void testDni() {
		usuarioTest.setDni(dni);
		assertEquals(usuarioTest.getDni(), dni);
	}


	@Test
	public void testClave() {
		usuarioTest.setClave(clave);
		assertEquals(usuarioTest.getClave(), clave);
	}


	@Test
	public void testToString() {
		Usuario usuarioTest = new Usuario(nombre, apellido, dni, clave);
		String resultado_esperado = "DNI: " + dni + " Nombre: " + nombre + " Apellido: " + apellido;
		assertEquals(usuarioTest.toString(), resultado_esperado);
	}

}
