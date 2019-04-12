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

	public controladorLogin(Ventana ventana, modelo modelo) {
		this.ventana = ventana;
		this.modelo = modelo;

		ventana.login.btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				if (funcionesLogin.comprobarDni(GestorBD.consulta(funcionesLogin
						.sentenciaCombrobarDni(ventana.login.formattedTextFieldLoginDNI.getText()))) == false) 
				{
					JOptionPane.showMessageDialog(null, "El usuario no existe.");
				} 
				else if (funcionesLogin.comprobarLogin(GestorBD
						.consulta(funcionesLogin.sentenciaLogin(ventana.login.formattedTextFieldLoginDNI.getText(),
								String.valueOf(ventana.login.passwordFieldLoginClave.getPassword())))) == true) 
				{
					JOptionPane.showMessageDialog(null, "Usuario logueado con exito.");
					ventana.reserva.textField_DNIUsuario.setText(ventana.login.formattedTextFieldLoginDNI.getText());
					
					ventana.cambio_panel(ventana.login, ventana.raiz);
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
				restablecer_datos();
			}
		});

		ventana.login.btnModificar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ventana.cambio_panel(ventana.login, ventana.modificar);
				restablecer_datos();
			}
		});
	}
	
	public void restablecer_datos()
	{
		ventana.login.formattedTextFieldLoginDNI.setText("");
		ventana.login.passwordFieldLoginClave.setText("");
	}
}