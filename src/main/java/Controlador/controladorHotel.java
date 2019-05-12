
package Controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

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

		ventana.alojamiento.btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = ventana.alojamiento.listaAlojamientos.getSelectedIndex();

				// if para comprobar que algun hotel ha sido seleccionado
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Seleccione alg\u00fan alojamiento.");
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
					long Enero_1_I = ventana.raiz.Enero1.getTime() - fechaIn.getTime();
					long Enero_6_I = ventana.raiz.Enero6.getTime() - fechaIn.getTime();
					long Abril_19_I = ventana.raiz.Abril19.getTime() - fechaIn.getTime();
					long Abril_21_I = ventana.raiz.Abril21.getTime() - fechaIn.getTime();
					long Mayo_1_I = ventana.raiz.Mayo1.getTime() - fechaIn.getTime();
					long Octubre_12_I = ventana.raiz.Octubre12.getTime() - fechaIn.getTime();
					long Noviembre_1_I = ventana.raiz.Noviembre1.getTime() - fechaIn.getTime();
					long Diciembre_6_I = ventana.raiz.Diciembre6.getTime() - fechaIn.getTime();
					long Diciembre_8_I = ventana.raiz.Diciembre8.getTime() - fechaIn.getTime();
					long Diciembre_25_I = ventana.raiz.Diciembre25.getTime() - fechaIn.getTime();

					long Enero_1_O = ventana.raiz.Enero1.getTime() - fechaOut.getTime();
					long Enero_6_O = ventana.raiz.Enero6.getTime() - fechaOut.getTime();
					long Abril_19_O = ventana.raiz.Abril19.getTime() - fechaOut.getTime();
					long Abril_21_O = ventana.raiz.Abril21.getTime() - fechaOut.getTime();
					long Mayo_1_O = ventana.raiz.Mayo1.getTime() - fechaOut.getTime();
					long Octubre_12_O = ventana.raiz.Octubre12.getTime() - fechaOut.getTime();
					long Noviembre_1_O = ventana.raiz.Noviembre1.getTime() - fechaOut.getTime();
					long Diciembre_6_O = ventana.raiz.Diciembre6.getTime() - fechaOut.getTime();
					long Diciembre_8_O = ventana.raiz.Diciembre8.getTime() - fechaOut.getTime();
					long Diciembre_25_O = ventana.raiz.Diciembre25.getTime() - fechaOut.getTime();

					double precioBase = 32; // <- esto es para que no de error
					// esto lo que hay que
					// poner->modelo.modeloListaAlojamiento.alojamiento.get(index).getPrecio();--
					// no! habitaciones, precio de la hab selecc

					// multimplica el precioBase * numero de noche elegidas
					long dias = fechaOut.getTime() - fechaIn.getTime();
					long difdias = dias / (1000 * 60 * 60 * 24);
					double precio = precioBase * difdias;
					// incrementa el precio al elegir en temporada alta
					if (fechaIn.after(ventana.raiz.temporadaAltaInicio) && fechaIn.before(ventana.raiz.temporadaAltaFin)
							|| fechaOut.after(ventana.raiz.temporadaAltaInicio)
									&& fechaOut.before(ventana.raiz.temporadaAltaFin)) {
						precio = precio + (precio * 0.20);
					}
					// incrementa el precio al elegir festivo en el fechaIn
					if ((Enero_1_I <= 0 && Enero_1_I >= -24 * 60 * 60 * 1000)
							|| (Enero_6_I <= 0 && Enero_6_I >= -24 * 60 * 60 * 1000)
							|| (Abril_19_I <= 0 && Abril_19_I >= -24 * 60 * 60 * 1000)
							|| (Abril_21_I <= 0 && Abril_21_I >= -24 * 60 * 60 * 1000)
							|| (Mayo_1_I <= 0 && Mayo_1_I >= -24 * 60 * 60 * 1000)
							|| (Octubre_12_I <= 0 && Octubre_12_I >= -24 * 60 * 60 * 1000)
							|| (Noviembre_1_I <= 0 && Noviembre_1_I >= -24 * 60 * 60 * 1000)
							|| (Diciembre_6_I <= 0 && Diciembre_6_I >= -24 * 60 * 60 * 1000)
							|| (Diciembre_8_I <= 0 && Diciembre_8_I >= -24 * 60 * 60 * 1000)
							|| (Diciembre_25_I <= 0 && Diciembre_25_I >= -24 * 60 * 60 * 1000)) {
						precio = precio + (precio * 0.10);
					}
					// incrementa el precio al elegir festivo en el fechaOut
					if ((Enero_1_O <= 0 && Enero_1_O >= -24 * 60 * 60 * 1000)
							|| (Enero_6_O <= 0 && Enero_6_O >= -24 * 60 * 60 * 1000)
							|| (Abril_19_O <= 0 && Abril_19_O >= -24 * 60 * 60 * 1000)
							|| (Abril_21_O <= 0 && Abril_21_O >= -24 * 60 * 60 * 1000)
							|| (Mayo_1_O <= 0 && Mayo_1_O >= -24 * 60 * 60 * 1000)
							|| (Octubre_12_O <= 0 && Octubre_12_O >= -24 * 60 * 60 * 1000)
							|| (Noviembre_1_O <= 0 && Noviembre_1_O >= -24 * 60 * 60 * 1000)
							|| (Diciembre_6_O <= 0 && Diciembre_6_O >= -24 * 60 * 60 * 1000)
							|| (Diciembre_8_O <= 0 && Diciembre_8_O >= -24 * 60 * 60 * 1000)
							|| (Diciembre_25_O <= 0 && Diciembre_25_O >= -24 * 60 * 60 * 1000)) {
						precio = precio + (precio * 0.10);
					}

					ventana.reserva.textField_precio.setText(Double.toString(precio));
					// ventana.reserva.textField_precio.setText(Float.toString(modelo.modeloListaHotel.hoteles.get(index).getPrecio()));

					// pasa parametros a reserva
