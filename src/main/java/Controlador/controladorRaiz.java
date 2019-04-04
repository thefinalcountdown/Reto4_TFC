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


public class controladorRaiz {
	private Ventana ventana;
	private modelo modelo;
	
	public controladorRaiz(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;
	
		
		
		vistaRaiz.btnSum.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				vistaRaiz.num++;
				//por si hay que borrar el jtextfield
				//vistaRaiz.txthuesped.setText("");
				vistaRaiz.txthuesped.setText(Integer.toString(vistaRaiz.num));
			}
		});
		
		vistaRaiz.btnRest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				vistaRaiz.num--;
				vistaRaiz.txthuesped.setText(Integer.toString(vistaRaiz.num));
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
		
		/*vistaRaiz.btnBuscar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String ubicacionSeleccionada = vistaRaiz.comboBoxUbicacion.getSelectedItem().toString();
				//vistaHoteles vH = new vistaHoteles(vistaRaiz.num, ubicacionSeleccionada);
				vistaHoteles vH = new vistaHoteles();
				vH.setVisible(true);
				
			}
		});*/
		
	}
	
}
