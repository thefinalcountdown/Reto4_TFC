package Modelo;

import Controlador.Controlador;

public class modelo {
	private Controlador controlador;

	public ficheroReserva modeloFichero;
	public funcionesLogin modeloLogin;
	public funcionesRegistro modeloRegistro;
	public ModeloListaHoteles modeloListaHotel;
	public ModeloListaHabitaciones modeloListaHabitacion;

	public modelo() {
		this.modeloFichero = new ficheroReserva();
		this.modeloLogin = new funcionesLogin();
		this.modeloRegistro = new funcionesRegistro();
		this.modeloListaHotel = new ModeloListaHoteles();
		this.modeloListaHabitacion = new ModeloListaHabitaciones();
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}