//						ventana.reserva.textField_alojamientoseleccionado
//								.setText(modelo.modeloListaAlojamiento.hoteles.get(index).getNombre());
//						ventana.reserva.textField_precio
//								.setText(Float.toString(modelo.modeloListaAlojamiento.hoteles.get(index).getPrecio()));

					precioBase = 30;// aqui tendra que ir lo que coja de
									// habitacionDouble.parseDouble(separarString(index)[1]);

					// multimplica el precioBase * numero de noche elegidas
					dias = fechaOut.getTime() - fechaIn.getTime();
					difdias = dias / (1000 * 60 * 60 * 24);
					precio = precioBase * difdias;
					// incrementa el precio al elegir en temporada alta
					if (fechaIn.after(ventana.raiz.temporadaAltaInicio) && fechaIn.before(ventana.raiz.temporadaAltaFin)
							|| fechaOut.after(ventana.raiz.temporadaAltaInicio)
									&& fechaOut.before(ventana.raiz.temporadaAltaFin)) {
						precio = precio + (precio * 0.20);
					}
					// incrementa el precio al elegir festivo en el fechaIn
					if (fechaIn.equals(ventana.raiz.Enero1) || fechaIn.equals(ventana.raiz.Enero6)
							|| fechaIn.equals(ventana.raiz.Abril19) || fechaIn.equals(ventana.raiz.Abril21)
							|| fechaIn.equals(ventana.raiz.Mayo1) || fechaIn.equals(ventana.raiz.Octubre12)
							|| fechaIn.equals(ventana.raiz.Noviembre1) || fechaIn.equals(ventana.raiz.Diciembre6)
							|| fechaIn.equals(ventana.raiz.Diciembre8) || fechaIn.equals(ventana.raiz.Diciembre25)) {
						precio = precio + (precio * 0.10);
					}
					// incrementa el precio al elegir festivo en el fechaOut
					if (fechaOut.equals(ventana.raiz.Enero1) || fechaOut.equals(ventana.raiz.Enero6)
							|| fechaOut.equals(ventana.raiz.Abril19) || fechaOut.equals(ventana.raiz.Abril21)
							|| fechaOut.equals(ventana.raiz.Mayo1) || fechaOut.equals(ventana.raiz.Octubre12)
							|| fechaOut.equals(ventana.raiz.Noviembre1) || fechaOut.equals(ventana.raiz.Diciembre6)
							|| fechaOut.equals(ventana.raiz.Diciembre8) || fechaOut.equals(ventana.raiz.Diciembre25)) {
						precio = precio + (precio * 0.10);
					}
					// pasa parametros a reserva
					ventana.reserva.textField_alojamientoseleccionado.setText(separarString(index)[0]);
					ventana.reserva.textField_precio.setText(Double.toString(precio));

					ventana.cambio_panel(ventana.alojamiento, ventana.reserva);

//					for (int cont = 0; cont < modelo.modeloListaHabitacion.dormitorios.size(); cont++) {
//						if (ventana.hotel.listaHabitaciones.isSelectedIndex(cont)) {
//							reserva_habitacion.add(new Reserva_habitacion(
//									modelo.modeloListaHabitacion.dormitorios.get(cont).getNum_habitacion(),
//									ventana.reserva.textField_fechaDeEntrada.getText(),
//									ventana.reserva.textField_fechaDeSalida.getText()));
//						}
//					}

//					}
				}
			}
		});

