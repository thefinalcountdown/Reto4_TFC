package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Modelo.Hotel;
import Modelo.ModeloLista;
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
				
				
				
				try {
//					controladorHotel.llenarLista(GestorBD.obtenerHoteles(ubicacionSeleccionada));
					ModeloLista.llenarLista();
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
