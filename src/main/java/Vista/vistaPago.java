package Vista;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class vistaPago extends JPanel
{
	public static JButton Cancelar_Pago = new JButton("Cancelar");
	public static  JButton Continuar_Pago = new JButton("Continuar");
	public static  JButton billete200 = new JButton();
	public static  JButton billete100 = new JButton();
	public static  JButton billete50 = new JButton();
	public static  JButton billete20 = new JButton();
	public static  JButton billete10 = new JButton();
	public static  JButton billete5 = new JButton();
	public static  JButton moneda2e = new JButton();
	public static  JButton moneda1e = new JButton();
	public static  JButton moneda50cent = new JButton();
	public static  JButton moneda20cent = new JButton();
	public static  JButton moneda10cent = new JButton();
	public static  JButton moneda5cent = new JButton();
	public static  JButton moneda2cent = new JButton();
	public static  JButton moneda1cent = new JButton();
	public static  JTextField DineroFaltante = new JTextField();
	public static  JLabel lblDineroIntroducido = new JLabel("Dinero Introducido");
	public static  JLabel lblDineroFaltante = new JLabel("Dinero A Pagar");
	public static  JTextField DineroIntroducido = new JTextField();
	
	
	
	public vistaPago()
	{
		setLayout(null);
		
		billete200.setIcon(new ImageIcon("Imagenes/200-euro-note-104181.png"));
		billete200.setBounds(39, 78, 169, 97);
		add(billete200);
		
		billete100.setIcon(new ImageIcon("Imagenes/dollar_bill__100_euro__money__banknote.jpg"));
		billete100.setBounds(257, 78, 169, 97);
		add(billete100);
		
		billete50.setIcon(new ImageIcon("Imagenes/50EuroSchein.jpg"));
		billete50.setBounds(470, 78, 169, 97);
		add(billete50);
		
		billete20.setIcon(new ImageIcon("Imagenes/2018-01-15-20-evrov-bolezen-in-pravica-82152.jpg"));
		billete20.setBounds(39, 187, 169, 97);
		add(billete20);
		
		billete10.setIcon(new ImageIcon("Imagenes/10-euro-640x334.jpg"));
		billete10.setBounds(257, 187, 169, 97);
		add(billete10);
		
		billete5.setIcon(new ImageIcon("Imagenes/Captura de pantalla 2018-11-20 a las 2.30.56.png"));
		billete5.setBounds(470, 187, 169, 97);
		add(billete5);
		
		moneda2e.setIcon(new ImageIcon("Imagenes/2euro_nt.gif"));
		moneda2e.setBounds(39, 296, 101, 97);
		add(moneda2e);
		
		moneda1e.setIcon(new ImageIcon("Imagenes/kisspng-euro-coins-europe-money-1-euro-coin-eur-5ada73a274ee58.337454961524265890479.png"));
		moneda1e.setBounds(207, 296, 101, 97);
		add(moneda1e);
		
		moneda50cent.setIcon(new ImageIcon("Imagenes/50centimos_nt.gif"));
		moneda50cent.setBounds(370, 296, 101, 97);
		add(moneda50cent);
		
		moneda20cent.setIcon(new ImageIcon("Imagenes/kisspng-20-cent-euro-coin-1-cent-euro-coin-euro-coins-portugal-clipart-5adbafbfd29330.4470813415243468158625.png"));
		moneda20cent.setBounds(528, 296, 101, 97);
		add(moneda20cent);
		
		moneda10cent.setIcon(new ImageIcon("Imagenes/10centimos_nt.gif"));
		moneda10cent.setBounds(39, 405, 101, 97);
		add(moneda10cent);
		
		moneda5cent.setIcon(new ImageIcon("Imagenes/5centimos_nt.gif"));
		moneda5cent.setBounds(207, 405, 101, 97);
		add(moneda5cent);
		
		moneda2cent.setIcon(new ImageIcon("Imagenes/2_Centesimi_Italia_2015_Euro_Cent_Fdc_Unc_Romacoins_m.png"));
		moneda2cent.setBounds(370, 405, 101, 97);
		add(moneda2cent);
		
		moneda1cent.setIcon(new ImageIcon("Imagenes/1_Centesimo_Italia_2014_Euro_Fdc_Unc_Romacoins_m.png"));
		moneda1cent.setBounds(528, 405, 101, 97);
		add(moneda1cent);
		
		Continuar_Pago.setBounds(686, 514, 198, 48);
		add(Continuar_Pago);
		Continuar_Pago.setEnabled(false);
		
		Cancelar_Pago.setBounds(6, 514, 198, 48);
		add(Cancelar_Pago);
		
		DineroIntroducido.setHorizontalAlignment(SwingConstants.RIGHT);
		DineroIntroducido.setEditable(false);
		DineroIntroducido.setBounds(783, 442, 101, 26);
		add(DineroIntroducido);
		DineroIntroducido.setColumns(10);
		
		
		lblDineroIntroducido.setFont(new Font("Arial", Font.BOLD, 13));
		lblDineroIntroducido.setBounds(652, 447, 119, 16);
		add(lblDineroIntroducido);
		
		DineroFaltante.setHorizontalAlignment(SwingConstants.RIGHT);
		DineroFaltante.setEditable(false);
		DineroFaltante.setColumns(10);
		DineroFaltante.setBounds(783, 405, 101, 26);
		add(DineroFaltante);
		
		
		lblDineroFaltante.setFont(new Font("Arial", Font.BOLD, 13));
		lblDineroFaltante.setBounds(652, 410, 119, 16);
		add(lblDineroFaltante);
	}
	
	
	
}
