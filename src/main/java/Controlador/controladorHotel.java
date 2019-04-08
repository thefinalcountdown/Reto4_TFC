package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JComboBox;
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

				float precio_reserva = Float.parseFloat(separarString(vistaHoteles.listaHoteles)[1]);
				
				ventana.reserva.textField_precio.setText(Float.toString(precio_reserva*Integer.parseInt(ventana.raiz.txthuesped.getText())));
				ventana.reserva.textField_hotelseleccionado.setText(separarString(vistaHoteles.listaHoteles)[0]);
			}
		});

		ventana.hotel.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.hotel, ventana.raiz);
				vaciarComboBox();
			}
		});

	}

	// Metodo para separar los String del Arraylist<String> para mostrar el nombre y
	// el
	// precio separados

	public static String[] separarString(JComboBox hotel) {
		String linea = hotel.getSelectedItem().toString();
		int contador = 0;
		String campo = "";
		String uno = "";
		String dos = "";
		while (contador < linea.length()) {
			if (linea.charAt(contador) != ';')
				campo += linea.charAt(contador);
			if ((linea.charAt(contador) == ';') || (contador == linea.length() - 1)) {
				if (uno == "") {
					uno = campo;
					campo = "";
				} else if (uno != "" && dos == "") {
					dos = campo;
					campo = "";
					break;
				}

			}
			contador++;
		}

		String[] nomPrecio = { uno, dos };
		return nomPrecio;
	}

	// Metodo para rellenar con el comboBox:

	public static void llenarLista(ArrayList<String> hotel) {
		for (int i = 0; i < hotel.size(); i++) {
			vistaHoteles.listaHoteles.addItem(hotel.get(i));
		}
	}

	// Metodo para vaciar con el comboBox:

	public static void vaciarComboBox() {

		vistaHoteles.listaHoteles.removeAllItems();
	}

	// Metodos de la interfaz ListModel son necesarios:
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
