package Vista;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;

public class vistaPago extends JPanel
{
	private static final long serialVersionUID = 1L;
	public JButton Cancelar_Pago = new JButton("");
	public JButton Continuar_Pago = new JButton("");
	public JButton billete200 = new JButton();
	public JButton billete100 = new JButton();
	public JButton billete50 = new JButton();
	public JButton billete20 = new JButton();
	public JButton billete10 = new JButton();
	public JButton billete5 = new JButton();
	public JButton moneda2e = new JButton();
	public JButton moneda1e = new JButton();
	public JButton moneda50cent = new JButton();
	public JButton moneda20cent = new JButton();
	public JButton moneda10cent = new JButton();
	public JButton moneda5cent = new JButton();
	public JButton moneda2cent = new JButton();
	public JButton moneda1cent = new JButton();
	public JTextField DineroFaltante = new JTextField();
	public JLabel lblDineroIntroducido = new JLabel("Dinero Introducido");
	public JLabel lblDineroFaltante = new JLabel("Dinero A Pagar");
	public JTextField DineroIntroducido = new JTextField();
	public JPanel panel = new JPanel();
	public JTextArea texto_panel = new JTextArea();
	private final JLabel label = new JLabel("RESERVA");
	private JSeparator separator = new JSeparator();
	
	
	
	
	public vistaPago()
	{
		setLayout(null);
		
		billete200.setIcon(new ImageIcon("Imagenes/200-euro-note-104181.png"));
		billete200.setBounds(278, 151, 169, 97);
		add(billete200);
		
		billete100.setIcon(new ImageIcon("Imagenes/dollar_bill__100_euro__money__banknote.jpg"));
		billete100.setBounds(496, 151, 169, 97);
		add(billete100);
		
		billete50.setIcon(new ImageIcon("Imagenes/50EuroSchein.jpg"));
		billete50.setBounds(709, 151, 169, 97);
		add(billete50);
		
		billete20.setIcon(new ImageIcon("Imagenes/2018-01-15-20-evrov-bolezen-in-pravica-82152.jpg"));
		billete20.setBounds(278, 260, 169, 97);
		add(billete20);
		
		billete10.setIcon(new ImageIcon("Imagenes/10-euro-640x334.jpg"));
		billete10.setBounds(496, 260, 169, 97);
		add(billete10);
		
		billete5.setIcon(new ImageIcon("Imagenes/Captura de pantalla 2018-11-20 a las 2.30.56.png"));
		billete5.setBounds(709, 260, 169, 97);
		add(billete5);
		
		moneda2e.setIcon(new ImageIcon("Imagenes/2euro_nt.gif"));
		moneda2e.setBounds(278, 369, 101, 97);
		add(moneda2e);
		
		moneda1e.setIcon(new ImageIcon("Imagenes/kisspng-euro-coins-europe-money-1-euro-coin-eur-5ada73a274ee58.337454961524265890479.png"));
		moneda1e.setBounds(446, 369, 101, 97);
		add(moneda1e);
		
		moneda50cent.setIcon(new ImageIcon("Imagenes/50centimos_nt.gif"));
		moneda50cent.setBounds(609, 369, 101, 97);
		add(moneda50cent);
		
		moneda20cent.setIcon(new ImageIcon("Imagenes/kisspng-20-cent-euro-coin-1-cent-euro-coin-euro-coins-portugal-clipart-5adbafbfd29330.4470813415243468158625.png"));
		moneda20cent.setBounds(767, 369, 101, 97);
		add(moneda20cent);
		
		moneda10cent.setIcon(new ImageIcon("Imagenes/10centimos_nt.gif"));
		moneda10cent.setBounds(278, 478, 101, 97);
		add(moneda10cent);
		
		moneda5cent.setIcon(new ImageIcon("Imagenes/5centimos_nt.gif"));
		moneda5cent.setBounds(446, 478, 101, 97);
		add(moneda5cent);
		
		moneda2cent.setIcon(new ImageIcon("Imagenes/2_Centesimi_Italia_2015_Euro_Cent_Fdc_Unc_Romacoins_m.png"));
		moneda2cent.setBounds(609, 478, 101, 97);
		add(moneda2cent);
		
		moneda1cent.setIcon(new ImageIcon("Imagenes/1_Centesimo_Italia_2014_Euro_Fdc_Unc_Romacoins_m.png"));
		moneda1cent.setBounds(767, 478, 101, 97);
		add(moneda1cent);
		Continuar_Pago.setIcon(new ImageIcon("Imagenes/pagar.png"));
		
		Continuar_Pago.setBounds(981, 606, 184, 62);
		add(Continuar_Pago);
		Continuar_Pago.setEnabled(false);
		
		Cancelar_Pago.setIcon(new ImageIcon("Imagenes/cancelar.png"));
		Cancelar_Pago.setBounds(38, 606, 184, 62);
		add(Cancelar_Pago);
		
		DineroIntroducido.setHorizontalAlignment(SwingConstants.RIGHT);
		DineroIntroducido.setEditable(false);
		DineroIntroducido.setBounds(1073, 468, 101, 26);
		add(DineroIntroducido);
		DineroIntroducido.setColumns(10);
		
		
		lblDineroIntroducido.setFont(new Font("Arial", Font.BOLD, 13));
		lblDineroIntroducido.setBounds(942, 473, 119, 16);
		add(lblDineroIntroducido);
		
		DineroFaltante.setHorizontalAlignment(SwingConstants.RIGHT);
		DineroFaltante.setEditable(false);
		DineroFaltante.setColumns(10);
		DineroFaltante.setBounds(1073, 431, 101, 26);
		add(DineroFaltante);
		
		
		lblDineroFaltante.setFont(new Font("Arial", Font.BOLD, 13));
		lblDineroFaltante.setBounds(942, 436, 119, 16);
		add(lblDineroFaltante);
		
		texto_panel.setEditable(false);
		
		JLabel lblReserva = new JLabel("FINALIZA TU RESERVA");
		lblReserva.setFont(new Font("Apple Color Emoji", Font.BOLD, 26));
		lblReserva.setBounds(416, 43, 338, 25);
		add(lblReserva);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(188, 75, 750, 12);
		add(separator);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Imagenes/bg.jpg"));
		background.setBounds(6, 6, 1279, 700);
		add(background);
		

	}
	
	
	
}
