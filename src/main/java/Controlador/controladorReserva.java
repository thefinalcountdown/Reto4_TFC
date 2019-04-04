package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.modelo;
import Vista.Ventana;
import Vista.vistaReserva;

public class controladorReserva 
{
	private Ventana ventana;
	private modelo modelo;
	
	
	public controladorReserva(Ventana ventana, modelo modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;
		
		
		vistaReserva.Continuar_Reserva.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ventana.cambio_panel(ventana.reserva, ventana.pago);
			}
		});
		
		vistaReserva.Cancelar_Reserva.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
	}
}
