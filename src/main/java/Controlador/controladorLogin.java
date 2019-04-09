package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.funcionesLogin;
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

		vistaLogin.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (funcionesLogin.comprobarLogin(GestorBD.consulta(
						funcionesLogin.sentenciaComprobarLogin(vistaLogin.formattedTextFieldLoginDNI.getText(),
								String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword())))) == true) {
					funcionesLogin.rellenarUsuario(GestorBD.consulta(
							funcionesLogin.sentenciaComprobarLogin(vistaLogin.formattedTextFieldLoginDNI.getText(),
									String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword()))));
					JOptionPane.showMessageDialog(null, "Usuario Logueado con exito...");
					ventana.cambio_panel(ventana.login, ventana.reserva);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos...");
				}
			}
		});

		vistaLogin.btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (funcionesLogin.comprobarLogin(GestorBD.consulta(
						funcionesLogin.sentenciaComprobarLogin(vistaLogin.formattedTextFieldLoginDNI.getText(),
								String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword())))) == true) {
					GestorBD.insertarDatos(
							funcionesLogin.sentenciaActualizar(vistaLogin.formattedTextFieldActualizarDNI.getText(),
									String.valueOf(vistaLogin.passwordFieldActualizarClave.getPassword()),
									String.valueOf(vistaLogin.passwordFieldNuevaClave.getPassword())));
					JOptionPane.showMessageDialog(null, "Contraseña actualizada con exito...");
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo actualizar la contraseña...");
				}
			}
		});

		vistaLogin.btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (funcionesLogin.comprobarLogin(GestorBD.consulta(
						funcionesLogin.sentenciaComprobarLogin(vistaLogin.formattedTextFieldLoginDNI.getText(),
								String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword())))) == true) {
					GestorBD.insertarDatos(
							funcionesLogin.sentenciaBorrarUsuario(vistaLogin.formattedTextFieldLoginDNI.getText(),
									String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword())));
					JOptionPane.showMessageDialog(null, "Usuario borrado con exito...");
				} else if (funcionesLogin.comprobarLogin(GestorBD.consulta(
						funcionesLogin.sentenciaComprobarLogin(vistaLogin.formattedTextFieldLoginDNI.getText(),
								String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword())))) == false) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos...");
				} else {
					JOptionPane.showMessageDialog(null, "El usuario no existe...");
				}
			}
		});

		vistaLogin.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.login, ventana.seleccionar);
			}
		});
	}
}