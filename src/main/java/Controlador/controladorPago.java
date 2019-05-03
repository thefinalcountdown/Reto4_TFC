package Controlador;

import Vista.Ventana;
import metodos.GestorBD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Modelo.ficheroReserva;
import Modelo.modelo;

public class controladorPago 
{
	private Ventana ventana;
	private modelo modelo;
	
	private double total_introducido=0;
	public static double total_faltante;
	private double total_devolucion=0;
	private double valorBoton=0;
	public static double precio;
	public int numPersonas;
	private int contador_billete200 = 0;
	private int contador_billete100 = 0;
	private int contador_billete50 = 0;
	private int contador_billete20 = 0;
	private int contador_billete10 = 0;
	private int contador_billete5 = 0;
	private int contador_moneda2e = 0;
	private int contador_moneda1e = 0;
	private int contador_moneda50cent = 0;
	private int contador_moneda20cent = 0;
	private int contador_moneda10cent = 0;
	private int contador_moneda5cent = 0;
	private int contador_moneda2cent = 0;
	private int contador_moneda1cent = 0;
	private int contador_monedas [] = {contador_billete200,contador_billete100,contador_billete50,contador_billete20,contador_billete10,contador_billete5,contador_moneda2e,contador_moneda1e,contador_moneda50cent,contador_moneda20cent,contador_moneda10cent,contador_moneda5cent,contador_moneda2cent,contador_moneda1cent};
	private String monedas[] = {"200 euros","100 euros","50 euros","20 euros","10 euros","5 euros", "2 euros", "1 euro", "50 centimos", "20 centimos", "10 centimos", "5 centimos", "2 centimos", "1 centimo"};
	
