package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Modelo.modelo;
import Vista.Ventana;
import Vista.vistaRaiz;
import metodos.GestorBD;


public class controladorRaiz {
	private Ventana ventana;
	private modelo modelo;
	
	public static int num_huespedes = 0;
	
	public controladorRaiz(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;
		
		
		//llenar el comboBox de ubicaciones
		try {
			llenarUbicaciones(GestorBD.obtenerUbicaciones());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
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
				if(num_huespedes >0) {
					num_huespedes--;
					vistaRaiz.txthuesped.setText(Integer.toString(num_huespedes));
				}
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
				ventana.reserva.textField_ubicacion.setText(vistaRaiz.comboBoxUbicacion.getSelectedItem().toString());
			}
		});
		
	}
	
	
	public void llenarUbicaciones(ArrayList<String> ubicaciones){
		for(int i=0; i< ubicaciones.size(); i++) {
			vistaRaiz.comboBoxUbicacion.addItem(ubicaciones.get(i));
		}
	}
	
}
