package Modelo;

import Controlador.Controlador;

public class modelo 
{
	private Controlador controlador;

	public ficheroReserva modeloFichero;
	public funcionesLogin modeloLogin;
	public ModeloListaHoteles modeloLista;
	public Hotel_habitacion hotel_habitacion;
	
	public modelo()
	{
		this.modeloFichero = new ficheroReserva();
		this.modeloLogin = new funcionesLogin();
		this.modeloLista = new ModeloListaHoteles();
		this.hotel_habitacion= new Hotel_habitacion();
	}

	public Controlador getControlador() 
	{
		return controlador;
	}

	public void setControlador(Controlador controlador) 
	{
		this.controlador = controlador;
	}
	
	
}
