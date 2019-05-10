package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import javax.swing.JOptionPane;

import Modelo.modelo;
import Vista.Ventana;

import metodos.GestorBD;

public class controladorRaiz {
	private Ventana ventana;
	private modelo modelo;

	public static int num_huespedes = 1;
	public static int num_kids = 0;
	public static int num_Hab = 1;
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	

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
						
						try
						{
							Calendar calendario = ventana.raiz.fechaIn.getCalendar();
							calendario.add(Calendar.DATE, 1);
							ventana.raiz.fechaOut.setMinSelectableDate(calendario.getTime());
							
							if (ventana.raiz.fechaOut.getDate() == null || ventana.raiz.fechaOut.getDate().before(ventana.raiz.fechaIn.getDate()))
							{
								ventana.raiz.fechaOut.setDate(calendario.getTime());
							}
							
						}
						catch(NullPointerException e)
						{
							
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
		
		
		
		// boton sumar Adulto
		ventana.raiz.btnSumAdult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num_huespedes++;
				ventana.raiz.txthuesped.setText(Integer.toString(num_huespedes));
				if (num_huespedes == 12) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if (num_huespedes == 11) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 10 || num_huespedes == 9 || num_huespedes == 1) && num_kids == 2) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 8 || num_huespedes == 7 || num_huespedes == 3 || num_huespedes == 2)
						&& num_kids == 4) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 6 || num_huespedes == 5 || num_huespedes == 4) && num_kids == 6) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else {
					ventana.raiz.btnSumAdult.setEnabled(true);
					ventana.raiz.btnSumKids.setEnabled(true);
					ventana.raiz.btnRestAdult.setEnabled(true);
					ventana.raiz.btnRestKids.setEnabled(true);
				}

				if (num_huespedes == 0) {
					ventana.raiz.btnRestAdult.setEnabled(false);
					ventana.raiz.btnSumKids.setEnabled(false);
				}
				if (num_kids == 0) {
					ventana.raiz.btnRestKids.setEnabled(false);
				}
				if ((num_kids > 2) && (num_huespedes == 2)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}

				if ((num_kids > 4) && (num_huespedes == 4)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if (num_huespedes == 8 && num_kids > 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 10 && num_kids > 0) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 1) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if (num_huespedes <= 4) {
					ventana.raiz.txtHab.setText(Integer.toString(1));
				}
				if (num_huespedes >= 5) {
					ventana.raiz.txtHab.setText(Integer.toString(2));

				}
				if (num_huespedes > 8) {
					ventana.raiz.txtHab.setText(Integer.toString(3));
					ventana.raiz.btnSumHab.setEnabled(false);
				}
				if (num_huespedes < 8) {
					ventana.raiz.btnSumHab.setEnabled(true);
				}

				if ((num_huespedes == 10) && num_kids == 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if (num_huespedes == 8 && num_kids == 4) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if ((num_huespedes == 6) && num_kids == 6) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}

			}

		});

		// boton restar Adulto
		ventana.raiz.btnRestAdult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				num_huespedes--;
				ventana.raiz.txthuesped.setText(Integer.toString(num_huespedes));
				if (num_huespedes == 12) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if (num_huespedes == 11) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 10 || num_huespedes == 9 || num_huespedes == 1) && num_kids == 2) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 8 || num_huespedes == 7 || num_huespedes == 3 || num_huespedes == 2)
						&& num_kids == 4) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 6 || num_huespedes == 5 || num_huespedes == 4) && num_kids == 6) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else {
					ventana.raiz.btnSumAdult.setEnabled(true);
					ventana.raiz.btnSumKids.setEnabled(true);
					ventana.raiz.btnRestAdult.setEnabled(true);
					ventana.raiz.btnRestKids.setEnabled(true);
				}

				if (num_huespedes == 0) {
					ventana.raiz.btnRestAdult.setEnabled(false);
					ventana.raiz.btnSumKids.setEnabled(false);
				}
				if (num_kids == 0) {
					ventana.raiz.btnRestKids.setEnabled(false);
				}
				if ((num_kids > 2) && (num_huespedes == 2)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if ((num_kids > 4) && (num_huespedes == 4)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if (num_huespedes == 8 && num_kids > 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 10 && num_kids > 0) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 1) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if (num_huespedes >= 5) {
					ventana.raiz.txtHab.setText(Integer.toString(2));
				}
				if (num_huespedes > 8) {
					ventana.raiz.txtHab.setText(Integer.toString(3));
					ventana.raiz.btnSumHab.setEnabled(false);
				}
				if (num_huespedes < 8) {
					ventana.raiz.btnSumHab.setEnabled(true);
				}

				if ((num_huespedes == 10) && num_kids == 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if (num_huespedes == 8 && num_kids == 4) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if ((num_huespedes == 6) && num_kids == 6) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}

			}
		});

		// boton sumar Niño
		ventana.raiz.btnSumKids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num_kids++;
				ventana.raiz.txtKids.setText(Integer.toString(num_kids));
				if (num_huespedes == 12) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if (num_huespedes == 11) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 10 || num_huespedes == 9 || num_huespedes == 1) && num_kids == 2) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 8 || num_huespedes == 7 || num_huespedes == 3 || num_huespedes == 2)
						&& num_kids == 4) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 6 || num_huespedes == 5 || num_huespedes == 4) && num_kids == 6) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else {
					ventana.raiz.btnSumAdult.setEnabled(true);
					ventana.raiz.btnSumKids.setEnabled(true);
					ventana.raiz.btnRestAdult.setEnabled(true);
					ventana.raiz.btnRestKids.setEnabled(true);
				}

				if (num_huespedes == 0) {
					ventana.raiz.btnRestAdult.setEnabled(false);
					ventana.raiz.btnSumKids.setEnabled(false);
				}
				if (num_kids == 0) {
					ventana.raiz.btnRestKids.setEnabled(false);
				}
				if ((num_kids > 2) && (num_huespedes == 2)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if ((num_kids > 4) && (num_huespedes == 4)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if (num_huespedes == 8 && num_kids > 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 10 && num_kids > 0) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 1) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}

				if ((num_huespedes == 10) && num_kids == 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if (num_huespedes == 8 && num_kids == 4) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if ((num_huespedes == 6) && num_kids == 6) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}

			}
		});

		// boton restar Niño
		ventana.raiz.btnRestKids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num_kids--;
				ventana.raiz.txtKids.setText(Integer.toString(num_kids));
				if (num_huespedes == 12) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if (num_huespedes == 11) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 10 || num_huespedes == 9 || num_huespedes == 1) && num_kids == 2) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 8 || num_huespedes == 7 || num_huespedes == 3 || num_huespedes == 2)
						&& num_kids == 4) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else if ((num_huespedes == 6 || num_huespedes == 5 || num_huespedes == 4) && num_kids == 6) {
					ventana.raiz.btnSumKids.setEnabled(false);
				} else {
					ventana.raiz.btnSumAdult.setEnabled(true);
					ventana.raiz.btnSumKids.setEnabled(true);
					ventana.raiz.btnRestAdult.setEnabled(true);
					ventana.raiz.btnRestKids.setEnabled(true);
				}

				if (num_huespedes == 0) {
					ventana.raiz.btnRestAdult.setEnabled(false);
					ventana.raiz.btnSumKids.setEnabled(false);
				}
				if (num_kids == 0) {
					ventana.raiz.btnRestKids.setEnabled(false);
				}
				if ((num_kids > 2) && (num_huespedes == 2)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if ((num_kids > 4) && (num_huespedes == 4)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if (num_huespedes == 8 && num_kids > 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 10 && num_kids > 0) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 1) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}

				if ((num_huespedes == 10) && num_kids == 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if (num_huespedes == 8 && num_kids == 4) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} else if ((num_huespedes == 6) && num_kids == 6) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}

			}
		});

		// boton sumar Habitacion
		ventana.raiz.btnSumHab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num_Hab++;
				ventana.raiz.txtHab.setText(Integer.toString(num_Hab));
				if (num_Hab < 3) {
					ventana.raiz.btnSumHab.setEnabled(true);
				} else {
					ventana.raiz.btnSumHab.setEnabled(false);
				}
				if (!ventana.raiz.btnRestHab.isEnabled()) {
					ventana.raiz.btnRestHab.setEnabled(true);
				}
				if (num_Hab == 1) {
					ventana.raiz.btnRestHab.setEnabled(false);
				}
			}
		});

		// boton restar Habitacion
		ventana.raiz.btnRestHab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num_Hab > 1 || num_Hab < 3) {
					num_Hab--;
					ventana.raiz.txtHab.setText(Integer.toString(num_Hab));
					ventana.raiz.btnSumHab.setEnabled(true);
				}
				if (num_Hab == 1) {
					ventana.raiz.btnRestHab.setEnabled(false);
				}
			}
		});

		// boton pasar siguiente ventana
		ventana.raiz.btnBuscar.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				

				String ubicacionSeleccionada = ventana.raiz.comboBoxUbicacion.getSelectedItem().toString();
				
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
				
				
				if (fechaIn.after(ventana.raiz.temporadaAltaInicio) && fechaIn.before(ventana.raiz.temporadaAltaFin)
						|| fechaOut.after(ventana.raiz.temporadaAltaInicio) && fechaOut.before(ventana.raiz.temporadaAltaFin)) {
					JOptionPane.showMessageDialog(null,
							"Las fechas seleccionadas suponen un incremento del 20% en el precio al ser temporada alta");
				}
				if((Enero_1_I<=0 && Enero_1_I>=-24*60*60*1000) || (Enero_6_I<=0 && Enero_6_I>=-24*60*60*1000) || (Abril_19_I<=0 && Abril_19_I>=-24*60*60*1000) || (Abril_21_I<=0 && Abril_21_I>=-24*60*60*1000) 
						|| (Mayo_1_I<=0 && Mayo_1_I>=-24*60*60*1000) || (Octubre_12_I<=0 && Octubre_12_I>=-24*60*60*1000) || (Noviembre_1_I<=0 && Noviembre_1_I>=-24*60*60*1000) || (Diciembre_6_I<=0 && Diciembre_6_I>=-24*60*60*1000)
						|| (Diciembre_8_I<=0 && Diciembre_8_I>=-24*60*60*1000) || (Diciembre_25_I<=0 && Diciembre_25_I>=-24*60*60*1000)) {
					JOptionPane.showMessageDialog(null,"la fecha elegida es un dia festivo y supone un incremento en el precio del 10%");
				}
				
				if((Enero_1_O<=0 && Enero_1_O>=-24*60*60*1000) || (Enero_6_O<=0 && Enero_6_O>=-24*60*60*1000) || (Abril_19_O<=0 && Abril_19_O>=-24*60*60*1000) || (Abril_21_O<=0 && Abril_21_O>=-24*60*60*1000) 
						|| (Mayo_1_O<=0 && Mayo_1_O>=-24*60*60*1000) || (Octubre_12_O<=0 && Octubre_12_O>=-24*60*60*1000) || (Noviembre_1_O<=0 && Noviembre_1_O>=-24*60*60*1000) || (Diciembre_6_O<=0 && Diciembre_6_O>=-24*60*60*1000)
						|| (Diciembre_8_O<=0 && Diciembre_8_O>=-24*60*60*1000) || (Diciembre_25_O<=0 && Diciembre_25_O>=-24*60*60*1000)) {
					JOptionPane.showMessageDialog(null,"la fecha elegida es un dia festivo y supone un incremento en el precio del 10%");
				}
				
			
				
				JOptionPane.showMessageDialog(null,"Aloha chicos \r\n Estamos en periodo de construccion :( \r\n para que no os de error seleccionad SOLAMENTE la primera opcion de alojamiento\r\n y no seleccioneis niguna habitacion\r\n sentimos las molestias, gracias! :)");
				try {
					modelo.modeloListaAlojamiento.llenarLista(ubicacionSeleccionada);
					ventana.hotel.listaHoteles.setModel(modelo.modeloListaAlojamiento);

				} catch (Exception e1) {
					System.out.println("el ArrayList de hotel no ha sido rellenado");
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
				ventana.reserva.textField_NumeroHabitaciones.setText(ventana.raiz.txtHab.getText());

			}
		});

	}

	public void llenarUbicaciones(ArrayList<String> ubicaciones) {
		for (int i = 0; i < ubicaciones.size(); i++) {
			ventana.raiz.comboBoxUbicacion.addItem(ubicaciones.get(i));
		}
	}

}