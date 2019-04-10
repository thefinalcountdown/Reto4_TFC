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

		ventana.login.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GestorBD.comprobarUsuario(ventana.login.formattedTextFieldLoginDNI.getText(),
						String.valueOf(ventana.login.passwordFieldLoginClave.getPassword())) == false) {
					JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrectos...");
				} else {
					funcionesLogin.rellenarUsuario(GestorBD
							.consulta(funcionesLogin.sentenciaLogin(ventana.login.formattedTextFieldLoginDNI.getText(),
									String.valueOf(ventana.login.passwordFieldLoginClave.getPassword()))));
					JOptionPane.showMessageDialog(null, "Usuario logueado correctamente...");
					ventana.cambio_panel(ventana.login, ventana.reserva);
				}
			}
		});

		ventana.login.btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (GestorBD.comprobarUsuario(ventana.login.formattedTextFieldLoginDNI.getText(),
						String.valueOf(ventana.login.passwordFieldLoginClave.getPassword())) == false) {
					JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrectos...");
				} else {
					GestorBD.actualizarUsuario(ventana.login.formattedTextFieldActualizarDNI.getText(),
							String.valueOf(ventana.login.passwordFieldActualizarClave.getPassword()),
							String.valueOf(ventana.login.passwordFieldNuevaClave.getPassword()));
					JOptionPane.showMessageDialog(null, "Contrase�a actualizada correctamente...");
				}
			}
		});

		ventana.login.btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (GestorBD.comprobarUsuario(ventana.login.formattedTextFieldLoginDNI.getText(),
						String.valueOf(ventana.login.passwordFieldLoginClave.getPassword())) == false) {
					JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrectos...");
				} else {
					GestorBD.borrarUsuario(ventana.login.formattedTextFieldLoginDNI.getText(),
							String.valueOf(ventana.login.passwordFieldLoginClave.getPassword()));
					JOptionPane.showMessageDialog(null, "Usuario borrado correctamente...");
				}
			}
		});

		ventana.login.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.login, ventana.seleccionar);
			}
		});
	}
}