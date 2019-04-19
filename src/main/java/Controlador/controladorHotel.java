package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Modelo.modelo;
import Vista.Ventana;


public class controladorHotel{
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
				

//				float precio_reserva = Float.parseFloat(separarString(vistaHoteles.listaHoteles)[1]);
				
//				ventana.reserva.textField_precio.setText(Float.toString(precio_reserva*Integer.parseInt(ventana.raiz.txthuesped.getText())));
//				ventana.reserva.textField_hotelseleccionado.setText(separarString(vistaHoteles.listaHoteles)[0]);
				int index = 0;
				index = ventana.hotel.listaHoteles.getSelectedIndex();
				
				
				if (index == -1)
				{
					JOptionPane.showMessageDialog(null, "Seleccione algun hotel.");
				}
				else
				{
					ventana.reserva.textField_hotelseleccionado.setText(modelo.modeloLista.hoteles.get(index).getNombre());
					ventana.reserva.textField_precio.setText(Float.toString(modelo.modeloLista.hoteles.get(index).getPrecio()));
					ventana.cambio_panel(ventana.hotel, ventana.reserva);
				}
				
			}
		});

		ventana.hotel.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.hotel, ventana.raiz);
				try {
					modelo.modeloLista.vaciarLista();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.hotel.listaHoteles.setModel(modelo.modeloLista);

				
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


}
