package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

				Date fechaIn = ventana.raiz.fechaIn.getDate();
				Date fechaOut = ventana.raiz.fechaOut.getDate();
				
				double precio = Float.parseFloat(ventana.reserva.textField_precio.getText());
				
				if (fechaIn.after(ventana.raiz.temporadaAltaInicio) && fechaIn.before(ventana.raiz.temporadaAltaFin)
						|| fechaOut.after(ventana.raiz.temporadaAltaInicio)
								&& fechaOut.before(ventana.raiz.temporadaAltaFin)) {
					 precio = precio + (precio * 0.20);
				}
				if(fechaIn.equals(ventana.raiz.Enero1) || fechaIn.equals(ventana.raiz.Enero6) || fechaIn.equals(ventana.raiz.Abril19) || fechaIn.equals(ventana.raiz.Abril21)
						|| fechaIn.equals(ventana.raiz.Mayo1) || fechaIn.equals(ventana.raiz.Octubre12) || fechaIn.equals(ventana.raiz.Noviembre1) || fechaIn.equals(ventana.raiz.Diciembre6)
						|| fechaIn.equals(ventana.raiz.Diciembre8) || fechaIn.equals(ventana.raiz.Diciembre25)) {
					precio = precio + (precio * 0.10);
				}
				if(fechaOut.equals(ventana.raiz.Enero1) || fechaOut.equals(ventana.raiz.Enero6) || fechaOut.equals(ventana.raiz.Abril19) || fechaOut.equals(ventana.raiz.Abril21)
						|| fechaOut.equals(ventana.raiz.Mayo1) || fechaOut.equals(ventana.raiz.Octubre12) || fechaOut.equals(ventana.raiz.Noviembre1)
						|| fechaOut.equals(ventana.raiz.Diciembre6) || fechaOut.equals(ventana.raiz.Diciembre8) || fechaOut.equals(ventana.raiz.Diciembre25)) {
					precio = precio + (precio * 0.10);
				}
				
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
