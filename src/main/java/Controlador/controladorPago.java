package Controlador;

import Vista.Ventana;
import Vista.vistaPago;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Modelo.modelo;

public class controladorPago 
{
	private Ventana ventana;
	private modelo modelo;
	
	private double total_introducido=0;
	private double total_faltante;
	private double total_devolucion=0;
	private double valorBoton=0;
	private double precio = 300;
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
	
	public controladorPago(Ventana ventana, modelo modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;
		
		
		
		vistaPago.billete200.setActionCommand("200");
		vistaPago.billete100.setActionCommand("100");
		vistaPago.billete50.setActionCommand("50");
		vistaPago.billete20.setActionCommand("20");
		vistaPago.billete10.setActionCommand("10");
		vistaPago.billete5.setActionCommand("5");
		vistaPago.moneda2e.setActionCommand("2");
		vistaPago.moneda1e.setActionCommand("1");
		vistaPago.moneda50cent.setActionCommand("0.5");
		vistaPago.moneda20cent.setActionCommand("0.2");
		vistaPago.moneda10cent.setActionCommand("0.1");
		vistaPago.moneda5cent.setActionCommand("0.05");
		vistaPago.moneda2cent.setActionCommand("0.02");
		vistaPago.moneda1cent.setActionCommand("0.01");
		
		total_faltante = precio;
		vistaPago.DineroFaltante.setText(total_faltante+" \u20ac");
		vistaPago.DineroIntroducido.setText("0.00 \u20ac");
		
		
		vistaPago.billete200.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete200.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.billete100.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete100.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.billete50.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete50.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.billete20.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete20.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.billete10.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete10.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.billete5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete5.getActionCommand());
				actualizacion_pago();	
			}
		});
		
		
		
		vistaPago.moneda2e.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda2e.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.moneda1e.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda1e.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.moneda50cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda50cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.moneda20cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda20cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.moneda10cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda10cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.moneda5cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda5cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.moneda2cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda2cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.moneda1cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda1cent.getActionCommand());
				actualizacion_pago();
			}
		});
		
		
		
		vistaPago.Cancelar_Pago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				restablecer_datos();
			}
		});
		
		
		
		vistaPago.Continuar_Pago.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				 JPanel panel = new JPanel();
				 JTextArea texto = new JTextArea();
				 texto.setEditable(false);
				 
				 contar_monedas();
				 texto.append("\n");
				 texto = insertar_texto(texto);
				
				
				 panel.add(texto);
				 if(JOptionPane.showOptionDialog(ventana, panel, "Devolución", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, null, null)== 0)
				 {
					 restablecer_datos();
				 }
			}
		});
	}
	
	public void DeshabilitarMonedas()
	{
		vistaPago.Continuar_Pago.setEnabled(true);
		vistaPago.billete200.setEnabled(false);
		vistaPago.billete100.setEnabled(false);
		vistaPago.billete50.setEnabled(false);
		vistaPago.billete20.setEnabled(false);
		vistaPago.billete10.setEnabled(false);
		vistaPago.billete5.setEnabled(false);
		vistaPago.moneda2e.setEnabled(false);
		vistaPago.moneda1e.setEnabled(false);
		vistaPago.moneda50cent.setEnabled(false);
		vistaPago.moneda20cent.setEnabled(false);
		vistaPago.moneda10cent.setEnabled(false);
		vistaPago.moneda5cent.setEnabled(false);
		vistaPago.moneda2cent.setEnabled(false);
		vistaPago.moneda1cent.setEnabled(false);
		vistaPago.DineroFaltante.setText("0.00");
	}
	
	public void restablecer_datos()
	{
		total_devolucion = 0;
		total_faltante = 0;
		total_introducido = 0;
		vistaPago.DineroFaltante.setText("");
		vistaPago.DineroIntroducido.setText("");
		vistaPago.Continuar_Pago.setEnabled(false);
		
		vistaPago.billete200.setEnabled(true);
		vistaPago.billete100.setEnabled(true);
		vistaPago.billete50.setEnabled(true);
		vistaPago.billete20.setEnabled(true);
		vistaPago.billete10.setEnabled(true);
		vistaPago.billete5.setEnabled(true);
		vistaPago.moneda2e.setEnabled(true);
		vistaPago.moneda1e.setEnabled(true);
		vistaPago.moneda50cent.setEnabled(true);
		vistaPago.moneda20cent.setEnabled(true);
		vistaPago.moneda10cent.setEnabled(true);
		vistaPago.moneda5cent.setEnabled(true);
		vistaPago.moneda2cent.setEnabled(true);
		vistaPago.moneda1cent.setEnabled(true);
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
		vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
		vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
		
		if (total_faltante <= 0.01)
		{
			DeshabilitarMonedas();
		}
		if (total_introducido > total_faltante)
		{
			total_devolucion = total_introducido - precio;
			BigDecimal decimal = new BigDecimal(total_devolucion);
			total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
			vistaPago.Continuar_Pago.setEnabled(true);
		}
	}
}
