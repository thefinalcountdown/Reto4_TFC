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
				if (GestorBD.comprobarUsuario(vistaLogin.formattedTextFieldLoginDNI.getText(),
						String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword())) == false) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos...");
				} else {
					funcionesLogin.rellenarUsuario(GestorBD
							.consulta(funcionesLogin.sentenciaLogin(vistaLogin.formattedTextFieldLoginDNI.getText(),
									String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword()))));
					JOptionPane.showMessageDialog(null, "Usuario logueado correctamente...");
					ventana.cambio_panel(ventana.login, ventana.reserva);
				}
			}
		});

		vistaLogin.btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (GestorBD.comprobarUsuario(vistaLogin.formattedTextFieldLoginDNI.getText(),
						String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword())) == false) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos...");
				} else {
					GestorBD.actualizarUsuario(vistaLogin.formattedTextFieldActualizarDNI.getText(),
							String.valueOf(vistaLogin.passwordFieldActualizarClave.getPassword()),
							String.valueOf(vistaLogin.passwordFieldNuevaClave.getPassword()));
					JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente...");
				}
			}
		});

		vistaLogin.btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (GestorBD.comprobarUsuario(vistaLogin.formattedTextFieldLoginDNI.getText(),
						String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword())) == false) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos...");
				} else {
					GestorBD.borrarUsuario(vistaLogin.formattedTextFieldLoginDNI.getText(),
							String.valueOf(vistaLogin.passwordFieldLoginClave.getPassword()));
					JOptionPane.showMessageDialog(null, "Usuario borrado correctamente...");
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