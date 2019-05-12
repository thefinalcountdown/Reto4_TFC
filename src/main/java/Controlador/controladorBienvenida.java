package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.modelo;
import Vista.Ventana;

public class controladorBienvenida {
	private Ventana ventana;
	private modelo modelo;

	public controladorBienvenida(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;
		
		
		
		ventana.bienvenida.btnBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ventana.cambio_panel(ventana.bienvenida, ventana.login);

			}
		});
	}

}