//		// boton que muestra la lista de habitaciones
//
		ventana.alojamiento.btnHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// vaciamos la lista cada vez que se le da al boton para que no conserve lo de
				// otros hoteles seleccionados
				vaciarTabla();

				// comprobar que hay un hotel seleccionado antes de que cargue la lista
				if (ventana.alojamiento.listaAlojamientos.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Seleccione alg\u00fan alojamiento.");
				} else {
					// if para comprobar si se ha seleccionado una casa o un hotel; dentro del if es
					// si se selecciona hotel
					if (ventana.alojamiento.listaAlojamientos.getSelectedIndex() > modelo.modeloListaAlojamiento.casas.size()
							- 1) {

						try {
							String columna[] = {"Descripci\u00f3n","C.Individual","C.Matrimonio","C.Infantil","Precio"};
							ventana.alojamiento.modeloTabla = new DefaultTableModel(columna, 0) {	@Override
							    public boolean isCellEditable(int row, int column) {
							       //all cells false
							       return false;
							    }};
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

							for (int i = 0; i < modelo.dormitorio.dormitorios.size(); i++) {
								Object[] dormi = { modelo.dormitorio.dormitorios.get(i).getDescripcion(),
										modelo.dormitorio.dormitorios.get(i).getCamaIndividual(),
										modelo.dormitorio.dormitorios.get(i).getCamaMatrimonio(),
										modelo.dormitorio.dormitorios.get(i).getCamaInfantil(),
										modelo.dormitorio.dormitorios.get(i).getPrecio() };
								ventana.alojamiento.modeloTabla.addRow(dormi);
							}
							ventana.alojamiento.habitaciones.setModel(ventana.alojamiento.modeloTabla);

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
							
							// llena la tabla usando el cod_hotel del hotel seleccionado en la
							// listaAlojamiento

							String columna[] = {"Tipo","Descripci\u00f3n","Superficie","Precio"};
							ventana.alojamiento.modeloTabla = new DefaultTableModel(columna, 0) {	@Override
							    public boolean isCellEditable(int row, int column) {
							       //all cells false
							       return false;
							    }};

							modelo.habitacion.obtenerHabitaciones(modelo.modeloListaAlojamiento.casas
									.get(ventana.alojamiento.listaAlojamientos.getSelectedIndex()).getCod_alojamiento(),
									ventana.reserva.textField_fechaDeEntrada.getText(),
									ventana.reserva.textField_fechaDeSalida.getText());

							// rellenamos la tabla con un Array de objeto
							// usando el arraylist<Dormitorio> q creamos arriba con el cod_alojamiento y la
							// fecha de entrada y salida

							for (int i = 0; i < modelo.habitacion.habitaciones.size(); i++) {
								Object[] habita = { modelo.habitacion.habitaciones.get(i).getTipo(),
										modelo.habitacion.habitaciones.get(i).getDescripcion(),
										modelo.habitacion.habitaciones.get(i).getMetrosCuadrados(),
										modelo.habitacion.habitaciones.get(i).getPrecio() };
								ventana.alojamiento.modeloTabla.addRow(habita);

							}
							ventana.alojamiento.habitaciones.setModel(ventana.alojamiento.modeloTabla);
							ventana.alojamiento.habitaciones.getColumnModel().getColumn(0).setPreferredWidth(100);
							ventana.alojamiento.habitaciones.getColumnModel().getColumn(1).setPreferredWidth(300);
							ventana.alojamiento.habitaciones.getColumnModel().getColumn(2).setPreferredWidth(50);
							ventana.alojamiento.habitaciones.getColumnModel().getColumn(3).setPreferredWidth(72);
							
							
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
//					modelo.modeloListaHabitacion.vaciarLista();
					modelo.modeloListaAlojamiento.vaciarLista();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.alojamiento.listaAlojamientos.setModel(modelo.modeloListaAlojamiento);
			}

		});

	}

	public void vaciarTabla() {
		for (int index = ventana.alojamiento.modeloTabla.getRowCount() - 1; index >= 0; index--) {
			ventana.alojamiento.modeloTabla.removeRow(index);
		}
		for (int index = modelo.dormitorio.dormitorios.size() - 1; index >= 0; index--) {
			modelo.dormitorio.dormitorios.remove(index);
		}
		for (int index=modelo.habitacion.habitaciones.size()-1;index>=0;index --) {
			modelo.habitacion.habitaciones.remove(index);
		}
	}
	


	public String[] separarString(int index) {
		String linea = (modelo.modeloListaAlojamiento.getElementAt(index)).toString();
		int contador = 0;
		int contador2 = 0;
		String campo = "";
		String[] nomPrecio = new String[2];

		while (contador < linea.length() - 1) {
			if (linea.charAt(contador) == ':' && linea.charAt(contador + 1) == ' ' && contador2 < 2) {
				contador++;

				while (linea.charAt(contador + 1) != ' ' && (contador + 1) < linea.length() - 1) {
					campo += linea.charAt(contador + 1);
					contador++;
//					System.out.println(contador);
				}
				nomPrecio[contador2] = campo;
				campo = "";
				contador2++;
//				System.out.println("paso1 " + campo);

			}

			contador++;
		}

		return nomPrecio;
	}

}
