package Controlador;

import Vista.Ventana;

import javax.swing.JPanel;

import Modelo.modelo;

public class Controlador 
{
	public modelo modelo;
	public Ventana ventana;
	
	public controladorPago controladorPago;
	public controladorReserva controladorReserva;
	
	public Controlador(Ventana ventana, modelo modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;
		
		this.controladorPago = new controladorPago(ventana, modelo);
		this.controladorReserva = new controladorReserva(ventana, modelo);
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
