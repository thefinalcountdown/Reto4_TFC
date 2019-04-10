package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.funcionesLogin;
import Modelo.modelo;
import Vista.Ventana;
import Vista.vistaLogin;
import Vista.vistaRegistro;
import metodos.GestorBD;

public class controladorRegistro {

	private Ventana ventana;
	private modelo modelo;
	private Controlador Controlador;

	public controladorRegistro(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		vistaRegistro.btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (funcionesLogin.comprobarCampos(vistaRegistro.formattedTextFieldDNI.getText(),
						vistaRegistro.formattedTextFieldNombre.getText(),
						vistaRegistro.formattedTextFieldApellido.getText(),
						String.valueOf(vistaRegistro.passwordFieldClave.getPassword())) == true) {
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos...");
				} else if (GestorBD.comprobarUsuario(vistaRegistro.formattedTextFieldDNI.getText(),
						String.valueOf(vistaRegistro.passwordFieldClave.getPassword())) == true) {
					JOptionPane.showMessageDialog(null, "El usuario ya existe...");
				} else if (GestorBD.insertarUsuario(vistaRegistro.formattedTextFieldDNI.getText(),
						vistaRegistro.formattedTextFieldNombre.getText(),
						vistaRegistro.formattedTextFieldApellido.getText(),
						String.valueOf(vistaRegistro.passwordFieldClave.getPassword())) == true) {
					JOptionPane.showMessageDialog(null, "Usuario creado con exito...");
					ventana.cambio_panel(ventana.registro, ventana.seleccionar);
				}
			}
		});

		vistaRegistro.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.registro, ventana.seleccionar);
			}
		});
	}
}
