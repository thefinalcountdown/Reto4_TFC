package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.modelo;
import Vista.Ventana;
import Vista.vistaLogin;
import metodos.GestorBD;

public class controladorLogin {

	private Ventana ventana;
	private modelo modelo;
	private Controlador Controlador;

	public controladorLogin(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		vistaLogin.btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (GestorBD.comprobarCampos(vistaLogin.textFieldDniRegistro.getText(),
						vistaLogin.textFieldNombre.getText(), vistaLogin.textFieldApellido.getText(),
						vistaLogin.textFieldClaveRegistro.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos...");
				} else if (GestorBD.comprobarUsuario(vistaLogin.textFieldDniRegistro.getText()) == true) {
					JOptionPane.showMessageDialog(null, "El usuario ya existe...");
				} else if (GestorBD.insertarUsuario(vistaLogin.textFieldDniRegistro.getText(),
						vistaLogin.textFieldNombre.getText(), vistaLogin.textFieldApellido.getText(),
						vistaLogin.textFieldClaveRegistro.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Usuario creado con exito, logueate...");
				}
			}
		});

		vistaLogin.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ventana.cambio_panel(ventana.login, ventana.reserva);
			}
		});

		vistaLogin.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}
}
