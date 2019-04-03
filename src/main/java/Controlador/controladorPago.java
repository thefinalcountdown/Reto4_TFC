package Controlador;

import Vista.Ventana;
import Vista.vistaPago;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JTextField;

import Modelo.modelo;

public class controladorPago 
{
	private Ventana ventana;
	private modelo modelo;
	
	private double total_introducido=0;
	private double total_faltante = 300;
	private double total_devolucion=0;
	private double valorBoton=0;
	private double precio = 0;
	
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
		
		
		vistaPago.billete200.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete200.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.billete100.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete100.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_faltante < 0)
				{
					total_devolucion = total_introducido - precio;
				}
			}
		});
		
		vistaPago.billete50.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete50.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.billete20.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete20.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.billete10.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete10.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.billete5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.billete5.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.moneda2e.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda2e.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.moneda1e.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda1e.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.moneda50cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda50cent.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.moneda20cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda20cent.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.moneda10cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda10cent.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
			
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.moneda5cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda5cent.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.moneda2cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda2cent.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
			
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		vistaPago.moneda1cent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				valorBoton = Double.parseDouble(vistaPago.moneda1cent.getActionCommand());
				total_introducido=total_introducido+valorBoton;
				total_faltante = total_faltante-valorBoton;
				vistaPago.DineroFaltante.setText(String.format("%.2f",total_faltante));
				vistaPago.DineroIntroducido.setText(String.format("%.2f", total_introducido));
				
				if (total_faltante <= 0.01)
				{
					DeshabilitarMonedas(vistaPago.Continuar_Pago, vistaPago.billete200, vistaPago.billete100, vistaPago.billete50, vistaPago.billete20, vistaPago.billete10, 
							vistaPago.billete5, vistaPago.moneda2e, vistaPago.moneda1e, vistaPago.moneda50cent, vistaPago.moneda20cent, vistaPago.moneda10cent, 
							vistaPago.moneda5cent, vistaPago.moneda2cent, vistaPago.moneda1cent, vistaPago.DineroFaltante);
				}
				if (total_introducido > total_faltante)
				{
					total_devolucion = total_introducido - precio;
					BigDecimal decimal = new BigDecimal(total_devolucion);
					total_devolucion = decimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
		});
		
		
		vistaPago.Continuar_Pago.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
	}
	
	public void DeshabilitarMonedas(JButton continuar_Pago, JButton billete200, JButton billete100, JButton billete50, JButton billete20, JButton billete10,
			JButton billete5, JButton moneda2e, JButton moneda1e, JButton moneda50cent, JButton moneda20cent, JButton moneda10cent,
			JButton moneda5cent, JButton moneda2cent, JButton moneda1cent, JTextField dineroFaltante)
	{
		vistaPago.Continuar_Pago.setEnabled(true);
		billete200.setEnabled(false);
		billete100.setEnabled(false);
		billete50.setEnabled(false);
		billete20.setEnabled(false);
		billete10.setEnabled(false);
		billete5.setEnabled(false);
		moneda2e.setEnabled(false);
		moneda1e.setEnabled(false);
		moneda50cent.setEnabled(false);
		moneda20cent.setEnabled(false);
		moneda10cent.setEnabled(false);
		moneda5cent.setEnabled(false);
		moneda2cent.setEnabled(false);
		moneda1cent.setEnabled(false);
		vistaPago.DineroFaltante.setText("0.00");
	}
}
