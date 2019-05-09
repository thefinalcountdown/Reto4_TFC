package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import Modelo.modelo;
import Vista.Ventana;
import metodos.GestorBD;

public class controladorLogin implements KeyListener{

	private Ventana ventana;
	private modelo modelo;
	private Controlador Controlador;

	public controladorLogin(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.login.formattedTextFieldLoginDNI.addKeyListener(this);
		ventana.login.passwordFieldLoginClave.addKeyListener(this);
		ventana.login.btnLogin.addKeyListener(this);
		
		ventana.login.btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				validar_login();
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
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		 
		if (key == KeyEvent.VK_ENTER && ventana.login.formattedTextFieldLoginDNI.isFocusOwner()) 
		{
			ventana.login.passwordFieldLoginClave.requestFocus();
		}
		
		if (key == KeyEvent.VK_ENTER && ventana.login.passwordFieldLoginClave.isFocusOwner()) 
		{
			ventana.login.btnLogin.requestFocus();
		}	
		if (key == KeyEvent.VK_ENTER && ventana.login.btnLogin.isFocusOwner()) 
		{
			validar_login();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void validar_login()
	{
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
}