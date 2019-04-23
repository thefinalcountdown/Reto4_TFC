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
import Modelo.ModeloLista;
import Vista.Ventana;

import Vista.vistaHoteles;
import metodos.GestorBD;

public class controladorRaiz {
	private Ventana ventana;
	private modelo modelo;
	static ModeloLista lm= new ModeloLista();

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
				if(num_huespedes == 12){
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if(num_huespedes == 11){
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 10 || num_huespedes == 9 || num_huespedes == 1) && num_kids == 2) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 8 || num_huespedes == 7 || num_huespedes == 3 || num_huespedes == 2) && num_kids == 4) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 6 || num_huespedes == 5 || num_huespedes == 4) && num_kids == 6) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else {
					ventana.raiz.btnSumAdult.setEnabled(true);
					ventana.raiz.btnSumKids.setEnabled(true);
					ventana.raiz.btnRestAdult.setEnabled(true);
					ventana.raiz.btnRestKids.setEnabled(true);
				}
				
				if(num_huespedes == 0){
					ventana.raiz.btnRestAdult.setEnabled(false);
					ventana.raiz.btnSumKids.setEnabled(false);
				}
				if (num_kids == 0){
					ventana.raiz.btnRestKids.setEnabled(false);
				}
				if((num_kids > 2) && (num_huespedes == 2)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				
				if((num_kids > 4) && (num_huespedes == 4)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if(num_huespedes == 8 && num_kids > 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if(num_huespedes == 10 && num_kids > 0) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 1) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				
				if((num_huespedes == 10) && num_kids == 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if(num_huespedes == 8 && num_kids == 4) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if((num_huespedes == 6) && num_kids == 6) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				
			}
			
		});
		

		// boton restar Adulto
		ventana.raiz.btnRestAdult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				num_huespedes--;
				ventana.raiz.txthuesped.setText(Integer.toString(num_huespedes));
				if(num_huespedes == 12){
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if(num_huespedes == 11){
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 10 || num_huespedes == 9 || num_huespedes == 1) && num_kids == 2) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 8 || num_huespedes == 7 || num_huespedes == 3 || num_huespedes == 2) && num_kids == 4) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 6 || num_huespedes == 5 || num_huespedes == 4) && num_kids == 6) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else {
					ventana.raiz.btnSumAdult.setEnabled(true);
					ventana.raiz.btnSumKids.setEnabled(true);
					ventana.raiz.btnRestAdult.setEnabled(true);
					ventana.raiz.btnRestKids.setEnabled(true);
				}
				
				if(num_huespedes == 0){
					ventana.raiz.btnRestAdult.setEnabled(false);
					ventana.raiz.btnSumKids.setEnabled(false);
				}
				if (num_kids == 0){
					ventana.raiz.btnRestKids.setEnabled(false);
				}
				if((num_kids > 2) && (num_huespedes == 2)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if((num_kids > 4) && (num_huespedes == 4)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if(num_huespedes == 8 && num_kids > 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if(num_huespedes == 10 && num_kids > 0) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 1) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				
				if((num_huespedes == 10) && num_kids == 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if(num_huespedes == 8 && num_kids == 4) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if((num_huespedes == 6) && num_kids == 6) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				
			}
		});
		
		// boton sumar Niño
		ventana.raiz.btnSumKids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num_kids++;
				ventana.raiz.txtKids.setText(Integer.toString(num_kids));
				if(num_huespedes == 12){
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if(num_huespedes == 11){
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 10 || num_huespedes == 9 || num_huespedes == 1) && num_kids == 2) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 8 || num_huespedes == 7 || num_huespedes == 3 || num_huespedes == 2) && num_kids == 4) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 6 || num_huespedes == 5 || num_huespedes == 4) && num_kids == 6) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else {
					ventana.raiz.btnSumAdult.setEnabled(true);
					ventana.raiz.btnSumKids.setEnabled(true);
					ventana.raiz.btnRestAdult.setEnabled(true);
					ventana.raiz.btnRestKids.setEnabled(true);
				}
				
				if(num_huespedes == 0){
					ventana.raiz.btnRestAdult.setEnabled(false);
					ventana.raiz.btnSumKids.setEnabled(false);
				}
				if (num_kids == 0){
					ventana.raiz.btnRestKids.setEnabled(false);
				}
				if((num_kids > 2) && (num_huespedes == 2)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if((num_kids > 4) && (num_huespedes == 4)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if(num_huespedes == 8 && num_kids > 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if(num_huespedes == 10 && num_kids > 0) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 1) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				
				if((num_huespedes == 10) && num_kids == 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if(num_huespedes == 8 && num_kids == 4) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if((num_huespedes == 6) && num_kids == 6) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				
				
			}
		});

		// boton restar Niño
		ventana.raiz.btnRestKids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				num_kids--;
				ventana.raiz.txtKids.setText(Integer.toString(num_kids));
				if(num_huespedes == 12){
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if(num_huespedes == 11){
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 10 || num_huespedes == 9 || num_huespedes == 1) && num_kids == 2) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 8 || num_huespedes == 7 || num_huespedes == 3 || num_huespedes == 2) && num_kids == 4) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else if((num_huespedes == 6 || num_huespedes == 5 || num_huespedes == 4) && num_kids == 6) {
					ventana.raiz.btnSumKids.setEnabled(false);
				}else {
					ventana.raiz.btnSumAdult.setEnabled(true);
					ventana.raiz.btnSumKids.setEnabled(true);
					ventana.raiz.btnRestAdult.setEnabled(true);
					ventana.raiz.btnRestKids.setEnabled(true);
				}
				
				if(num_huespedes == 0){
					ventana.raiz.btnRestAdult.setEnabled(false);
					ventana.raiz.btnSumKids.setEnabled(false);
				}
				if (num_kids == 0){
					ventana.raiz.btnRestKids.setEnabled(false);
				}
				if((num_kids > 2) && (num_huespedes == 2)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if((num_kids > 4) && (num_huespedes == 4)) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				if(num_huespedes == 8 && num_kids > 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if(num_huespedes == 10 && num_kids > 0) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}
				if (num_huespedes == 1) {
					ventana.raiz.btnRestAdult.setEnabled(false);
				}
				
				if((num_huespedes == 10) && num_kids == 2) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if(num_huespedes == 8 && num_kids == 4) {
					ventana.raiz.btnSumAdult.setEnabled(false);
				}else if((num_huespedes == 6) && num_kids == 6) {
					ventana.raiz.btnSumAdult.setEnabled(false);
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
				if(!ventana.raiz.btnRestHab.isEnabled()) {
					ventana.raiz.btnRestHab.setEnabled(true);
				}
				if(num_Hab == 1) {
					ventana.raiz.btnRestHab.setEnabled(false);
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
				if(num_Hab == 1) {
					ventana.raiz.btnRestHab.setEnabled(false);
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
					lm.llenarLista(ubicacionSeleccionada);
					ventana.hotel.listaHoteles.setModel(lm);
					
					//vistaHoteles.lm.llenarLista(ubicacionSeleccionada);
					//ModeloLista.llenarLista(ubicacionSeleccionada);a

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