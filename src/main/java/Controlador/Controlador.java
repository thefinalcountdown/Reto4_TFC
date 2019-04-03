package Controlador;

import Vista.Ventana;

import javax.swing.JPanel;

import Modelo.modelo;

public class Controlador 
{
	public modelo modelo;
	public Ventana ventana;
	
	public controladorPago controladorPago;
	
	public Controlador(Ventana ventana, modelo modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;
		
		this.controladorPago = new controladorPago(ventana, modelo);
	}

	public controladorPago getControladorPago() {
		return controladorPago;
	}

	public void setControladorPago(controladorPago controladorPago) {
		this.controladorPago = controladorPago;
	}
	
}
