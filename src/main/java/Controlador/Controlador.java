package Controlador;

import Vista.Ventana;
import Modelo.modelo;

public class Controlador 
{
	public modelo modelo;
	public Ventana ventana;
	
	public controladorRaiz controladorRaiz;
	public controladorPago controladorPago;
	public controladorReserva controladorReserva;
	
	
	public Controlador(Ventana ventana, modelo modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;

		this.controladorRaiz = new controladorRaiz(ventana, modelo);
		this.controladorPago = new controladorPago(ventana, modelo);
		this.controladorReserva = new controladorReserva(ventana, modelo);
		
	}
	
	

	public controladorRaiz getControladorRaiz() {
		return controladorRaiz;
	}



	public void setControladorRaiz(controladorRaiz controladorRaiz) {
		this.controladorRaiz = controladorRaiz;
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
