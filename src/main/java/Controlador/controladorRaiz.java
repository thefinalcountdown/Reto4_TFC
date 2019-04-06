package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Modelo.Hotel;
import Modelo.ModeloLista;
import Modelo.modelo;
import Vista.Ventana;
import metodos.GestorBD;


public class controladorRaiz {
	private Ventana ventana;
	private modelo modelo;
	
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
		ventana.raiz.btnSum.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				num_huespedes++;
				//por si hay que borrar el jtextfield
				//vistaRaiz.txthuesped.setText("");
				ventana.raiz.txthuesped.setText(Integer.toString(num_huespedes));
			}
		});
		
		//boton restar huesped
		ventana.raiz.btnRest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(num_huespedes >1) {
					num_huespedes--;
					ventana.raiz.txthuesped.setText(Integer.toString(num_huespedes));
				}
			}
		});	
		
		//boton pasar siguiente ventana
		ventana.raiz.btnBuscar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
<<<<<<< HEAD
				
=======
				String ubicacionSeleccionada = ventana.raiz.comboBoxUbicacion.getSelectedItem().toString();
>>>>>>> 53cd3e258e74d6e03a5086525bd44af6c3d8f232
				
				
				try {
//					controladorHotel.llenarLista(GestorBD.obtenerHoteles(ubicacionSeleccionada));
					ModeloLista.llenarLista();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				ventana.cambio_panel(ventana.raiz, ventana.hotel);
				ventana.reserva.textField_numpersonas.setText(ventana.raiz.txthuesped.getText());
				ventana.reserva.textField_ubicacion.setText(ventana.raiz.comboBoxUbicacion.getSelectedItem().toString());
				
			}
		});
		
	}
	
	
	public void llenarUbicaciones(ArrayList<String> ubicaciones){
		for(int i=0; i< ubicaciones.size(); i++) {
			ventana.raiz.comboBoxUbicacion.addItem(ubicaciones.get(i));
		}
	}
	
}
