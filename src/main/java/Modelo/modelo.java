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
	public Dormitorio dormitorio;

	public modelo() {
		this.modeloFichero = new ficheroReserva();
		this.modeloLogin = new funcionesLogin();
		this.modeloRegistro = new funcionesRegistro();
		this.modeloTabla = new ModeloTablaHabitacion();
		this.modeloListaAlojamiento= new ModeloListaAlojamiento();
		this.insercionReserva = new insercionReserva();
		this.dormitorio= new Dormitorio();

	}

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public ficheroReserva getModeloFichero() {
		return modeloFichero;
	}

	public void setModeloFichero(ficheroReserva modeloFichero) {
		this.modeloFichero = modeloFichero;
	}

	public funcionesLogin getModeloLogin() {
		return modeloLogin;
	}

	public void setModeloLogin(funcionesLogin modeloLogin) {
		this.modeloLogin = modeloLogin;
	}

	public funcionesRegistro getModeloRegistro() {
		return modeloRegistro;
	}

	public void setModeloRegistro(funcionesRegistro modeloRegistro) {
		this.modeloRegistro = modeloRegistro;
	}

	public ModeloListaAlojamiento getModeloListaAlojamiento() {
		return modeloListaAlojamiento;
	}

	public void setModeloListaAlojamiento(ModeloListaAlojamiento modeloListaAlojamiento) {
		this.modeloListaAlojamiento = modeloListaAlojamiento;
	}

	public insercionReserva getInsercionReserva() {
		return insercionReserva;
	}

	public void setInsercionReserva(insercionReserva insercionReserva) {
		this.insercionReserva = insercionReserva;
	}
	
	

}
