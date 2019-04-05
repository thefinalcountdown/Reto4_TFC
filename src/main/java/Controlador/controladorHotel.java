package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import Modelo.Hotel;
import Modelo.modelo;
import Vista.Ventana;
import Vista.vistaHoteles;
import Vista.vistaRaiz;
import metodos.GestorBD;

public class controladorHotel implements ListModel {
	private ArrayList<String> misNombreHoteles = new ArrayList<String>();

	private Ventana ventana;
	private modelo modelo;
	
	public controladorHotel() {
	}

	public controladorHotel(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.hotel.btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.hotel, ventana.reserva);
				ventana.reserva.textField_precio.setText("80");
				ventana.reserva.textField_hotelseleccionado.setText(vistaHoteles.listaHoteles.getSelectedItem().toString());
			}
		});

		ventana.hotel.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.hotel, ventana.raiz);
				vaciarComboBox();
			}
		});

	}
//  Metodo para La lista
//	public void rellenarModel(ArrayList<String> hotel) {
//		System.out.println("golla");
//
//		for (int index = 0; index < hotel.size(); index++) {
//			vistaHoteles.listaHoteles.add(hotel.get(index), ventana);
//		}
//	}
	
	
	
	//Metodo para rellenar con el comboBox
	
	public static void llenarLista(ArrayList<String> hotel) {
		for (int i = 0; i < hotel.size(); i++) {
			vistaHoteles.listaHoteles.addItem(hotel.get(i));
		}
	}

	public static void vaciarComboBox() {
		
			vistaHoteles.listaHoteles.removeAllItems();
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}
}
