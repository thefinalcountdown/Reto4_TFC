package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasaTest {

	private int Num_banos = 3;
	private int Superficie = 50;
	private int Piso = 1;
	private String nombre = "Suitopia";
	private String ubicacion = "Alicante";
	private int cod_alojamiento = 100;
	
	
	private Casa casaTest = new Casa();
	
	@Test
	public void testCasa() {
		Casa casaTest = new Casa(nombre, ubicacion, cod_alojamiento, Num_banos, Superficie, Piso);
		assertEquals(casaTest.getNombre(), "Suitopia");
		assertEquals(casaTest.getUbicacion(), "Alicante");
		assertEquals(casaTest.getCod_alojamiento(), 100);
		assertEquals(casaTest.getNum_banos(), 3);
		assertEquals(casaTest.getSuperficie(), 50);
		assertEquals(casaTest.getPiso(), 1);
	}
	
	@Test
	public void testNum_banos() {
		casaTest.setNombre(nombre);
		assertEquals(casaTest.getNombre(), nombre);
	}

	@Test
	public void testSuperficie() {
		casaTest.setSuperficie(Superficie);
		assertEquals(casaTest.getSuperficie(), Superficie);
	}

	@Test
	public void testPiso() {
		casaTest.setPiso(Piso);
		assertEquals(casaTest.getPiso(), Piso);
	}

}
