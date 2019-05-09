package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import Modelo.modelo;
import Vista.Ventana;

public class controladorReserva {
	private Ventana ventana;
	private modelo modelo;
	

	public controladorReserva(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.reserva.Continuar_Reserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.reserva, ventana.pago);

				
				double precio = Float.parseFloat(ventana.reserva.textField_precio.getText());
				
				
				ventana.pago.DineroFaltante.setText(Double.toString(precio) + " \u20ac");
				controladorPago.precio = precio;
				controladorPago.total_faltante = precio;
			}

		});

		ventana.reserva.Cancelar_Reserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.reserva, ventana.hotel);

			}
		});
	}
}
