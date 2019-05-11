package Modelo;

import Controlador.Controlador;

public class modelo {
	private Controlador controlador;

	public ficheroReserva modeloFichero;
	public funcionesLogin modeloLogin;
	public funcionesRegistro modeloRegistro;
	public ModeloTablaHabitacion modeloTabla;
	public ModeloListaAlojamiento modeloListaAlojamiento;
	public insercionReserva insercionReserva;

	public modelo() {
		this.modeloFichero = new ficheroReserva();
		this.modeloLogin = new funcionesLogin();
		this.modeloRegistro = new funcionesRegistro();
		this.modeloTabla = new ModeloTablaHabitacion();
		this.modeloListaAlojamiento= new ModeloListaAlojamiento();
		this.insercionReserva = new insercionReserva();

	}

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}
