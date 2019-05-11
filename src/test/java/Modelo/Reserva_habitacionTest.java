package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class Reserva_habitacionTest {

	private int num_habitacion;
	private String fecha_entrada;
	private String fecha_salida;
	
	private Reserva_habitacion Reserva_habitacionTest = new Reserva_habitacion();
	
	
	@Test
	public void testReserva_habitacion() {
		Reserva_habitacion Reserva_habitacionTest = new Reserva_habitacion(num_habitacion, fecha_entrada, fecha_salida);
		assertEquals(Reserva_habitacionTest.getNum_habitacion(), num_habitacion);
		assertEquals(Reserva_habitacionTest.getFecha_entrada(), fecha_entrada);
		assertEquals(Reserva_habitacionTest.getFecha_salida(), fecha_salida);
	}

	@Test
	public void testNum_habitacion() {
		Reserva_habitacionTest.setNum_habitacion(num_habitacion);
		assertEquals(Reserva_habitacionTest.getNum_habitacion(), num_habitacion);
	}

	@Test
	public void testFecha_entrada() {
		Reserva_habitacionTest.setFecha_entrada(fecha_entrada);
		assertEquals(Reserva_habitacionTest.getFecha_entrada(), fecha_entrada);
	}

	@Test
	public void testFecha_salida() {
		Reserva_habitacionTest.setFecha_salida(fecha_salida);
		assertEquals(Reserva_habitacionTest.getFecha_salida(), fecha_salida);
	}

	@Test
	public void testToString() {
		String resultado_esperado = "N\u00famero de habitaci\u00f3n=" + num_habitacion + " Fecha de entrada=" + fecha_entrada + " Fecha de salida=" + fecha_salida;
		assertEquals(Reserva_habitacionTest.toString(), resultado_esperado);
	}

}
