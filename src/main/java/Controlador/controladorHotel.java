
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;

import java.util.ArrayList;


import javax.swing.JOptionPane;

import Modelo.Reserva_habitacion;
import Modelo.modelo;
import Vista.Ventana;

public class controladorHotel {
	private Ventana ventana;
	private modelo modelo;
	public static ArrayList<Reserva_habitacion> reserva_habitacion = new ArrayList<Reserva_habitacion>();

	public controladorHotel() {
	}

	public controladorHotel(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		// boton continuar

		ventana.hotel.btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = ventana.hotel.listaHoteles.getSelectedIndex();
				// if para comprobar que algun hotel ha sido seleccionado
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Seleccione algun hotel.");
				} else {
//					// una vez un hotel ha sido seleccionado, coge el num de habitaciones y
//					// comprueba que se hayan seleccionado
//
//					if (ventana.hotel.listaHabitaciones.getSelectedIndex() < controladorRaiz.num_Hab) {
//						JOptionPane.showMessageDialog(null, "Seleccione " + controladorRaiz.num_Hab + " habitacion.");
//					} else {
						System.out.println("Hola" + modelo.modeloListaAlojamiento.getElementAt(index));


						// añade en la vista de reserva los parametros del nombre del hotel y el precio

						ventana.reserva.textField_alojamientoseleccionado
								.setText(modelo.modeloListaHotel.hoteles.get(index).getNombre());
						Date fechaIn = ventana.raiz.fechaIn.getDate();
						Date fechaOut = ventana.raiz.fechaOut.getDate();
						
						double precioBase = modelo.modeloListaHotel.hoteles.get(index).getPrecio();
						
						//multimplica el precioBase * numero de noche elegidas
						long dias = fechaOut.getTime() - fechaIn.getTime();
						long difdias = dias / (1000*60*60*24);
						double precio = precioBase *difdias;
						//incrementa el precio al elegir en temporada alta
						if (fechaIn.after(ventana.raiz.temporadaAltaInicio) && fechaIn.before(ventana.raiz.temporadaAltaFin)
								|| fechaOut.after(ventana.raiz.temporadaAltaInicio)
										&& fechaOut.before(ventana.raiz.temporadaAltaFin)) {
							 precio = precio + (precio * 0.20);
						}
						//incrementa el precio al elegir festivo en el fechaIn
						if(fechaIn.equals(ventana.raiz.Enero1) || fechaIn.equals(ventana.raiz.Enero6) || fechaIn.equals(ventana.raiz.Abril19) || fechaIn.equals(ventana.raiz.Abril21)
								|| fechaIn.equals(ventana.raiz.Mayo1) || fechaIn.equals(ventana.raiz.Octubre12) || fechaIn.equals(ventana.raiz.Noviembre1) || fechaIn.equals(ventana.raiz.Diciembre6)
								|| fechaIn.equals(ventana.raiz.Diciembre8) || fechaIn.equals(ventana.raiz.Diciembre25)) {
							precio = precio + (precio * 0.10);
						}
						//incrementa el precio al elegir festivo en el fechaOut
						if(fechaOut.equals(ventana.raiz.Enero1) || fechaOut.equals(ventana.raiz.Enero6) || fechaOut.equals(ventana.raiz.Abril19) || fechaOut.equals(ventana.raiz.Abril21)
								|| fechaOut.equals(ventana.raiz.Mayo1) || fechaOut.equals(ventana.raiz.Octubre12) || fechaOut.equals(ventana.raiz.Noviembre1)
								|| fechaOut.equals(ventana.raiz.Diciembre6) || fechaOut.equals(ventana.raiz.Diciembre8) || fechaOut.equals(ventana.raiz.Diciembre25)) {
							precio = precio + (precio * 0.10);
						}
						
						ventana.reserva.textField_precio.setText(Double.toString(precio));
						//ventana.reserva.textField_precio.setText(Float.toString(modelo.modeloListaHotel.hoteles.get(index).getPrecio()));

						
						//pasa parametros a reserva
//						ventana.reserva.textField_alojamientoseleccionado
//								.setText(modelo.modeloListaAlojamiento.hoteles.get(index).getNombre());
//						ventana.reserva.textField_precio
//								.setText(Float.toString(modelo.modeloListaAlojamiento.hoteles.get(index).getPrecio()));


						
						ventana.cambio_panel(ventana.hotel, ventana.reserva);
						
						for (int cont = 0; cont < modelo.modeloListaHabitacion.dormitorios.size(); cont++)
						{
							if (ventana.hotel.listaHabitaciones.isSelectedIndex(cont))
							{
								reserva_habitacion.add(new Reserva_habitacion(modelo.modeloListaHabitacion.dormitorios.get(cont).getNum_habitacion(),
										ventana.reserva.textField_fechaDeEntrada.getText(), ventana.reserva.textField_fechaDeSalida.getText()));
							}
						}


//					}
				}
			}
		});

		// boton que muestra la lista de habitaciones

		ventana.hotel.btnHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// vaciamos la lista cada vez que se le da al boton para que no conserve lo de
				// otros hoteles seleccionados

				try {
					modelo.modeloListaHabitacion.vaciarLista();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// comprobar que hay un hotel seleccionado antes de que cargue la lista pero
				// despues de limpiarla
				if (ventana.hotel.listaHoteles.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Seleccione algun hotel.");
				} else {
					try {
						// llena la lista usando el cod_hotel del hotel seleccionado en la listaHoteles

						modelo.modeloListaHabitacion.llenarLista(
								modelo.modeloListaAlojamiento.hoteles.get(ventana.hotel.listaHoteles.getSelectedIndex())
										.getCod_alojamiento(),
								ventana.reserva.textField_fechaDeEntrada.getText(),
								ventana.reserva.textField_fechaDeSalida.getText());

						// indica que el ListModel de la listaHabitaciones es el de listahabitacion que
						// rellenamos arriba (por alguna razon
						// creo que si lo pones directamente el scrollPane no funciona bien)

						ventana.hotel.listaHabitaciones.setModel(modelo.modeloListaHabitacion);

					} catch (Exception e1) {
						System.out.println("El ArrayList de dormitorios no ha sido rellenado");
						e1.printStackTrace();
					}
				}

			}

		});

		// boton de cancelar, vacia las dos listas

		ventana.hotel.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.hotel, ventana.raiz);
				try {
					modelo.modeloListaHabitacion.vaciarLista();
					modelo.modeloListaAlojamiento.vaciarLista();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.hotel.listaHoteles.setModel(modelo.modeloListaAlojamiento);
			}
		});

	}

	public static String[] separarString(String alojamiento) {
		String linea = alojamiento;
		int contador = 0;
		String campo = "";
		String uno = "";
		String dos = "";
		while (contador < linea.length()) {
			if (linea.charAt(contador) != ';')
				campo += linea.charAt(contador);
			if ((linea.charAt(contador) == ';') || (contador == linea.length() - 1)) {

				System.out.println("paso2 " + campo);

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
