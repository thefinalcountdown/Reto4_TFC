package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.modelo;
import Vista.Ventana;
import metodos.GestorBD;

public class controladorLogin {

	private Ventana ventana;
	private modelo modelo;
	private Controlador Controlador;

	public controladorLogin(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.login.btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// comprueba si el usuario existe en la base de datos
				if (modelo.modeloLogin.comprobarDni(GestorBD.consulta(modelo.modeloLogin
						.sentenciaCombrobarDni(ventana.login.formattedTextFieldLoginDNI.getText().toUpperCase()))) == false)
				{
					JOptionPane.showMessageDialog(null, "El usuario no existe.");
					// comprueba que el dni sea valido a la hora de registrar usuario
				} 
				else if (modelo.modeloRegistro.validarNIF(ventana.login.formattedTextFieldLoginDNI.getText().toUpperCase()) == false) 
				{
					JOptionPane.showMessageDialog(null, "El DNI introducido no es v\u00e1lido...");
					// intenta loguear con el usuario, si dni y contrasena son correctos manda el
					// usuario a la reserva y cambia de panel
				} 
				else if (modelo.modeloLogin.comprobarLogin(GestorBD.consulta(modelo.modeloLogin.sentenciaLogin(ventana.login.formattedTextFieldLoginDNI.getText().toUpperCase(),
								String.valueOf(ventana.login.passwordFieldLoginClave.getPassword())))) == true) 
				{
					JOptionPane.showMessageDialog(null, "Usuario logueado con exito.");
					String nombre_apellidos = GestorBD.conseguir_nombre_apellidos(ventana.login.formattedTextFieldLoginDNI.getText().toUpperCase());
					
					ventana.reserva.textField_usuario.setText(nombre_apellidos);
					ventana.reserva.textField_DNI.setText(ventana.login.formattedTextFieldLoginDNI.getText());
					ventana.cambio_panel(ventana.login, ventana.raiz);
					JOptionPane.showMessageDialog(ventana.raiz, "Bienvenid@ " + nombre_apellidos);
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "Clave incorrecta.");
				}
			}
		});

		ventana.login.btnRegistro.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ventana.cambio_panel(ventana.login, ventana.registro);
			}
		});

		ventana.login.btnModificar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ventana.cambio_panel(ventana.login, ventana.modificar);

			}
		});
	}
}