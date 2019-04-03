package Controlador;

import Modelo.modelo;
import Vista.Ventana;

public class Principal {

	Ventana ventana;
	modelo modelo;
	Controlador controlador;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Principal principal = new Principal();
		
		principal.iniciar();
	}

	public void iniciar()
	{
		Ventana ventana = new Ventana();
		modelo modelo = new modelo();
		Controlador controlador = new Controlador(ventana, modelo);
		
		modelo.setControlador(controlador);
		
		ventana.setVisible(true);
	}
}
