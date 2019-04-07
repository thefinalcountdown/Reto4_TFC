package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;

import Modelo.modelo;
import Vista.Ventana;
import Vista.vistaRaiz;
import metodos.GestorBD;


public class controladorRaiz {
	private Ventana ventana;
	private modelo modelo;
	private Controlador Controlador;
	
	public static int num_huespedes = 1;
	
	public controladorRaiz(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;
		
		
		//llenar el comboBox de ubicaciones
		try {
			llenarUbicaciones(GestorBD.obtenerUbicaciones());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//Calendario entrada
		vistaRaiz.fechaIn.getDateEditor().addPropertyChangeListener(
			new PropertyChangeListener() {
				
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					//Comprobar que se hayan seleccionado dos fechas, que el día de salida sea posterior al de entrada y que el dia de salida y entrada no sean el mismo
					if(vistaRaiz.fechaIn.getDate() != null && vistaRaiz.fechaOut.getDate() != null && (vistaRaiz.fechaIn.getDate().before(vistaRaiz.fechaOut.getDate())) && !(vistaRaiz.fechaIn.getDate().equals(vistaRaiz.fechaOut.getDate()))){
						vistaRaiz.btnBuscar.setEnabled(true);
					}
					/*
					if(vistaRaiz.fechaIn.getDate() != null || vistaRaiz.fechaOut.getDate() != null || (vistaRaiz.fechaIn.getDate().after(vistaRaiz.fechaOut.getDate())) || (vistaRaiz.fechaIn.getDate().getDay()==vistaRaiz.fechaOut.getDate().getDay())){
						vistaRaiz.btnBuscar.setEnabled(false);
					}*/
					
				}
				
			});
		
		
		//Calendario salida
		vistaRaiz.fechaOut.getDateEditor().addPropertyChangeListener(
			new PropertyChangeListener() {
				
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					//Comprobar que se hayan seleccionado dos fechas, que el día de salida sea posterior al de entrada y que el dia de salida y entrada no sean el mismo
					if(vistaRaiz.fechaIn.getDate() != null && vistaRaiz.fechaOut.getDate() != null && (vistaRaiz.fechaIn.getDate().before(vistaRaiz.fechaOut.getDate())) && !(vistaRaiz.fechaIn.getDate().getDay()==vistaRaiz.fechaOut.getDate().getDay())){
						vistaRaiz.btnBuscar.setEnabled(true);
					}
					
				}
			});
		
		
		//boton sumar huesped
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
		
		//boton restar huesped
		vistaRaiz.btnRest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(num_huespedes >1) {
					num_huespedes--;
					vistaRaiz.txthuesped.setText(Integer.toString(num_huespedes));
				}
			}
		});	
		
		//boton pasar siguiente ventana
		vistaRaiz.btnBuscar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String ubicacionSeleccionada = vistaRaiz.comboBoxUbicacion.getSelectedItem().toString();
				
				Date fechaIn = vistaRaiz.fechaIn.getDate();
				Date fechaOut = vistaRaiz.fechaOut.getDate();
				
				try {
					controladorHotel.llenarLista(GestorBD.obtenerHoteles(ubicacionSeleccionada));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				ventana.cambio_panel(ventana.raiz, ventana.hotel);
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
