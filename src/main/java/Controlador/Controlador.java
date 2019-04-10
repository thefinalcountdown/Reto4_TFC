package Controlador;

import Vista.Ventana;
import Modelo.modelo;

public class Controlador {
	public modelo modelo;
	public Ventana ventana;

	public controladorRaiz controladorRaiz;
	public controladorPago controladorPago;
	public controladorReserva controladorReserva;
	public controladorHotel controladorHotel;
	public controladorLogin controladorLogin;
	public controladorSeleccion controladorSeleccion;
	public controladorRegistro controladorRegistro;

	public Controlador(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		this.controladorRaiz = new controladorRaiz(ventana, modelo);
		this.controladorPago = new controladorPago(ventana, modelo);
		this.controladorReserva = new controladorReserva(ventana, modelo);
		this.controladorHotel = new controladorHotel(ventana, modelo);
		this.controladorLogin = new controladorLogin(ventana, modelo);
		this.controladorSeleccion = new controladorSeleccion(ventana, modelo);
		this.controladorRegistro = new controladorRegistro(ventana, modelo);
	}

	public controladorSeleccion getControladorSeleccion() {
		return controladorSeleccion;
	}

	public void setControladorSeleccion(controladorSeleccion controladorSeleccion) {
		this.controladorSeleccion = controladorSeleccion;
	}

	public controladorRegistro getControladorRegistro() {
		return controladorRegistro;
	}

	public void setControladorRegistro(controladorRegistro controladorRegistro) {
		this.controladorRegistro = controladorRegistro;
	}

	public controladorLogin getControladorLogin() {
		return controladorLogin;
	}

	public void setControladorLogin(controladorLogin controladorLogin) {
		this.controladorLogin = controladorLogin;
	}

	public controladorRaiz getControladorRaiz() {
		return controladorRaiz;
	}

	public void setControladorRaiz(controladorRaiz controladorRaiz) {
		this.controladorRaiz = controladorRaiz;
	}

	public controladorHotel getControladorHotel() {
		return controladorHotel;
	}

	public void setControladorHotel(controladorHotel controladorHotel) {
		this.controladorHotel = controladorHotel;
	}

	public controladorPago getControladorPago() {
		return controladorPago;
	}

	public void setControladorPago(controladorPago controladorPago) {
		this.controladorPago = controladorPago;
	}

	public controladorReserva getControladorReserva() {
		return controladorReserva;
	}

	public void setControladorReserva(controladorReserva controladorReserva) {
		this.controladorReserva = controladorReserva;
	}

}
