package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Modelo.modelo;
import Vista.Ventana;

import metodos.GestorBD;

public class controladorRaiz {
	private Ventana ventana;
	private modelo modelo;
//	String ubicacionSeleccionada;

	public static int num_huespedes = 1;

	public controladorRaiz(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		// llenar el comboBox de ubicaciones
		try {
			llenarUbicaciones(GestorBD.obtenerUbicaciones());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// Calendario entrada
		ventana.raiz.fechaIn.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// Comprobar que se hayan seleccionado dos fechas, que el día de salida sea
				// posterior al de entrada y que el dia de salida y entrada no sean el mismo
				if (ventana.raiz.fechaIn.getDate() != null && ventana.raiz.fechaOut.getDate() != null
						&& (ventana.raiz.fechaIn.getDate().before(ventana.raiz.fechaOut.getDate()))
						&& !(ventana.raiz.fechaIn.getDate().equals(ventana.raiz.fechaOut.getDate()))) {
					ventana.raiz.btnBuscar.setEnabled(true);
				} else {
					ventana.raiz.btnBuscar.setEnabled(false);
				}

			}

		});

		// Calendario salida
		ventana.raiz.fechaOut.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// Comprobar que se hayan seleccionado dos fechas, que el día de salida sea
				// posterior al de entrada y que el dia de salida y entrada no sean el mismo
				if (ventana.raiz.fechaIn.getDate() != null && ventana.raiz.fechaOut.getDate() != null
						&& (ventana.raiz.fechaIn.getDate().before(ventana.raiz.fechaOut.getDate()))
						&& !(ventana.raiz.fechaIn.getDate().getDay() == ventana.raiz.fechaOut.getDate().getDay())) {
					ventana.raiz.btnBuscar.setEnabled(true);
				} else {
					ventana.raiz.btnBuscar.setEnabled(false);
				}

			}
		});

		// boton sumar huesped
		ventana.raiz.btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				num_huespedes++;
				// por si hay que borrar el jtextfield
				// vistaRaiz.txthuesped.setText("");
				ventana.raiz.txthuesped.setText(Integer.toString(num_huespedes));
			}
		});

		// boton restar huesped
		ventana.raiz.btnRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num_huespedes > 1) {
					num_huespedes--;
					ventana.raiz.txthuesped.setText(Integer.toString(num_huespedes));
				}
			}
		});

		// boton pasar siguiente ventana
		ventana.raiz.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.raiz.ubicacionSeleccionada = ventana.raiz.comboBoxUbicacion.getSelectedItem().toString();

				Date fechaIn = ventana.raiz.fechaIn.getDate();
				Date fechaOut = ventana.raiz.fechaOut.getDate();

				
				try {
					modelo.modeloLista.llenarLista(ventana.raiz.ubicacionSeleccionada);
					ventana.hotel.listaHoteles.setModel(modelo.modeloLista);

				} catch (Exception e1) {
					System.out.println("el ArrayList de parada no ha sido rellenado");
					e1.printStackTrace();
				}

				ventana.cambio_panel(ventana.raiz, ventana.hotel);
				ventana.reserva.textField_numpersonas.setText(ventana.raiz.txthuesped.getText());
				ventana.reserva.textField_ubicacion
						.setText(ventana.raiz.comboBoxUbicacion.getSelectedItem().toString());
				String patronFecha = "yyyy/MM/dd";
				DateFormat formatoFecha = new SimpleDateFormat(patronFecha);
				String fechaEntrada = formatoFecha.format(ventana.raiz.fechaIn.getDate());
				String fechaSalida = formatoFecha.format(ventana.raiz.fechaOut.getDate());
				ventana.reserva.textField_fechaDeEntrada.setText(fechaEntrada);
				ventana.reserva.textField_fechaDeSalida.setText(fechaSalida);
			}
		});

	}

	public void llenarUbicaciones(ArrayList<String> ubicaciones) {
		for (int i = 0; i < ubicaciones.size(); i++) {
			ventana.raiz.comboBoxUbicacion.addItem(ubicaciones.get(i));
		}
	}

}
