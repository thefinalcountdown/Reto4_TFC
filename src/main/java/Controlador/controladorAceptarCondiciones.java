package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.modelo;
import Vista.Ventana;
import metodos.GestorBD;

public class controladorAceptarCondiciones {
	private Ventana ventana;
	private modelo modelo;

	public controladorAceptarCondiciones() {
	}

	public controladorAceptarCondiciones(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.condiciones.btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ventana.condiciones.chckbxAceptarCondiciones.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Debes aceptar Las condiciones de Uso...");
				} else if (GestorBD.insertarDatos(
						modelo.modeloRegistro.sentenciaInsertarUsuario(ventana.registro.formattedTextFieldDNI.getText().toUpperCase(),
								ventana.registro.formattedTextFieldNombre.getText().toUpperCase(),
								ventana.registro.formattedTextFieldApellido.getText().toUpperCase(),
								String.valueOf(ventana.registro.passwordFieldClave.getPassword()), 
								modelo.modeloRegistro.fechaRegistro())) == true) {
					JOptionPane.showMessageDialog(null, "Usuario creado con exito.");

					String nombre_apellidos = ventana.registro.formattedTextFieldNombre.getText().toUpperCase() + " "
							+ ventana.registro.formattedTextFieldApellido.getText().toUpperCase();
					ventana.reserva.textField_DNI.setText(ventana.registro.formattedTextFieldDNI.getText().toUpperCase());
					ventana.reserva.textField_usuario.setText(nombre_apellidos);
					ventana.cambio_panel(ventana.condiciones, ventana.raiz);
					JOptionPane.showMessageDialog(ventana.raiz, "Bienvenid@ " + nombre_apellidos);
				}
			}
		});
	}
}
