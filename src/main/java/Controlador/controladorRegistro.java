package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.modelo;
import Vista.Ventana;
import metodos.GestorBD;

public class controladorRegistro {

	private Ventana ventana;
	private modelo modelo;

	public controladorRegistro(Ventana ventana, modelo modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.registro.btnRegistro.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (modelo.modeloLogin.comprobarCampos(ventana.registro.formattedTextFieldDNI.getText(),
						ventana.registro.formattedTextFieldNombre.getText(),
						ventana.registro.formattedTextFieldApellido.getText(),
						String.valueOf(ventana.registro.passwordFieldClave.getPassword())) == true) 
				{
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos.");
				}
				else if (modelo.modeloLogin.comprobarDni(GestorBD.consulta(modelo.modeloLogin
						.sentenciaCombrobarDni(ventana.registro.formattedTextFieldDNI.getText()))) == true) 
				{
					JOptionPane.showMessageDialog(null, "El usuario ya existe.");
				} 
				else if (GestorBD.insertarDatos(
						modelo.modeloLogin.sentenciaInsertarUsuario(ventana.registro.formattedTextFieldDNI.getText(),
								ventana.registro.formattedTextFieldNombre.getText(),
								ventana.registro.formattedTextFieldApellido.getText(),
								String.valueOf(ventana.registro.passwordFieldClave.getPassword()))) == true) 
				{
					JOptionPane.showMessageDialog(null, "Usuario creado con exito.");
					String nombre_apellidos = ventana.registro.formattedTextFieldNombre.getText() + " " + ventana.registro.formattedTextFieldApellido.getText();
					ventana.reserva.textField_DNI.setText(ventana.registro.formattedTextFieldDNI.getText());
					ventana.reserva.textField_usuario.setText(nombre_apellidos);
					ventana.cambio_panel(ventana.registro, ventana.raiz);
					JOptionPane.showMessageDialog(ventana.raiz, "Bienvenid@ " + nombre_apellidos);
				}
			}
		});

		ventana.registro.btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ventana.cambio_panel(ventana.registro, ventana.login);

			}
		});
	}
}
