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
				if (funcionesLogin.comprobarDni(GestorBD.consulta(funcionesLogin
						.sentenciaCombrobarDni(ventana.login.formattedTextFieldLoginDNI.getText()))) == false) {
					JOptionPane.showMessageDialog(null, "El usuario no existe...");
				} else if (funcionesLogin.comprobarLogin(GestorBD
						.consulta(funcionesLogin.sentenciaLogin(ventana.login.formattedTextFieldLoginDNI.getText(),
								String.valueOf(ventana.login.passwordFieldLoginClave.getPassword())))) == true) {
					JOptionPane.showMessageDialog(null, "Usuario logueado con exito...");
					ventana.cambio_panel(ventana.login, ventana.reserva);
				} else {
					JOptionPane.showMessageDialog(null, "Clave incorrecta...");
				}
			}
		});

		ventana.login.btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (funcionesLogin.comprobarDni(GestorBD.consulta(funcionesLogin
						.sentenciaCombrobarDni(ventana.login.formattedTextFieldActualizarDNI.getText()))) == false) {
					JOptionPane.showMessageDialog(null, "El usuario no existe...");
				} else if (funcionesLogin.comprobarLogin(GestorBD
						.consulta(funcionesLogin.sentenciaLogin(ventana.login.formattedTextFieldActualizarDNI.getText(),
								String.valueOf(ventana.login.passwordFieldActualizarClave.getPassword())))) == false) {
					JOptionPane.showMessageDialog(null, "Clave incorrecta...");
				} else if (GestorBD.insertarDatos(funcionesLogin.sentenciaActualizarUsuario(
						ventana.login.formattedTextFieldActualizarDNI.getText(),
						String.valueOf(ventana.login.passwordFieldActualizarClave.getPassword()),
						String.valueOf(ventana.login.passwordFieldNuevaClave.getPassword()))) == true) {
					JOptionPane.showMessageDialog(null, "Clave actualizada con exito...");
				}
			}
		});

		ventana.login.btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (funcionesLogin.comprobarDni(GestorBD.consulta(funcionesLogin
						.sentenciaCombrobarDni(ventana.login.formattedTextFieldLoginDNI.getText()))) == false) {
					JOptionPane.showMessageDialog(null, "El usuario no existe...");
				} else if (funcionesLogin.comprobarLogin(GestorBD
						.consulta(funcionesLogin.sentenciaLogin(ventana.login.formattedTextFieldLoginDNI.getText(),
								String.valueOf(ventana.login.passwordFieldLoginClave.getPassword())))) == false) {
					JOptionPane.showMessageDialog(null, "Clave incorrecta...");
				} else if (GestorBD.insertarDatos(
						funcionesLogin.sentenciaBorrarUsuario(ventana.login.formattedTextFieldLoginDNI.getText(),
								String.valueOf(ventana.login.passwordFieldLoginClave.getPassword()))) == true) {
					JOptionPane.showMessageDialog(null, "Usuario borrado correctamente");
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