package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import Modelo.modelo;
import Vista.Ventana;
import Vista.vistaHoteles;
import Vista.vistaPago;
import Vista.vistaRaiz;
import Vista.vistaReserva;


public class controladorRaiz {
	private Ventana ventana;
	private modelo modelo;
	
	public static int num_huespedes = 0;
	
	public controladorRaiz(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;
		
		
		vistaRaiz.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		vistaRaiz.btnSum.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				num_huespedes++;
				//por si hay que borrar el jtextfield
				//vistaRaiz.txthuesped.setText("");
				vistaRaiz.txthuesped.setText(Integer.toString(num_huespedes));
			}
		});
		
		vistaRaiz.btnRest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				num_huespedes--;
				vistaRaiz.txthuesped.setText(Integer.toString(num_huespedes));
			}
		});	
		
		/*
		vistaRaiz.comboBoxUbicacion.addItemListener(new ItemListener() {
	
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
	
					try {
						ubicacionSeleccionada = vistaRaiz.comboBoxUbicacion.getSelectedItem().toString();
								
					} catch (Exception e2) {
	
						e2.printStackTrace();
					}
				}
	
			}
	
		});*/
		
		vistaRaiz.btnBuscar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
//				String ubicacionSeleccionada = vistaRaiz.comboBoxUbicacion.getSelectedItem().toString();
				
				ventana.cambio_panel(ventana.raiz, ventana.reserva);
				ventana.reserva.textField_numpersonas.setText(vistaRaiz.txthuesped.getText());
			}
		});
		
	}
	
}
