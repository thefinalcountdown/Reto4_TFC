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

		ventana.registro.btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (funcionesLogin.comprobarCampos(ventana.registro.formattedTextFieldDNI.getText(),
						ventana.registro.formattedTextFieldNombre.getText(),
						ventana.registro.formattedTextFieldApellido.getText(),
						String.valueOf(ventana.registro.passwordFieldClave.getPassword())) == true) {
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos...");
				} else if (funcionesLogin.comprobarDni(GestorBD.consulta(funcionesLogin
						.sentenciaCombrobarDni(ventana.registro.formattedTextFieldDNI.getText()))) == true) {
					JOptionPane.showMessageDialog(null, "El usuario ya existe...");
				} else if (GestorBD.insertarDatos(
						funcionesLogin.sentenciaInsertarUsuario(ventana.registro.formattedTextFieldDNI.getText(),
								ventana.registro.formattedTextFieldNombre.getText(),
								ventana.registro.formattedTextFieldApellido.getText(),
								String.valueOf(ventana.registro.passwordFieldClave.getPassword()))) == true) {
					JOptionPane.showMessageDialog(null, "Usuario creado con exito...");
					ventana.cambio_panel(ventana.registro, ventana.seleccionar);
				}
			}
		});

		ventana.registro.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.registro, ventana.seleccionar);
			}
		});
	}
}
