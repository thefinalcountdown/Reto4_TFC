package Modelo;

import Controlador.Controlador;

public class modelo {

	private Controlador controlador;

	public ficheroReserva modeloFichero;
	public funcionesLogin modeloLogin;
	public funcionesRegistro modeloRegistro;
	public ModeloListaAlojamiento modeloListaAlojamiento;
	public insercionReserva insercionReserva;
	public Dormitorio dormitorio;
	public Habitacion habitacion;

	public modelo() {
		this.modeloFichero = new ficheroReserva();
		this.modeloLogin = new funcionesLogin();
		this.modeloRegistro = new funcionesRegistro();
		this.modeloListaAlojamiento = new ModeloListaAlojamiento();
		this.insercionReserva = new insercionReserva();
		this.dormitorio = new Dormitorio();
		this.habitacion = new Habitacion();

	}

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
}
