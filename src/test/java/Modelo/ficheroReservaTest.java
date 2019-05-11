package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Vista.Ventana;

public class ficheroReservaTest {

	private int Cod_Hotel = 100;
	private String nombreHotel = "Suitopia";
	private float precio = 80f;
	private int numPersonas = 3;
	private int numHabitaciones = 2;
	private String ubicacion = "Alicante";
	private String fecha_entrada = "26/03/2018";
	private String fecha_salida = "28/03/2018";
	private String DNI = "12345678Z";
	private String usuario = "Alfredo";
	private static String nombre_fichero;
	
	private Ventana ventana;
	private modelo modelo;
	
	private ficheroReserva ficheroReservaTest = new ficheroReserva();
	
	@Test
	public void testFicheroReserva() {
		ficheroReserva ficheroReservaTest = new ficheroReserva(Cod_Hotel, nombreHotel, precio, numPersonas, numHabitaciones, 
				ubicacion, fecha_entrada, fecha_salida, DNI, usuario);
		assertEquals(ficheroReservaTest.getCod_Hotel(), Cod_Hotel);
		assertEquals(ficheroReservaTest.getNombreHotel(), nombreHotel);
		assertEquals(ficheroReservaTest.getPrecio(), precio, 0);
		assertEquals(ficheroReservaTest.getNumPersonas(), numPersonas);
		assertEquals(ficheroReservaTest.getNumHabitaciones(), numHabitaciones);
		assertEquals(ficheroReservaTest.getUbicacion(), ubicacion);
		assertEquals(ficheroReservaTest.getFecha_entrada(), fecha_entrada);
		assertEquals(ficheroReservaTest.getFecha_salida(), fecha_salida);
		assertEquals(ficheroReservaTest.getDNI(), DNI);
		assertEquals(ficheroReservaTest.getUsuario(), usuario);
		
	}


	@Test
	public void testNumPersonas() {
		ficheroReservaTest.setNumPersonas(numPersonas);
		assertEquals(ficheroReservaTest.getNumPersonas(), numPersonas);
	}

	@Test
	public void testNombreHotel() {
		ficheroReservaTest.setNombreHotel(nombreHotel);
		assertEquals(ficheroReservaTest.getNombreHotel(), nombreHotel);
	}

	@Test
	public void testUbicacion() {
		ficheroReservaTest.setUbicacion(ubicacion);
		assertEquals(ficheroReservaTest.getUbicacion(), ubicacion);
	}

	@Test
	public void testPrecio() {
		ficheroReservaTest.setPrecio(precio);
		assertEquals(ficheroReservaTest.getPrecio(), precio, 0);
	}
	
	@Test
	public void testCod_Hotel() {
		ficheroReservaTest.setCod_Hotel(Cod_Hotel);
		assertEquals(ficheroReservaTest.getCod_Hotel(), Cod_Hotel);
	}

	@Test
	public void testNumHabitaciones() {
		ficheroReservaTest.setNumHabitaciones(numHabitaciones);
		assertEquals(ficheroReservaTest.getNumHabitaciones(), numHabitaciones);
	}

	@Test
	public void testFecha_entrada() {
		ficheroReservaTest.setFecha_entrada(fecha_entrada);
		assertEquals(ficheroReservaTest.getFecha_entrada(), fecha_entrada);
	}

	@Test
	public void testFecha_salida() {
		ficheroReservaTest.setFecha_salida(fecha_salida);
		assertEquals(ficheroReservaTest.getFecha_salida(), fecha_salida);
	}

	@Test
	public void testDNI() {
		ficheroReservaTest.setDNI(DNI);
		assertEquals(ficheroReservaTest.getDNI(), DNI);
	}

	@Test
	public void testUsuario() {
		ficheroReservaTest.setUsuario(usuario);
		assertEquals(ficheroReservaTest.getUsuario(), usuario);
	}

	@Test
	public void testNombre_fichero() {
		ficheroReservaTest.setNombre_fichero(nombre_fichero);
		assertEquals(ficheroReservaTest.getNombre_fichero(), nombre_fichero);
	}

	@Test
	public void testVentana() {
		ficheroReservaTest.setVentana(ventana);
		assertEquals(ficheroReservaTest.getVentana(), ventana);
	}

	@Test
	public void testModelo() {
		ficheroReservaTest.setModelo(modelo);
		assertEquals(ficheroReservaTest.getModelo(), modelo);
	}

//	@Test
//	public void testImprimirTicket() {
//		ficheroReservaTest.imprimirTicket(DNI, nombreHotel, fecha_entrada, fecha_salida);
//		
//	}
//
//	@Test
//	public void testLeerTicket() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testConversion_espacio_a_guion() {
		String texto = "Esto es una prueba";
		String resultado_esperado = "Esto-es-una-prueba";
		assertEquals(ficheroReservaTest.conversion_espacio_a_guion(texto), resultado_esperado);
	}

	@Test
	public void testConversion_slash_a_guion() {
		String texto = "13/04/2017";
		String resultado_esperado = "13-04-2017";
		assertEquals(ficheroReservaTest.conversion_slash_a_guion(texto), resultado_esperado);
	}

}
