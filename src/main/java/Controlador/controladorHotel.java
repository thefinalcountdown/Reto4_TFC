
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

//						ventana.reserva.textField_alojamientoseleccionado
//								.setText(modelo.modeloListaHotel.hoteles.get(index).getNombre());
						
						Date fechaIn = ventana.raiz.fechaIn.getDate();
						Date fechaOut = ventana.raiz.fechaOut.getDate();
						long Enero_1_I = ventana.raiz.Enero1.getTime()-fechaIn.getTime();
						long Enero_6_I = ventana.raiz.Enero6.getTime()-fechaIn.getTime();
						long Abril_19_I = ventana.raiz.Abril19.getTime()-fechaIn.getTime();
						long Abril_21_I = ventana.raiz.Abril21.getTime()-fechaIn.getTime();
						long Mayo_1_I = ventana.raiz.Mayo1.getTime()-fechaIn.getTime();
						long Octubre_12_I = ventana.raiz.Octubre12.getTime()-fechaIn.getTime();
						long Noviembre_1_I = ventana.raiz.Noviembre1.getTime()-fechaIn.getTime();
						long Diciembre_6_I = ventana.raiz.Diciembre6.getTime()-fechaIn.getTime();
						long Diciembre_8_I = ventana.raiz.Diciembre8.getTime()-fechaIn.getTime();
						long Diciembre_25_I = ventana.raiz.Diciembre25.getTime()-fechaIn.getTime();
						
						long Enero_1_O = ventana.raiz.Enero1.getTime()-fechaOut.getTime();
						long Enero_6_O = ventana.raiz.Enero6.getTime()-fechaOut.getTime();
						long Abril_19_O = ventana.raiz.Abril19.getTime()-fechaOut.getTime();
						long Abril_21_O = ventana.raiz.Abril21.getTime()-fechaOut.getTime();
						long Mayo_1_O = ventana.raiz.Mayo1.getTime()-fechaOut.getTime();
						long Octubre_12_O = ventana.raiz.Octubre12.getTime()-fechaOut.getTime();
						long Noviembre_1_O = ventana.raiz.Noviembre1.getTime()-fechaOut.getTime();
						long Diciembre_6_O = ventana.raiz.Diciembre6.getTime()-fechaOut.getTime();
						long Diciembre_8_O = ventana.raiz.Diciembre8.getTime()-fechaOut.getTime();
						long Diciembre_25_O = ventana.raiz.Diciembre25.getTime()-fechaOut.getTime();
						
						
						double precioBase = modelo.modeloListaAlojamiento.hoteles.get(index).getPrecio();
						
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
						if((Enero_1_I<=0 && Enero_1_I>=-24*60*60*1000) || (Enero_6_I<=0 && Enero_6_I>=-24*60*60*1000) || (Abril_19_I<=0 && Abril_19_I>=-24*60*60*1000) || (Abril_21_I<=0 && Abril_21_I>=-24*60*60*1000) 
								|| (Mayo_1_I<=0 && Mayo_1_I>=-24*60*60*1000) || (Octubre_12_I<=0 && Octubre_12_I>=-24*60*60*1000) || (Noviembre_1_I<=0 && Noviembre_1_I>=-24*60*60*1000) || (Diciembre_6_I<=0 && Diciembre_6_I>=-24*60*60*1000)
								|| (Diciembre_8_I<=0 && Diciembre_8_I>=-24*60*60*1000) || (Diciembre_25_I<=0 && Diciembre_25_I>=-24*60*60*1000)) {
							precio = precio + (precio * 0.10);
						}
						//incrementa el precio al elegir festivo en el fechaOut
						if((Enero_1_O<=0 && Enero_1_O>=-24*60*60*1000) || (Enero_6_O<=0 && Enero_6_O>=-24*60*60*1000) || (Abril_19_O<=0 && Abril_19_O>=-24*60*60*1000) || (Abril_21_O<=0 && Abril_21_O>=-24*60*60*1000) 
								|| (Mayo_1_O<=0 && Mayo_1_O>=-24*60*60*1000) || (Octubre_12_O<=0 && Octubre_12_O>=-24*60*60*1000) || (Noviembre_1_O<=0 && Noviembre_1_O>=-24*60*60*1000) || (Diciembre_6_O<=0 && Diciembre_6_O>=-24*60*60*1000)
								|| (Diciembre_8_O<=0 && Diciembre_8_O>=-24*60*60*1000) || (Diciembre_25_O<=0 && Diciembre_25_O>=-24*60*60*1000)) {
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
