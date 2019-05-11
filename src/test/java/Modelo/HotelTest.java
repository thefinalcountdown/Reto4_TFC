package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelTest {
	private String nombre = "Suitopia";
	private String ubicacion = "Alicante";
	private int Cod_alojamiento = 3;
	private int estrellas = 2;
	
	Hotel hotelTest = new Hotel();
	
	@Test
	public void testHotel_sin_estrellas() {
		Hotel hotelTest = new Hotel (nombre, ubicacion, Cod_alojamiento);
		assertEquals(hotelTest.getNombre(),nombre);
		assertEquals(hotelTest.getUbicacion(), ubicacion);
		assertEquals(hotelTest.getCod_alojamiento(), Cod_alojamiento);
	}

	@Test
	public void testHotel() {
		Hotel hotelTest = new Hotel (nombre, ubicacion, Cod_alojamiento, estrellas);
		assertEquals(hotelTest.getNombre(),nombre);
		assertEquals(hotelTest.getUbicacion(), ubicacion);
		assertEquals(hotelTest.getCod_alojamiento(), Cod_alojamiento);
		assertEquals(hotelTest.getEstrellas(), estrellas);
	}

	@Test
	public void testEstrellas() {
		hotelTest.setEstrellas(estrellas);
		assertEquals(hotelTest.getEstrellas(), estrellas);
	}
}
