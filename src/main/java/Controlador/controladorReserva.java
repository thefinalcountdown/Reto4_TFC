package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.modelo;
import Vista.Ventana;

public class controladorReserva 
{
	private Ventana ventana;
	private modelo modelo; 
	
	public controladorReserva(Ventana ventana, modelo modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;
		
		
		ventana.reserva.Continuar_Reserva.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ventana.cambio_panel(ventana.reserva, ventana.pago);
				int precio = Integer.parseInt(ventana.reserva.textField_precio.getText())*Integer.parseInt(ventana.reserva.textField_numpersonas.getText());
				ventana.pago.DineroFaltante.setText(Integer.toString(precio));
				controladorPago.precio = precio;
				controladorPago.total_faltante = precio;
			}
		});
		
		ventana.reserva.Cancelar_Reserva.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ventana.cambio_panel(ventana.reserva, ventana.hotel);
			
			}
		});
	}
}
