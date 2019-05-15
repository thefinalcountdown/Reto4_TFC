package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelo.TemporadaAlta;
import Modelo.fechasTarifas;
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

	public controladorRaiz(Ventana ventana, modelo modelo){
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
					
					if(ventana.raiz.fechaOut.getDate() == null || 
							ventana.raiz.fechaOut.getDate().before(ventana.raiz.fechaIn.getDate()))
					{
						ventana.raiz.fechaOut.setDate(calendario.getTime());
					}
				}
				catch (NullPointerException e)
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
				int maxKids = Integer.parseInt(ventana.raiz.txtKids.getText());
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
			public void actionPerformed(ActionEvent e) {
				String ubicacionSeleccionada = ventana.raiz.comboBoxUbicacion.getSelectedItem().toString();
				try{
					Date fechaIn = ventana.raiz.fechaIn.getDate();
					Date fechaOut = ventana.raiz.fechaOut.getDate();
					
					// Pasar fechaIn y fechaOut a tipo LocalDate
					LocalDate inicio = fechaIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					LocalDate fin = fechaOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					
					// Obtener lista de todos los dias que se han seleccionado
					ArrayList<LocalDate> diasSeleccionados = obtenerDiasEntreFechas(inicio, fin);
					// Obtener lista de la base de datos con todos los días festivos que hay
					ArrayList<LocalDate> diasFestivos = fechasTarifas.obtenerDiasFestivos();
					// Obtener lista de la base de datos con todas las temporadas altas que hay
					ArrayList<TemporadaAlta> temporadasAltas = fechasTarifas.obtenerTemporadasAltas();
					
					boolean diaFestivoSeleccionado = false;
					boolean diaTempAltaSeleccionado = false;
					
					// Bucle para comprobar si entre los dias seleccionados hay algún festivo
					// recorrer la lista de festivos
					for (int i = 0; i < diasFestivos.size(); i++) {
						LocalDate diaFestivo = diasFestivos.get(i);
						for (int j = 0; j < diasSeleccionados.size(); j++) {
							LocalDate diaSeleccionado = diasSeleccionados.get(j);
							if(diaFestivo.compareTo(diaSeleccionado) == 0) {
								diaFestivoSeleccionado = true;
							}
						}
						
					}
					// Si el boolean esta a true (que entre los dias seleccionados hay un festivo)
					if(diaFestivoSeleccionado == true) {
						JOptionPane.showMessageDialog(null,
								"Uno de los días seleccionados es un dia festivo y supone un incremento en el precio del 10%");
					}

					// Bucle para comprobar si los días seleccionados están en temporada alta
					for (int i = 0; i < temporadasAltas.size(); i++) {
						TemporadaAlta tempAlta = temporadasAltas.get(i);
						ArrayList<LocalDate> diasTemporadaAlta = obtenerDiasEntreFechas(tempAlta.getInicio(), tempAlta.getFin());
						for (int j = 0; j < diasTemporadaAlta.size(); j++) {
							LocalDate diaTemporadaAlta = diasTemporadaAlta.get(j);
							for (int k = 0; k < diasSeleccionados.size(); k++) {
								LocalDate diaSeleccionado = diasSeleccionados.get(k);
								if(diaTemporadaAlta.compareTo(diaSeleccionado) == 0) {
									diaTempAltaSeleccionado = true;
								}
							}

						}
						
					}
					// Si el boolean esta a true (Que alguno de los dias seleccionados sea de temporada alta)
					if(diaTempAltaSeleccionado == true) {
						JOptionPane.showMessageDialog(null,
								"Las fechas seleccionadas suponen un incremento del 20% en el precio al ser temporada alta");
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				

				try {
					modelo.modeloListaAlojamiento.llenarLista(ubicacionSeleccionada);
					ventana.alojamiento.listaAlojamientos.setModel(modelo.modeloListaAlojamiento);

				} catch (Exception e1) {
					System.out.println("los ArrayList de alojamiento no han sido rellenados");
					e1.printStackTrace();
				}

				ventana.cambio_panel(ventana.raiz, ventana.alojamiento);
				
				int numeroPersonas = num_huespedes + num_kids;
				ventana.reserva.textField_numpersonas.setText(Integer.toString(numeroPersonas));
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
	
	public ArrayList<LocalDate> obtenerDiasEntreFechas(LocalDate inicio, LocalDate fin){
		LocalDate incrementingDate = inicio;

		ArrayList<LocalDate> diasTemporadaAlta = new ArrayList<LocalDate>();

		while (!incrementingDate.isAfter(fin)) {
		    diasTemporadaAlta.add(incrementingDate);
		    incrementingDate = incrementingDate.plusDays(1);
		}

		return diasTemporadaAlta;
	}

}