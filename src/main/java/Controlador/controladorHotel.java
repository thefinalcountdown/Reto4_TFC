
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Modelo.Hotel_habitacion;
import Modelo.modelo;
import Vista.Ventana;
import metodos.GestorBD;

public class controladorHotel {
	private ArrayList<String> misNombreHoteles = new ArrayList<String>();

	private Ventana ventana;
	private modelo modelo;
	
	public static Hotel_habitacion Hotel1;

	public controladorHotel() {
	}

	public controladorHotel(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;
		

		ventana.hotel.btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				int index = 0;
				index = ventana.hotel.listaHoteles.getSelectedIndex();

				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Seleccione algun hotel.");
				} else {
					if(ventana.hotel.listaHabitaciones.getSelectedIndex()<controladorRaiz.num_Hab){
						JOptionPane.showMessageDialog(null, "Seleccione "+controladorRaiz.num_Hab+ " habitacion.");
					} else {
					
					
					ventana.reserva.textField_hotelseleccionado
							.setText(modelo.modeloListaHotel.hoteles.get(index).getNombre());
					ventana.reserva.textField_precio
							.setText(Float.toString(modelo.modeloListaHotel.hoteles.get(index).getPrecio()));
					ventana.cambio_panel(ventana.hotel, ventana.reserva);
				}

			}
			}
		});

		ventana.hotel.btnHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// vaciamos la lista cada vez que se le da al boton para que no conserve lo de
				// otros hoteles seleccionados
				try {
					modelo.modeloListaHabitacion.vaciarLista();
				}
				catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {


					modelo.modeloListaHabitacion.llenarLista(modelo.modeloListaHotel.hoteles
							.get(ventana.hotel.listaHoteles.getSelectedIndex()).getCod_alojamiento());
					ventana.hotel.listaHabitaciones.setModel(modelo.modeloListaHabitacion);

				} catch (Exception e1) {
					System.out.println("El ArrayList de dormitorios no ha sido rellenado");
					e1.printStackTrace();
				}

			}
		});

		ventana.hotel.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.hotel, ventana.raiz);
				try {
					modelo.modeloListaHabitacion.vaciarLista();
					modelo.modeloListaHotel.vaciarLista();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.hotel.listaHoteles.setModel(modelo.modeloListaHotel);

			}
		});

	}


}
