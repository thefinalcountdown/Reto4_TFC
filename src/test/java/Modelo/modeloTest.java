package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Controlador.Controlador;

public class modeloTest {
	
	private Controlador controlador;

	private ficheroReserva modeloFichero;
	private funcionesLogin modeloLogin;
	private funcionesRegistro modeloRegistro;
	private ModeloListaAlojamiento modeloListaAlojamiento;
	private insercionReserva insercionReserva;
	
	private modelo modeloTest = new modelo();
	
	
	@Test
	public void testModelo() {
		ficheroReserva modeloFichero = new ficheroReserva();
		funcionesLogin modeloLogin = new funcionesLogin();
		funcionesRegistro modeloRegistro = new funcionesRegistro();
		ModeloListaAlojamiento modeloListaAlojamiento = new ModeloListaAlojamiento();
		insercionReserva insercionReserva = new insercionReserva();
		
		assertEquals(modeloTest.getModeloFichero(), modeloFichero);
		assertEquals(modeloTest.getModeloLogin(), modeloLogin);
		assertEquals(modeloTest.getModeloRegistro(), modeloRegistro);
		assertEquals(modeloTest.getModeloListaAlojamiento(), modeloListaAlojamiento);
		assertEquals(modeloTest.getInsercionReserva(), insercionReserva);
		
	}

	@Test
	public void testControlador() {
		modeloTest.setControlador(controlador);
		assertEquals(modeloTest.getControlador(), controlador);
	}


	@Test
	public void testModeloFichero() {
		modeloTest.setModeloFichero(modeloFichero);
		assertEquals(modeloTest.getModeloFichero(), modeloFichero);
	}

	@Test
	public void testModeloLogin() {
		modeloTest.setModeloLogin(modeloLogin);
		assertEquals(modeloTest.getModeloLogin(), modeloLogin);
	}


	@Test
	public void testModeloRegistro() {
		modeloTest.setModeloRegistro(modeloRegistro);
		assertEquals(modeloTest.getModeloRegistro(), modeloRegistro);
	}


	@Test
	public void testModeloListaAlojamiento() {
		modeloTest.setModeloListaAlojamiento(modeloListaAlojamiento);
		assertEquals(modeloTest.getModeloListaAlojamiento(), modeloListaAlojamiento);
	}


	@Test
	public void testInsercionReserva() {
		modeloTest.setInsercionReserva(insercionReserva);
		assertEquals(modeloTest.getInsercionReserva(), insercionReserva);
	}

}
