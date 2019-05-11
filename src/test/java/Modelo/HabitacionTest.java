package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class HabitacionTest {
	
	private String Cod_habitacion;
	private float metrosCuadrados;
	private String tipo;
	private String descripcion;
	private float precio;
	
	private Habitacion habitacionTest = new Habitacion();

	@Test
	public void testHabitacion() {
		Habitacion habitacionTest = new Habitacion(Cod_habitacion, metrosCuadrados, tipo, descripcion, precio);
		assertEquals(habitacionTest.getCod_habitacion(), Cod_habitacion);
		assertEquals(habitacionTest.getTipo(), tipo);
		assertEquals(habitacionTest.getDescripcion(), descripcion);
		assertEquals(habitacionTest.getPrecio(), precio, 0);
		assertEquals(habitacionTest.getMetrosCuadrados(), metrosCuadrados, 0);
	}

	@Test
	public void testCod_habitacion() {
		habitacionTest.setCod_habitacion(Cod_habitacion);
		assertEquals(habitacionTest.getCod_habitacion(), Cod_habitacion);
	}

	@Test
	public void testTipo() {
		habitacionTest.setTipo(tipo);
		assertEquals(habitacionTest.getTipo(), tipo);
	}

	@Test
	public void testDescripcion() {
		habitacionTest.setDescripcion(descripcion);
		assertEquals(habitacionTest.getDescripcion(), descripcion);
	}

	@Test
	public void testPrecio() {
		habitacionTest.setPrecio(precio);
		assertEquals(habitacionTest.getPrecio(), precio, 0);
	}

	@Test
	public void testMetrosCuadrados() {
		habitacionTest.setMetrosCuadrados(metrosCuadrados);
		assertEquals(habitacionTest.getMetrosCuadrados(), metrosCuadrados, 0);
	}

	@Test
	public void testToString() {
		String resultado_esperado = "C\u00f3digo de habitaci\u00f3n=" + Cod_habitacion + " Metros cuadrados=" + metrosCuadrados + " Tipo="
				+ tipo + " Descripci\u00f3n=" + descripcion + " Precio=" + precio;
		assertEquals(habitacionTest.toString(), resultado_esperado);
	}

}
