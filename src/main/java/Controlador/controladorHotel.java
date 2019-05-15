
package Controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Modelo.Dormitorio;
import Modelo.Habitacion;
import Modelo.Reserva_habitacion;
import Modelo.TemporadaAlta;
import Modelo.fechasTarifas;
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

		ventana.alojamiento.btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = ventana.alojamiento.listaAlojamientos.getSelectedIndex();

				// if para comprobar que algun hotel ha sido seleccionado
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Seleccione alg\u00fan alojamiento.");
				} else {

					// COMPROBAR QUE ES UN HOTEL:

					if (ventana.alojamiento.listaAlojamientos
							.getSelectedIndex() > modelo.modeloListaAlojamiento.casas.size() - 1) {

						// PARA HOTEL
						// una vez un hotel ha sido seleccionado, coge el num de habitaciones y
						// comprueba que se hayan seleccionado

						if (ventana.alojamiento.habitaciones.getSelectedRowCount() < controladorRaiz.num_Hab) {
							JOptionPane.showMessageDialog(null,
									"Seleccione " + controladorRaiz.num_Hab + " habitacion/es.");

						} else {

							// FOR QUE COGE EL NUMERO DE FILAS SELECCIONADO Y DE CADA UNA COGE EL PRECIO DE
							// DORMITORIO USANDO EL INDEX DE LA
							// FILA SELECCIONADA

							int[] selection = ventana.alojamiento.habitaciones.getSelectedRows();

							// IF PARA COMPROBAR QUE EL NUMERO DE PERSONAS COINCIDE CON LAS HABITACIONES
							// SELECCIONADAS

							for (int i = 0; i < selection.length; i++) {
								if (controladorRaiz.num_huespedes > (modelo.dormitorio.dormitorios.get(selection[i])
										.getCamaMatrimonio()+1
										+ modelo.dormitorio.dormitorios.get(selection[i]).getCamaIndividual())) {

									JOptionPane.showMessageDialog(null,
											"No somos un servicio de pateras");
								}else break;
							}

							double precioBase = 0;
							Date fechaIn = ventana.raiz.fechaIn.getDate();
							Date fechaOut = ventana.raiz.fechaOut.getDate();

							for (int i = 0; i < selection.length; i++) {
								precioBase += modelo.dormitorio.dormitorios.get(selection[i]).getPrecio();
								System.out.println(precioBase + " " + i);
							}
							System.out.println(precioBase);
							double precio = calculo_precio(precioBase, fechaIn, fechaOut);
							ventana.reserva.textField_precio.setText(Double.toString(precio));

							// MANDA NOMBRE DE HOTEL Y EL NUMERO DE HABITACIONES QUE SE HAN SELECCIONADO A
							// RESERVA
							ventana.reserva.textField_NumeroHabitaciones.setText(selection.length + "");
							ventana.reserva.textField_alojamientoseleccionado
									.setText(modelo.modeloListaAlojamiento.hoteles
											.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex()
													- modelo.modeloListaAlojamiento.casas.size())
											.getNombre());

							System.out.println(ventana.reserva.textField_precio.getText());

							ventana.cambio_panel(ventana.alojamiento, ventana.reserva);

							for (int cont = 0; cont < selection.length; cont++) {
								if (ventana.alojamiento.habitaciones.isRowSelected(cont)) {
									reserva_habitacion.add(new Reserva_habitacion(
											modelo.dormitorio.dormitorios.get(selection[cont]).getCod_habitacion(),
											ventana.reserva.textField_fechaDeEntrada.getText(),
											ventana.reserva.textField_fechaDeSalida.getText()));
								}
							}
						}

					} else {

						// añade en la vista de reserva los parametros del nombre del hotel y el precio

						Date fechaIn = ventana.raiz.fechaIn.getDate();
						Date fechaOut = ventana.raiz.fechaOut.getDate();

						// AQUI VA PRECIO CASA

						double precioBase = modelo.modeloListaAlojamiento.casas
								.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex()).getPrecio();
						System.out.println(precioBase);
						double precio = calculo_precio(precioBase, fechaIn, fechaOut);
						System.out.println(precioBase + " " + fechaIn + " " + fechaOut);
						// pasa parametros a reserva
						ventana.reserva.textField_precio.setText(Double.toString(precio));
						System.out.println(ventana.reserva.textField_precio.getText());

						// manda el nombre de la casa/apt a reserva
						ventana.reserva.textField_alojamientoseleccionado.setText(modelo.modeloListaAlojamiento.casas
								.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex()).getNombre());
						ventana.cambio_panel(ventana.alojamiento, ventana.reserva);

						for (int cont = 0; cont < modelo.habitacion.habitaciones.size(); cont++) {

							reserva_habitacion.add(
									new Reserva_habitacion(modelo.habitacion.habitaciones.get(cont).getCod_habitacion(),
											ventana.reserva.textField_fechaDeEntrada.getText(),
											ventana.reserva.textField_fechaDeSalida.getText()));

						}
					}
				}
			}
		});

		// boton que muestra la lista de habitaciones

		ventana.alojamiento.btnHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// vaciamos la lista cada vez que se le da al boton para que no conserve lo de
				// otros hoteles seleccionados
				modelo.habitacion.vaciarTabla(ventana.alojamiento.modeloTabla);

				// comprobar que hay un hotel seleccionado antes de que cargue la lista
				if (ventana.alojamiento.listaAlojamientos.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Seleccione alg\u00fan alojamiento.");
				} else {

					// if para comprobar si se ha seleccionado una casa o un hotel; dentro del if es
					// si se selecciona hotel
					if (ventana.alojamiento.listaAlojamientos
							.getSelectedIndex() > modelo.modeloListaAlojamiento.casas.size() - 1) {

						try {
							String columna[] = { "Descripci\u00f3n", "C.Individual", "C.Matrimonio", "C.Infantil",
									"Precio" };
							ventana.alojamiento.modeloTabla = new DefaultTableModel(columna, 0) {
								@Override
								public boolean isCellEditable(int row, int column) {
									// all cells false
									return false;
								}
							};
							// llena la tabla usando el cod_hotel del hotel seleccionado en la listaHoteles

							modelo.dormitorio
									.obtenerDormitorios(
											modelo.modeloListaAlojamiento.hoteles
													.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex()
															- modelo.modeloListaAlojamiento.casas.size())
													.getCod_alojamiento(),
											ventana.reserva.textField_fechaDeEntrada.getText(),
											ventana.reserva.textField_fechaDeSalida.getText());

							// rellenamos la tabla con un Array de objeto
							// usando el arraylist<Dormitorio> q creamos arriba con el cod_alojamiento y la
							// fecha de entrada y salida

							if (modelo.dormitorio.dormitorios.size() == 0) {
								JOptionPane.showMessageDialog(null,
										"No quedan habitaciones disponibles para las fechas seleccionadas");
							} else
								for (int i = 0; i < modelo.dormitorio.dormitorios.size(); i++) {
									Object[] dormi = { modelo.dormitorio.dormitorios.get(i).getDescripcion(),
											modelo.dormitorio.dormitorios.get(i).getCamaIndividual(),
											modelo.dormitorio.dormitorios.get(i).getCamaMatrimonio(),
											modelo.dormitorio.dormitorios.get(i).getCamaInfantil(),
											modelo.dormitorio.dormitorios.get(i).getPrecio() + "\u20ac" };
									ventana.alojamiento.modeloTabla.addRow(dormi);
								}
							ventana.alojamiento.habitaciones.setModel(ventana.alojamiento.modeloTabla);
							
							controladorReserva.alojamiento = modelo.modeloListaAlojamiento.hoteles
									.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex()
											- modelo.modeloListaAlojamiento.casas.size())
									.getCod_alojamiento();
							
							controladorPago.codalojamiento = modelo.modeloListaAlojamiento.hoteles
									.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex()
											- modelo.modeloListaAlojamiento.casas.size())
									.getCod_alojamiento();

						} catch (Exception e1) {
							System.out.println("El ArrayList de dormitorios no ha sido rellenado");
							e1.printStackTrace();
						}

					}

					// si se trata de una casa/aptmn...
					// aqui hay que meter el metodo para que rellene la lista de dormitorios con las
					// habitaciones que tiene la casa
					else {

						try {

							// llena la tabla usando el cod_casa de la casa seleccionada en la
							// listaAlojamiento

							modelo.habitacion.obtenerHabitaciones(modelo.modeloListaAlojamiento.casas
									.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex()).getCod_alojamiento(),
									ventana.reserva.textField_fechaDeEntrada.getText(),
									ventana.reserva.textField_fechaDeSalida.getText());

							if (modelo.habitacion.habitaciones.size() == 0) {
								JOptionPane.showMessageDialog(null,
										"El alojamiento no esta disponible para las fechas seleccionadas");
							} else

								for (Habitacion h : modelo.habitacion.habitaciones) {
									if (modelo.modeloListaAlojamiento.casas
											.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex())
											.getPiso() != 0) {

										String columna[] = { "Tipo", "Superficie", "Piso" };
										// String columna[] = { "Tipo", "Descripci\u00f3n", "Superficie", "Piso" };
										ventana.alojamiento.modeloTabla = new DefaultTableModel(columna, 0) {
											@Override
											public boolean isCellEditable(int row, int column) {
												// all cells false
												return false;
											}
										};
										for (int j = 0; j < modelo.habitacion.habitaciones.size(); j++) {
											Object[] habita = { modelo.habitacion.habitaciones.get(j).getTipo(),
//											modelo.habitacion.habitaciones.get(j).getDescripcion(),
													(modelo.habitacion.habitaciones.get(j).getMetrosCuadrados() + "m2"),
													modelo.modeloListaAlojamiento.casas.get(
															ventana.alojamiento.listaAlojamientos.getSelectedIndex())
															.getPiso() };
											ventana.alojamiento.modeloTabla.addRow(habita);

											ventana.alojamiento.habitaciones.setModel(ventana.alojamiento.modeloTabla);
											ventana.alojamiento.habitaciones.getColumnModel().getColumn(0)
													.setPreferredWidth(100);
											ventana.alojamiento.habitaciones.getColumnModel().getColumn(1)
													.setPreferredWidth(70);
											ventana.alojamiento.habitaciones.getColumnModel().getColumn(2)
													.setPreferredWidth(70);
//									ventana.alojamiento.habitaciones.getColumnModel().getColumn(3).setPreferredWidth(100);

										}
									} else {
										String columna[] = { "Tipo", "Superficie" };
//								String columna[] = { "Tipo", "Descripci\u00f3n", "Superficie"};
										ventana.alojamiento.modeloTabla = new DefaultTableModel(columna, 0) {
											@Override
											public boolean isCellEditable(int row, int column) {
												// all cells false
												return false;
											}
										};
										for (int j = 0; j < modelo.habitacion.habitaciones.size(); j++) {
											Object[] habita = { modelo.habitacion.habitaciones.get(j).getTipo(),
//										modelo.habitacion.habitaciones.get(j).getDescripcion(),
													modelo.habitacion.habitaciones.get(j).getMetrosCuadrados() + "m2" };
											ventana.alojamiento.modeloTabla.addRow(habita);

										}

										ventana.alojamiento.habitaciones.setModel(ventana.alojamiento.modeloTabla);
										ventana.alojamiento.habitaciones.getColumnModel().getColumn(0)
												.setPreferredWidth(100);
//							ventana.alojamiento.habitaciones.getColumnModel().getColumn(1).setPreferredWidth(280);
										ventana.alojamiento.habitaciones.getColumnModel().getColumn(1)
												.setPreferredWidth(70);
									}
								}
							
							controladorReserva.alojamiento = modelo.modeloListaAlojamiento.casas
									.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex()).getCod_alojamiento();

							controladorPago.codalojamiento = modelo.modeloListaAlojamiento.casas
									.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex()).getCod_alojamiento();

						} catch (Exception e1) {
							System.out.println("El ArrayList de habitaciones no ha sido rellenado");
							e1.printStackTrace();
						}

					}
				}
			}

		});

		// boton de cancelar, vacia las dos listas

		ventana.alojamiento.btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.alojamiento, ventana.raiz);
				try {
					modelo.modeloListaAlojamiento.vaciarLista();
					modelo.habitacion.vaciarTabla(ventana.alojamiento.modeloTabla);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.alojamiento.listaAlojamientos.setModel(modelo.modeloListaAlojamiento);
			}

		});

		ventana.alojamiento.btn_habitacion_duda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selection = ventana.alojamiento.habitaciones.getSelectedRows();
				
				
				if (selection.length != 0)
				{
					String descripcion = modelo.habitacion.habitaciones.get(selection[0]).getDescripcion();
					String descripcion_convertida = "";

					
					for(int cont = 0; cont < descripcion.length(); cont++)
					{
						descripcion_convertida+= descripcion.charAt(cont);
								
						if (descripcion_convertida.length() == (descripcion.length()/2)-2)
						{
							descripcion_convertida += "\n\t";
						}
						

					}
					
					
					ventana.alojamiento.texto_panel.setText("\n\t   -  "+descripcion_convertida+"\t\t\n\n");
					ventana.alojamiento.panel.add(ventana.alojamiento.texto_panel);
					
					
					JOptionPane.showMessageDialog(ventana, ventana.alojamiento.panel, "Informaci\u00f3n "+modelo.habitacion.habitaciones.get(selection[0]).getTipo()
							, JOptionPane.INFORMATION_MESSAGE);
				}
				
				else
				{
					JOptionPane.showMessageDialog(ventana, "Seleccione una habitaci\u00f3n si necesita informaci\u00f3n.");
				}
				
			}
		});

	}
	
	
	
	
	
	

	public double calculo_precio(double precioBase, Date fechaIn, Date fechaOut) {

		double precioFinal = precioBase;
		int numeroDiasSeleccionados = 0;

		try {

			LocalDate inicio = fechaIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate fin = fechaOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			// Obtener lista de todos los dias que se han seleccionado
			ArrayList<LocalDate> diasSeleccionados = obtenerDiasEntreFechas(inicio, fin);
			// Obtener lista de la base de datos con todos los días festivos que hay
			ArrayList<LocalDate> diasFestivos = fechasTarifas.obtenerDiasFestivos();
			// Obtener lista de la base de datos con todas las temporadas altas que hay
			ArrayList<TemporadaAlta> temporadasAltas = fechasTarifas.obtenerTemporadasAltas();

			numeroDiasSeleccionados = diasSeleccionados.size();

			boolean diaFestivoSeleccionado = false;
			boolean diaTempAltaSeleccionado = false;

			// Bucle para comprobar si entre los dias seleccionados hay algún festivo
			// recorrer la lista de festivos
			for (int i = 0; i < diasFestivos.size(); i++) {
				LocalDate diaFestivo = diasFestivos.get(i);
				for (int j = 0; j < diasSeleccionados.size(); j++) {
					LocalDate diaSeleccionado = diasSeleccionados.get(j);
					if (diaFestivo.compareTo(diaSeleccionado) == 0) {
						diaFestivoSeleccionado = true;
					}
				}

			}
			// Si el boolean esta a true (que entre los dias seleccionados hay un festivo)

			if (diaFestivoSeleccionado == true) {
				precioFinal = precioFinal + precioBase * 0.1;

			}

			for (int i = 0; i < temporadasAltas.size(); i++) {
				TemporadaAlta tempAlta = temporadasAltas.get(i);
				ArrayList<LocalDate> diasTemporadaAlta = obtenerDiasEntreFechas(tempAlta.getInicio(),
						tempAlta.getFin());
				for (int j = 0; j < diasTemporadaAlta.size(); j++) {
					LocalDate diaTemporadaAlta = diasTemporadaAlta.get(j);
					for (int k = 0; k < diasSeleccionados.size(); k++) {
						LocalDate diaSeleccionado = diasSeleccionados.get(k);
						if (diaTemporadaAlta.compareTo(diaSeleccionado) == 0) {
							diaTempAltaSeleccionado = true;
						}
					}

				}

			}

			// Si el boolean esta a true (Que alguno de los dias seleccionados sea de
			// temporada alta)
			if (diaTempAltaSeleccionado == true) {
				precioFinal = precioFinal + precioBase * 0.2;

			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		return precioFinal * numeroDiasSeleccionados;
	}

	public ArrayList<LocalDate> obtenerDiasEntreFechas(LocalDate inicio, LocalDate fin) {
		LocalDate incrementingDate = inicio;

		ArrayList<LocalDate> diasTemporadaAlta = new ArrayList<LocalDate>();

		while (!incrementingDate.isAfter(fin)) {
			diasTemporadaAlta.add(incrementingDate);
			incrementingDate = incrementingDate.plusDays(1);
		}

		return diasTemporadaAlta;
	}
}
