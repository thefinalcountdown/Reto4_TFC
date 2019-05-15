package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.modelo;
import Vista.Ventana;
import metodos.GestorBD;

public class controladorReserva {
	private Ventana ventana;
	private modelo modelo;
	
	private static int descuento = 0;

	public controladorReserva(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.reserva.Continuar_Reserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.reserva, ventana.pago);

				
				double precio = Float.parseFloat(ventana.reserva.textField_precio.getText());
				
				
				ventana.pago.DineroFaltante.setText(Double.toString(precio-descuento) + " \u20ac");
				controladorPago.precio = precio;
				controladorPago.total_faltante = precio;
				
			}

		});

		ventana.reserva.btnCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modelo.modeloPromocion.consultarPromocion(GestorBD.consulta
						(modelo.modeloPromocion.sentenciaCodigoPromocional
								(ventana.reserva.formattedTextFieldCodigo.getText())))==0) {
					JOptionPane.showMessageDialog(null, "No has introducido un codigo valido.");
					
				}
				else if(modelo.modeloPromocion.consultarPromocion(GestorBD.consulta
						(modelo.modeloPromocion.sentenciaCodigoPromocional
								(ventana.reserva.formattedTextFieldCodigo.getText())))==5) {
					JOptionPane.showMessageDialog(null, "Se te aplicara un descuento de 5 euros a tu reserva.");
					ventana.reserva.btnCodigo.setEnabled(false);
					descuento = 5;
				}
				else if(modelo.modeloPromocion.consultarPromocion(GestorBD.consulta
						(modelo.modeloPromocion.sentenciaCodigoPromocional
								(ventana.reserva.formattedTextFieldCodigo.getText())))==10) {
					JOptionPane.showMessageDialog(null, "Se te aplicara un descuento de 10 euros a tu reserva.");
					ventana.reserva.btnCodigo.setEnabled(false);
					descuento = 10;
				}
				else if(modelo.modeloPromocion.consultarPromocion(GestorBD.consulta
						(modelo.modeloPromocion.sentenciaCodigoPromocional
								(ventana.reserva.formattedTextFieldCodigo.getText())))==15) {
					JOptionPane.showMessageDialog(null, "Se te aplicara un descuento de 15 euros a tu reserva.");
					ventana.reserva.btnCodigo.setEnabled(false);
					descuento = 15;
				}
				
			}
		});
		
		ventana.reserva.Cancelar_Reserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.reserva, ventana.alojamiento);
				modelo.habitacion.vaciarTabla(ventana.alojamiento.modeloTabla);
			}
		});
	}
}
