package Controlador;

import Vista.Ventana;
import Modelo.modelo;

public class Controlador {
	public modelo modelo;
	public Ventana ventana;
	
	public controladorBienvenida controladorBienvenida;
	public controladorLogin controladorLogin;
	public controladorRegistro controladorRegistro;
	public controladorModificar controladorModificar;
	public controladorAceptarCondiciones controladorAceptarCondiciones;
	public controladorRaiz controladorRaiz;
	public controladorPago controladorPago;
	public controladorReserva controladorReserva;
	public controladorHotel controladorHotel;

	public Controlador(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;
		
		this.controladorBienvenida = new controladorBienvenida(ventana, modelo);
		this.controladorLogin = new controladorLogin(ventana, modelo);
		this.controladorRegistro = new controladorRegistro(ventana, modelo);
		this.controladorModificar = new controladorModificar(ventana, modelo);
		this.controladorAceptarCondiciones = new controladorAceptarCondiciones(ventana, modelo);
		this.controladorRaiz = new controladorRaiz(ventana, modelo);
		this.controladorHotel = new controladorHotel(ventana, modelo);
		this.controladorReserva = new controladorReserva(ventana, modelo);
		this.controladorPago = new controladorPago(ventana, modelo);

	}
}
