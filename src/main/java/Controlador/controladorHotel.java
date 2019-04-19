package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import Modelo.Hotel;
import Modelo.ModeloLista;
import Modelo.modelo;
import Vista.Ventana;
import Vista.vistaHoteles;
import Vista.vistaRaiz;
import metodos.GestorBD;

public class controladorHotel{
	private ArrayList<String> misNombreHoteles = new ArrayList<String>();

	private Ventana ventana;
	private modelo modelo;
	
	private ModeloLista lm= new ModeloLista();

	public controladorHotel() {
	}

	public controladorHotel(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.hotel.btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.hotel, ventana.reserva);

//				float precio_reserva = Float.parseFloat(separarString(vistaHoteles.listaHoteles)[1]);
				
//				ventana.reserva.textField_precio.setText(Float.toString(precio_reserva*Integer.parseInt(ventana.raiz.txthuesped.getText())));
//				ventana.reserva.textField_hotelseleccionado.setText(separarString(vistaHoteles.listaHoteles)[0]);
			}
		});

		ventana.hotel.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.hotel, ventana.raiz);
				try {
					controladorRaiz.lm.vaciarLista();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.hotel.listaHoteles.setModel(lm);

				
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

	// Metodo para vaciar la Lista:

//	public static void vaciarLista(JList lista) {
//		DefaultListModel model=new DefaultListModel();
//        model.clear();
//        lista.setModel(model);
//			
//		
//	}

//	// Metodo para vaciar con el comboBox:
//
//	public static void vaciarComboBox() {
//
//		vistaHoteles.listaHoteles.removeAllItems();
//	}


}
