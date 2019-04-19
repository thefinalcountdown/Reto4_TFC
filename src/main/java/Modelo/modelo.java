package Modelo;

import Controlador.Controlador;

public class modelo 
{
	private Controlador controlador;

	public ficheroReserva modeloFichero;
	public funcionesLogin modeloLogin;
	public ModeloLista modeloLista;
	
	public modelo()
	{
		this.modeloFichero = new ficheroReserva();
		this.modeloLogin = new funcionesLogin();
		this.modeloLista = new ModeloLista();
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
