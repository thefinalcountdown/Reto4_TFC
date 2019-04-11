package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.funcionesLogin;
import Modelo.modelo;
import Vista.Ventana;
import metodos.GestorBD;

public class controladorModificar {
	private Ventana ventana;
	private modelo modelo;
	private Controlador Controlador;

	public controladorModificar(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.modificar.btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (funcionesLogin.comprobarDni(GestorBD.consulta(funcionesLogin.sentenciaCombrobarDni(
						ventana.modificar.formattedTextFieldActualizarDNI.getText()))) == false) {
					JOptionPane.showMessageDialog(null, "El usuario no existe...");
				} else if (funcionesLogin.comprobarLogin(GestorBD.consulta(funcionesLogin.sentenciaLogin(
						ventana.modificar.formattedTextFieldActualizarDNI.getText(),
						String.valueOf(ventana.modificar.passwordFieldActualizarClave.getPassword())))) == false) {
					JOptionPane.showMessageDialog(null, "Clave incorrecta...");
				} else if (GestorBD.insertarDatos(funcionesLogin.sentenciaActualizarUsuario(
						ventana.modificar.formattedTextFieldActualizarDNI.getText(),
						String.valueOf(ventana.modificar.passwordFieldActualizarClave.getPassword()),
						String.valueOf(ventana.modificar.passwordFieldNuevaClave.getPassword()))) == true) {
					JOptionPane.showMessageDialog(null, "Clave actualizada con exito...");
				}
			}
		});

		ventana.modificar.btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (funcionesLogin.comprobarDni(GestorBD.consulta(funcionesLogin
						.sentenciaCombrobarDni(ventana.modificar.formattedTextFieldBorrarDni.getText()))) == false) {
					JOptionPane.showMessageDialog(null, "El usuario no existe...");
				} else if (funcionesLogin.comprobarLogin(GestorBD
						.consulta(funcionesLogin.sentenciaLogin(ventana.modificar.formattedTextFieldBorrarDni.getText(),
								String.valueOf(ventana.modificar.passwordFieldBorrarDni.getPassword())))) == false) {
					JOptionPane.showMessageDialog(null, "Clave incorrecta...");
				} else if (GestorBD.insertarDatos(
						funcionesLogin.sentenciaBorrarUsuario(ventana.modificar.formattedTextFieldBorrarDni.getText(),
								String.valueOf(ventana.modificar.passwordFieldBorrarDni.getPassword()))) == true) {
					JOptionPane.showMessageDialog(null, "Usuario borrado correctamente");
				}
			}
		});

		ventana.modificar.btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.cambio_panel(ventana.modificar, ventana.login);
			}
		});
	}
}
