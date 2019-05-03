package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
				if (modelo.modeloLogin.comprobarDni(GestorBD.consulta(modelo.modeloLogin.sentenciaCombrobarDni(
						ventana.modificar.formattedTextFieldActualizarDNI.getText()))) == false) {
					JOptionPane.showMessageDialog(null, "El usuario no existe.");
				} else if (modelo.modeloRegistro
						.validarNIF(ventana.modificar.formattedTextFieldActualizarDNI.getText()) == false) {
					JOptionPane.showMessageDialog(null, "El DNI introducido no es válido...");
				} else if (modelo.modeloLogin.comprobarLogin(GestorBD.consulta(modelo.modeloLogin.sentenciaLogin(
						ventana.modificar.formattedTextFieldActualizarDNI.getText(),
						String.valueOf(ventana.modificar.passwordFieldActualizarClave.getPassword())))) == false) {
					JOptionPane.showMessageDialog(null, "Clave incorrecta.");
				} else if (GestorBD.insertarDatos(modelo.modeloLogin.sentenciaActualizarUsuario(
						ventana.modificar.formattedTextFieldActualizarDNI.getText(),
						String.valueOf(ventana.modificar.passwordFieldActualizarClave.getPassword()),
						String.valueOf(ventana.modificar.passwordFieldNuevaClave.getPassword()))) == true) {
					JOptionPane.showMessageDialog(null, "Clave actualizada con exito.");
					ventana.cambio_panel(ventana.modificar, ventana.login);
					restablecer_datos();
				}
			}
		});

		ventana.modificar.btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modelo.modeloLogin.comprobarDni(GestorBD.consulta(modelo.modeloLogin
						.sentenciaCombrobarDni(ventana.modificar.formattedTextFieldBorrarDni.getText()))) == false) {
					JOptionPane.showMessageDialog(null, "El usuario no existe...");
				} else if (modelo.modeloRegistro
						.validarNIF(ventana.modificar.formattedTextFieldBorrarDni.getText()) == false) {
					JOptionPane.showMessageDialog(null, "El DNI introducido no es válido...");
				} else if (modelo.modeloLogin.comprobarLogin(GestorBD.consulta(
						modelo.modeloLogin.sentenciaLogin(ventana.modificar.formattedTextFieldBorrarDni.getText(),
								String.valueOf(ventana.modificar.passwordFieldBorrarDni.getPassword())))) == false) {
					JOptionPane.showMessageDialog(null, "Clave incorrecta...");
				} else if (GestorBD.insertarDatos(modelo.modeloLogin.sentenciaBorrarUsuario(
						ventana.modificar.formattedTextFieldBorrarDni.getText(),
						String.valueOf(ventana.modificar.passwordFieldBorrarDni.getPassword()))) == true) {
					JOptionPane.showMessageDialog(null, "Usuario borrado correctamente.");
					ventana.cambio_panel(ventana.modificar, ventana.login);
					restablecer_datos();
				}
			}
		});

		ventana.modificar.btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.cambio_panel(ventana.modificar, ventana.login);
				restablecer_datos();
			}
		});
	}

	public void restablecer_datos() {
		ventana.modificar.formattedTextFieldActualizarDNI.setText("");
		ventana.modificar.formattedTextFieldBorrarDni.setText("");
		ventana.modificar.passwordFieldActualizarClave.setText("");
		ventana.modificar.passwordFieldBorrarDni.setText("");
		ventana.modificar.passwordFieldNuevaClave.setText("");

	}
}