	public controladorPago() {}
	public controladorPago(Ventana ventana, modelo modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;
		
		
		
		ventana.pago.billete200.setActionCommand("200");
		ventana.pago.billete100.setActionCommand("100");
		ventana.pago.billete50.setActionCommand("50");
		ventana.pago.billete20.setActionCommand("20");
		ventana.pago.billete10.setActionCommand("10");
		ventana.pago.billete5.setActionCommand("5");
		ventana.pago.moneda2e.setActionCommand("2");
		ventana.pago.moneda1e.setActionCommand("1");
		ventana.pago.moneda50cent.setActionCommand("0.5");
		ventana.pago.moneda20cent.setActionCommand("0.2");
		ventana.pago.moneda10cent.setActionCommand("0.1");
		ventana.pago.moneda5cent.setActionCommand("0.05");
		ventana.pago.moneda2cent.setActionCommand("0.02");
		ventana.pago.moneda1cent.setActionCommand("0.01");

		
		ventana.pago.DineroIntroducido.setText("0.00 \u20ac");
		
		
		ventana.pago.billete200.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.billete200.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.billete100.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.billete100.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.billete50.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.billete50.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.billete20.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.billete20.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.billete10.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.billete10.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.billete5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.billete5.getActionCommand());
				actualizacion_pago();	
			}
		});
		
		
		
		ventana.pago.moneda2e.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.moneda2e.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.moneda1e.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.moneda1e.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.moneda50cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.moneda50cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.moneda20cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.moneda20cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.moneda10cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.moneda10cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.moneda5cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.moneda5cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.moneda2cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.moneda2cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.moneda1cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(ventana.pago.moneda1cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		ventana.pago.Cancelar_Pago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ventana.cambio_panel(ventana.pago, ventana.reserva);
				restablecer_datos();
			}
		});
		
		
		
		ventana.pago.Continuar_Pago.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{	 
				 contar_monedas();
				 ventana.pago.texto_panel.append("\n");
				 ventana.pago.texto_panel = insertar_texto(ventana.pago.texto_panel);
				
				
				 ventana.pago.panel.add(ventana.pago.texto_panel);
				 if(JOptionPane.showOptionDialog(ventana, ventana.pago.panel, "Devolución", JOptionPane.PLAIN_MESSAGE,
						 JOptionPane.PLAIN_MESSAGE, null, null, null)== 0)
				 {
					 	int codhotel= modelo.modeloListaHotel.hoteles
								.get(ventana.hotel.listaHoteles.getSelectedIndex()).getCod_alojamiento();
					 	int codhabitacion= modelo.modeloListaHotel.hoteles
								.get(ventana.hotel.listaHoteles.getSelectedIndex()).getCod_alojamiento();
					 	String nombreHotel = ventana.reserva.textField_hotelseleccionado.getText();
					 	float precio = Float.parseFloat(ventana.reserva.textField_precio.getText());
						int numPersonas = Integer.parseInt(ventana.reserva.textField_numpersonas.getText());
						int numHabitaciones = 3;
						String ubicacion = ventana.reserva.textField_ubicacion.getText();
						String fecha_entrada = ventana.reserva.textField_fechaDeEntrada.getText();
						String fecha_salida = ventana.reserva.textField_fechaDeSalida.getText();
						String DNI = ventana.reserva.textField_DNI.getText();
						String usuario = ventana.reserva.textField_usuario.getText();
						
						modelo.modeloFichero = new ficheroReserva( codhotel,codhabitacion,nombreHotel, precio, numPersonas, numHabitaciones, ubicacion, fecha_entrada,
								fecha_salida, DNI, usuario);
						
						modelo.modeloFichero.imprimirTicket();
						
						if(JOptionPane.showOptionDialog(ventana, "Fichero creado con exito", "Fichero", JOptionPane.PLAIN_MESSAGE, 
								JOptionPane.PLAIN_MESSAGE, null, null, null) == 0)
						{
							try
							{
								GestorBD.insertarReserva(modelo.modeloFichero.leerTicket());
							}
							catch (Exception ex)
							{
								JOptionPane.showMessageDialog(null, "No se pudo conectar con la Base de Datos");	
							}
							
							System.exit(0);
						}
				 }
			}
		});
	}
	
	public void DeshabilitarMonedas()
	{
		ventana.pago.Continuar_Pago.setEnabled(true);
		ventana.pago.billete200.setEnabled(false);
		ventana.pago.billete100.setEnabled(false);
		ventana.pago.billete50.setEnabled(false);
		ventana.pago.billete20.setEnabled(false);
		ventana.pago.billete10.setEnabled(false);
		ventana.pago.billete5.setEnabled(false);
		ventana.pago.moneda2e.setEnabled(false);
		ventana.pago.moneda1e.setEnabled(false);
		ventana.pago.moneda50cent.setEnabled(false);
		ventana.pago.moneda20cent.setEnabled(false);
		ventana.pago.moneda10cent.setEnabled(false);
		ventana.pago.moneda5cent.setEnabled(false);
		ventana.pago.moneda2cent.setEnabled(false);
		ventana.pago.moneda1cent.setEnabled(false);
		ventana.pago.DineroFaltante.setText("0.00");
	}
	
	public void restablecer_datos()
	{
		total_devolucion = 0;
		total_faltante = 0;
		total_introducido = 0;
		ventana.pago.DineroFaltante.setText("");
		ventana.pago.DineroIntroducido.setText("");
		ventana.pago.Continuar_Pago.setEnabled(false);
		
		ventana.pago.billete200.setEnabled(true);
		ventana.pago.billete100.setEnabled(true);
		ventana.pago.billete50.setEnabled(true);
		ventana.pago.billete20.setEnabled(true);
		ventana.pago.billete10.setEnabled(true);
		ventana.pago.billete5.setEnabled(true);
		ventana.pago.moneda2e.setEnabled(true);
		ventana.pago.moneda1e.setEnabled(true);
		ventana.pago.moneda50cent.setEnabled(true);
		ventana.pago.moneda20cent.setEnabled(true);
		ventana.pago.moneda10cent.setEnabled(true);
		ventana.pago.moneda5cent.setEnabled(true);
		ventana.pago.moneda2cent.setEnabled(true);
		ventana.pago.moneda1cent.setEnabled(true);
	}
	
	public JTextArea insertar_texto (JTextArea texto)
	{
		for (int posicion=0; posicion<contador_monedas.length;posicion++)
		{
			if (contador_monedas[posicion] > 0)
			{
				if(contador_monedas[posicion] == 1)
				{
					
					if (posicion < 6)
					{	
						texto.append("\t   -  "+contador_monedas[posicion]+" x Billete de "+monedas[posicion]+"\t\t\n\n");
					}
					else
					{
						texto.append("\t   -  "+contador_monedas[posicion]+" x Moneda de "+monedas[posicion]+"\t\t\n\n");
					}
					
				}
				else 
				{
					if (posicion < 6)
					{
						texto.append("\t   -  "+contador_monedas[posicion]+" x Billetes de "+monedas[posicion]+"\t\t\n\n");
					}
					else
					{
						texto.append("\t   -  "+contador_monedas[posicion]+" x Monedas de "+monedas[posicion]+"\t\t\n\n");
					}
				}
				
			}
		}
		return texto;
	}
	
	public void contar_monedas()
	{
		while (total_devolucion != 0) //Mientras el dinero a devolver no sea 0 calculara los billetes y monedas a devolver
		{
			if (total_devolucion>=200) //Si el dinero a devolver es mayor o igual a 200 le devolvera un billete de 200, y asi con todas las monedas y billetes
			{
				total_devolucion = total_devolucion - 200;
				contador_monedas[0] = contador_monedas[0] + 1;
			}

			else if (total_devolucion < 200 && total_devolucion >= 100)
			{
				total_devolucion = total_devolucion - 100;
				contador_monedas[1] = contador_monedas[1] + 1;
			}
			else if (total_devolucion < 100 && total_devolucion >= 50)
			{
				total_devolucion = total_devolucion - 50;
				contador_monedas[2] = contador_monedas[2] + 1;
			}
			else if (total_devolucion < 50 && total_devolucion >= 20)
			{
				total_devolucion = total_devolucion - 20;
				contador_monedas[3] = contador_monedas[3] + 1;
			}
			else if (total_devolucion < 20 && total_devolucion >= 10)
			{
				total_devolucion = total_devolucion - 10;
				contador_monedas[4] = contador_monedas[4] + 1;
			}
			else if (total_devolucion < 10 && total_devolucion >= 5)
			{
				total_devolucion = total_devolucion - 5;
				contador_monedas[5] = contador_monedas[5] + 1;
			}
			else if (total_devolucion < 5 && total_devolucion >= 2)
			{
				total_devolucion = total_devolucion - 2;
				contador_monedas[6] = contador_monedas[6] + 1;
			}
			else if (total_devolucion < 2 && total_devolucion >= 0.999)
			{
				total_devolucion = total_devolucion - 1;
				contador_monedas[7] = contador_monedas[7] + 1;
			}
			else if (total_devolucion < 1 && total_devolucion >= 0.499)
			{
				total_devolucion = total_devolucion - 0.5;
				contador_monedas[8] = contador_monedas[8] + 1;
			}
			else if (total_devolucion < 0.5 && total_devolucion >= 0.199)
			{
				total_devolucion = total_devolucion - 0.2;
				contador_monedas[9] = contador_monedas[9] + 1;
			}
			else if (total_devolucion < 0.2 && total_devolucion >= 0.099)
			{
				total_devolucion = total_devolucion - 0.1;
				contador_monedas[10] = contador_monedas[10] + 1;
			}
			else if (total_devolucion < 0.1 && total_devolucion >= 0.049)
			{
				total_devolucion = total_devolucion - 0.05;
				contador_monedas[11] = contador_monedas[11] + 1;
			}
			else if (total_devolucion < 0.05 && total_devolucion >= 0.019)
			{
				total_devolucion = total_devolucion - 0.02;
				contador_monedas[12] = contador_monedas[12] + 1;
			}
			else if (total_devolucion < 0.02 && total_devolucion >= 0.01)
			{
				total_devolucion = total_devolucion - 0.01;
				contador_monedas[13] = contador_monedas[13] + 1;
				
			}
			else //Si no se cumple ninguna condicion y devolucion es mayor o igual que 0.009 convertira el dinero a devolver a 1 centimo
			{
				if (total_devolucion >= 0.009)
				{
					total_devolucion = 0.01;
					total_devolucion = total_devolucion-0.01;
					contador_monedas[13] = contador_monedas[13] + 1;
				}
				else //Si es emnor que 0.009 saldra del bucle ignorando el resto de decimales
				{
					break;
				}
				
			}
		}
		
	}
	
	public void actualizacion_pago()
	{
		total_introducido=total_introducido+valorBoton;
		total_faltante = total_faltante-valorBoton;
		ventana.pago.DineroFaltante.setText(String.format("%.2f",total_faltante));
		ventana.pago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
		
		if (total_faltante <= 0.01)
		{
			DeshabilitarMonedas();
		}
		if (total_introducido > total_faltante)
		{
			total_devolucion = total_introducido - precio;
			BigDecimal decimal = new BigDecimal(total_devolucion);
			total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
			ventana.pago.Continuar_Pago.setEnabled(true);
		}
	}
}
