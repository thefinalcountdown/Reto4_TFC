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
				// comprueba que todos los campos han sido rellenados, si no es asi, mandara un
				// panel con el mensaje
				if (funcionesLogin.comprobarCampos(vistaRegistro.formattedTextFieldDNI.getText(),
						vistaRegistro.formattedTextFieldNombre.getText(),
						vistaRegistro.formattedTextFieldApellido.getText(),
						String.valueOf(vistaRegistro.passwordFieldClave.getPassword())) == true) {
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos...");
					// Comprueba que el dni exista en la base de datos antes de insertar uno nuevo,
					// si el usuario
					// ya existe, nos mandara un panel
				} else if (funcionesLogin.comprobarUsuario(GestorBD.consulta(funcionesLogin
						.sentenciaComprobarUsuario(vistaRegistro.formattedTextFieldDNI.getText()))) == true) {
					JOptionPane.showMessageDialog(null, "El usuario ya existe...");
					// Mandamos a insertar datos del gestor la sentencia que vamos a formar con los
					// textfield
					// que tengamos rellenados a la hora de pulsar el boton de registro
				} else if (GestorBD.insertarDatos(funcionesLogin.sentenciaInsertarUsuario(
						vistaRegistro.formattedTextFieldDNI.getText(), vistaRegistro.formattedTextFieldNombre.getText(),
						vistaRegistro.formattedTextFieldApellido.getText(),
						String.valueOf(vistaRegistro.passwordFieldClave.getPassword()))) == true) {
					JOptionPane.showMessageDialog(null, "Usuario creado con exito, logueate...");
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
