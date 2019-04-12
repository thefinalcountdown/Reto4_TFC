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

import Vista.vistaHoteles;
import metodos.GestorBD;

public class controladorRaiz {
	private Ventana ventana;
	private modelo modelo;

	public static int num_huespedes = 1;
	public static int num_kids = 0;
	public static int num_Hab = 1;

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

		// boton sumar Adulto
		ventana.raiz.btnSumAdult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maxKids = Integer.parseInt(ventana.raiz.txtKids.getText());
				num_huespedes++;
				ventana.raiz.txthuesped.setText(Integer.toString(num_huespedes));
				if(num_huespedes > 11) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				} 
				else if(num_huespedes== 12 || num_huespedes==11) {
					ventana.raiz.btnSumKids.setEnabled(false);
					ventana.raiz.btnRestKids.setEnabled(false);
					ventana.raiz.txtKids.setText("0");
				}
					
				}/*else if(num_huespedes == 8 || num_huespedes ==7) {
					if(num_kids >3){
						 ventana.raiz.btnSumKids.setEnabled(false);}
					
				}else if(num_huespedes == 6 || num_huespedes ==5 || num_huespedes ==4) {
					if(num_kids >5){
						 ventana.raiz.btnSumKids.setEnabled(false);}
					
				}else if(num_huespedes == 3 || num_huespedes ==2) {
					if(num_kids >3){
						 ventana.raiz.btnSumKids.setEnabled(false);}
					
				}else if(num_huespedes == 1) {
					if(num_kids >1){
						 ventana.raiz.btnSumKids.setEnabled(false);}
				}*/
				
			
		});
		

		// boton restar Adulto
		ventana.raiz.btnRestAdult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num_huespedes > 1 || num_huespedes<11) {
					num_huespedes--;
					ventana.raiz.txthuesped.setText(Integer.toString(num_huespedes));
					ventana.raiz.btnSumAdult.setEnabled(true);
					ventana.raiz.btnSumKids.setEnabled(true);
					ventana.raiz.btnRestKids.setEnabled(true);
				}
			}
		});
		
		// boton sumar Niño
		ventana.raiz.btnSumKids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num_kids++;
				ventana.raiz.txtKids.setText(Integer.toString(num_kids));
				ventana.raiz.btnSumKids.setEnabled(true);
				if(num_kids > 5) {
					ventana.raiz.btnSumKids.setEnabled(false);
					
				} else if(num_huespedes ==9 || num_huespedes ==10 && num_kids >=2) { //cuando haya 9 /10 adultos maximo niños 2
					ventana.raiz.btnSumKids.setEnabled(false);
					
				} else if(num_huespedes == 8 || num_huespedes == 7 && num_kids >=4) { // cuando haya 8 adultos maximo niños 4
					ventana.raiz.btnSumKids.setEnabled(false);
				
				}else if(num_huespedes ==6 || num_huespedes ==5 || num_huespedes ==4 && num_kids >=6) { //cuando haya 6 adultos maximo niños 6
					ventana.raiz.btnSumKids.setEnabled(false);
				
				}else if(num_huespedes ==3 || num_huespedes ==2 && num_kids >=4) {
					ventana.raiz.btnSumKids.setEnabled(false);//cuando haya 3 adultos maximo niños 4
				
				}else if(num_huespedes ==1 && num_kids >=2) {
					ventana.raiz.btnSumKids.setEnabled(false); //cuando haya 1 adulto maximo niños 2
				}
				
			}
		});

		// boton restar Niño
		ventana.raiz.btnRestKids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num_kids > 1) {
					num_kids--;
					ventana.raiz.txtKids.setText(Integer.toString(num_kids));
					
				}else if(num_huespedes ==9 || num_huespedes ==10 && num_kids <2) { // cuando haya 9 adultos y menos de 2 niños activar btnSumKids
					ventana.raiz.btnSumKids.setEnabled(true);
					
				} else if(num_huespedes == 8 || num_huespedes == 7 && num_kids <4) {
					ventana.raiz.btnSumKids.setEnabled(true); //cuando haya 8 adultos y menos de 4 niños activar btnSumKids
				
				}else if(num_huespedes ==6 || num_huespedes == 5 || num_huespedes == 4 && num_kids <6) { //cuando haya 6 adultos y menos de 6 niños activar btnSumKids
					ventana.raiz.btnRestKids.setEnabled(true); 
				
				}else if(num_huespedes == 3 || num_huespedes ==2 && num_kids <4) { //cuando haya 3 adultos y menos de 4 niños activar btnSumKids
					ventana.raiz.btnRestKids.setEnabled(true);
				
				}else if(num_huespedes == 1 && num_kids <2) { //cuando haya 1 adultos y menos de 2 niños activar btnSumKids
					ventana.raiz.btnRestKids.setEnabled(true);
				}
			}
		});

		// boton sumar Habitacion
		ventana.raiz.btnSumHab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num_Hab++;
				ventana.raiz.txtHab.setText(Integer.toString(num_Hab));
				if(num_Hab < 3) {
					ventana.raiz.btnSumHab.setEnabled(true);
				}else{
					ventana.raiz.btnSumHab.setEnabled(false);
				}
			}
		});

		// boton restar Habitacion
		ventana.raiz.btnRestHab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num_Hab > 1 || num_Hab <3) {
					num_Hab--;
					ventana.raiz.txtHab.setText(Integer.toString(num_Hab));
					ventana.raiz.btnSumHab.setEnabled(true);
				}
			}
		});
		
		// boton pasar siguiente ventana
		ventana.raiz.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ubicacionSeleccionada = ventana.raiz.comboBoxUbicacion.getSelectedItem().toString();

				Date fechaIn = ventana.raiz.fechaIn.getDate();
				Date fechaOut = ventana.raiz.fechaOut.getDate();

				try {

					vistaHoteles.lm.llenarLista(ubicacionSeleccionada);
//					ModeloLista.llenarLista(ubicacionSeleccionada);

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
