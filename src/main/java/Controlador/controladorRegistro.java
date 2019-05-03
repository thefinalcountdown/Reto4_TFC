package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.funcionesRegistro;
import Modelo.modelo;
import Vista.Ventana;
import metodos.GestorBD;

public class controladorRegistro {

	private Ventana ventana;
	private modelo modelo;

	public controladorRegistro(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.registro.btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comprueba que los campos no esten vacios al registrar usuario
				if (modelo.modeloRegistro.comprobarCampos(ventana.registro.formattedTextFieldDNI.getText(),
						ventana.registro.formattedTextFieldNombre.getText(),
						ventana.registro.formattedTextFieldApellido.getText(),
						String.valueOf(ventana.registro.passwordFieldClave.getPassword())) == true) {
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos.");
				//comprueba que el dni sea válido a la hora de registrar usuario
				} else if (modelo.modeloRegistro
						.validarNIF(ventana.registro.formattedTextFieldDNI.getText()) == false) {
					JOptionPane.showMessageDialog(null, "El DNI introducido no es válido...");
				//comprueba si el usuario ya existe en la base de datos
				} else if (modelo.modeloLogin.comprobarDni(GestorBD.consulta(modelo.modeloLogin
						.sentenciaCombrobarDni(ventana.registro.formattedTextFieldDNI.getText()))) == true) {
					JOptionPane.showMessageDialog(null, "El usuario ya existe.");
				//inserta el usuario en la base de datos, manda los datos a la reserva y cambia de panel
				} else if (GestorBD.insertarDatos(
						modelo.modeloRegistro.sentenciaInsertarUsuario(ventana.registro.formattedTextFieldDNI.getText(),
								ventana.registro.formattedTextFieldNombre.getText(),
								ventana.registro.formattedTextFieldApellido.getText(),
								String.valueOf(ventana.registro.passwordFieldClave.getPassword()))) == true) {
					JOptionPane.showMessageDialog(null, "Usuario creado con exito.");
					String nombre_apellidos = ventana.registro.formattedTextFieldNombre.getText() + " "
							+ ventana.registro.formattedTextFieldApellido.getText();
					ventana.reserva.textField_DNI.setText(ventana.registro.formattedTextFieldDNI.getText());
					ventana.reserva.textField_usuario.setText(nombre_apellidos);
					ventana.cambio_panel(ventana.registro, ventana.raiz);
					JOptionPane.showMessageDialog(ventana.raiz, "Bienvenid@ " + nombre_apellidos);
				}
			}
		});

		ventana.registro.btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambio_panel(ventana.registro, ventana.login);

			}
		});
	}
}
