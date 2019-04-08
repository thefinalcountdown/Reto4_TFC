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

		vistaLogin.btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// comprueba que todos los campos han sido rellenados, si no es asi, mandara un
				// panel con el mensaje
				if (funcionesLogin.comprobarCampos(vistaLogin.textFieldDniRegistro.getText(),
						vistaLogin.textFieldNombre.getText(), vistaLogin.textFieldApellido.getText(),
						String.valueOf(vistaLogin.passwordFieldClaveRegistro.getPassword())) == true) {
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos...");
					// Comprueba que el dni exista en la base de datos antes de insertar uno nuevo,
					// si el usuario
					// ya existe, nos mandara un panel
				} else if (funcionesLogin.comprobarUsuario(GestorBD.consulta(
						funcionesLogin.sentenciaComprobarUsuario(vistaLogin.textFieldDniRegistro.getText())))) {
					JOptionPane.showMessageDialog(null, "El usuario ya existe...");
					// Mandamos a insertar datos del gestor la sentencia que vamos a formar con los
					// textfield
					// que tengamos rellenados a la hora de pulsar el boton de registro
				} else if (GestorBD.insertarDatos(
						funcionesLogin.sentenciaInsertarUsuario(vistaLogin.textFieldDniRegistro.getText(),
								vistaLogin.textFieldNombre.getText(), vistaLogin.textFieldApellido.getText(),
								String.valueOf(vistaLogin.passwordFieldClaveRegistro.getPassword()))) == true) {
					JOptionPane.showMessageDialog(null, "Usuario creado con exito, logueate...");
				}
			}
		});

		vistaLogin.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// A la funcion login le mandamos una consulta, con la sentencia login, que
				// obtendra de los textfield
				// de la vista login. Si es falsa, nos mandara un panel.
				if (funcionesLogin
						.login(GestorBD.consulta(funcionesLogin.sentenciaLogin(vistaLogin.textFieldDniLogin.getText(),
								String.valueOf(vistaLogin.passwordFieldClaveLogin.getPassword())))) == false) {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos...");
				}
				// Si la funcion login no es falsa, el login sera correcto, y cambiaremos a la
				// siguiente ventana. Y guardaremos
				else {
					JOptionPane.showMessageDialog(null, "Logueado correctamente...");
					funcionesLogin.rellenarUsuario(
							GestorBD.consulta(funcionesLogin.sentenciaLogin(vistaLogin.textFieldDniLogin.getText(),
									String.valueOf(vistaLogin.passwordFieldClaveLogin.getPassword()))));

					ventana.cambio_panel(ventana.login, ventana.reserva);
				}
			}
		});

		vistaLogin.btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Comprueba que el dni y la pass que se van a actualizar existen en la base de
				// dados
				if (funcionesLogin.comprobarClave(GestorBD
						.consulta(funcionesLogin.sentenciaComprobarClave(vistaLogin.textFieldActualizarDNI.getText(),
								String.valueOf(vistaLogin.passwordFieldActualizarClave.getPassword())))) == true) {
					// Si el dni y la clave coinciden en la base de datos, actualiza la password del
					// usuario
					GestorBD.insertarDatos(
							funcionesLogin.sentenciaActualizar(vistaLogin.textFieldActualizarDNI.getText(),
									String.valueOf(vistaLogin.passwordFieldActualizarClave.getPassword()),
									String.valueOf(vistaLogin.passwordFieldNuevaClave.getPassword())));
					JOptionPane.showMessageDialog(null, "Contraseña actualizada con exito...");
				} else {
					JOptionPane.showMessageDialog(null,
							"Usuario o contraseña no válidos, No se pudo actualizar la contraseña...");
				}
			}
		});

		vistaLogin.btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Comprueba si el usuario existe en la base de datos
				if (funcionesLogin.comprobarUsuario(GestorBD.consulta(
						funcionesLogin.sentenciaComprobarUsuario(vistaLogin.textFieldDniRegistro.getText()))) == true) {
					// Si el usuario existe, lo borra
					GestorBD.insertarDatos(funcionesLogin.sentenciaBorrarUsuario(vistaLogin.textFieldDniLogin.getText(),
							String.valueOf(vistaLogin.passwordFieldClaveLogin.getPassword())));
					JOptionPane.showMessageDialog(null, "Usuario borrado con exito...");
				}
				// Si el usuario no existe o la contraseña no coincide sacara un panel
				else {
					JOptionPane.showMessageDialog(null, "El usuario o la contraseña no son válidos...");
				}
			}
		});
	}
}