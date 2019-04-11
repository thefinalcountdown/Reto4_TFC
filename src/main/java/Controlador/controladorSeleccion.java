package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.modelo;
import Vista.Ventana;

public class controladorSeleccion {

	private Ventana ventana;
	private modelo modelo;
	private Controlador Controlador;

	public controladorSeleccion(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.seleccionar.btnIrLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.seleccionar, ventana.login);
			}
		});

		ventana.seleccionar.btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.cambio_panel(ventana.seleccionar, ventana.registro);
			}
		});
	}
}