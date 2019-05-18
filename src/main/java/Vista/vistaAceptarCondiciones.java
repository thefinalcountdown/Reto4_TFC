package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;

public class vistaAceptarCondiciones extends JPanel {

	public JCheckBox chckbxAceptarCondiciones;
	public JButton btnAceptar;
	
	public vistaAceptarCondiciones() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Es requisito necesario para la adquisici\u00F3n de los productos que se ofrecen en este sitio, que lea y acepte los siguientes T\u00E9rminos y Condiciones que a continuaci\u00F3n se redactan. El uso de nuestros servicios as\u00ED como la compra de nuestros productos implicar\u00E1 que usted ha le\u00EDdo y aceptado los T\u00E9rminos y Condiciones de Uso en el presente documento. Todas los productos  que son ofrecidos por nuestro sitio web pudieran ser creadas, cobradas, enviadas o presentadas por una p\u00E1gina web tercera y en tal caso estar\u00EDan sujetas a sus propios T\u00E9rminos y Condiciones. En algunos casos, para adquirir un producto, ser\u00E1 necesario el registro por parte del usuario, con ingreso de datos personales fidedignos y definici\u00F3n de una contrase\u00F1a.\r\n\r\nEl usuario puede elegir y cambiar la clave para su acceso de administraci\u00F3n de la cuenta en cualquier momento, en caso de que se haya registrado y que sea necesario para la compra de alguno de nuestros productos. no asume la responsabilidad en caso de que entregue dicha clave a terceros.\r\n\r\nTodas las compras y transacciones que se lleven a cabo por medio de este sitio web, est\u00E1n sujetas a un proceso de confirmaci\u00F3n y verificaci\u00F3n, el cual podr\u00EDa incluir la verificaci\u00F3n del stock y disponibilidad de producto, validaci\u00F3n de la forma de pago, validaci\u00F3n de la factura (en caso de existir) y el cumplimiento de las condiciones requeridas por el medio de pago seleccionado. En algunos casos puede que se requiera una verificaci\u00F3n por medio de correo electr\u00F3nico.\r\n\r\nLos precios de los productos ofrecidos en esta Tienda Online es v\u00E1lido solamente en las compras realizadas en este sitio web.</html>");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sergio\\eclipse-workspace\\Reto4_TFC\\Imagenes\\condiciones.PNG"));
		lblNewLabel.setBounds(218, 174, 623, 320);
		add(lblNewLabel);
		
		chckbxAceptarCondiciones = new JCheckBox("Acepto las Condiciones y Terminos de Uso");
		chckbxAceptarCondiciones.setBounds(278, 512, 301, 23);
		add(chckbxAceptarCondiciones);
		
		btnAceptar = new JButton("");
		btnAceptar.setIcon(new ImageIcon("/Users/marialaburu/MARIA/DAW/workspace/Reto4_TFC/Imagenes/aceptar.png"));
		btnAceptar.setBounds(698, 572, 110, 41);
		add(btnAceptar);
		
		JLabel lblCondicionesYTrminos = new JLabel("CONDICIONES Y TÉRMINOS DE USO");
		lblCondicionesYTrminos.setFont(new Font("Apple Color Emoji", Font.BOLD, 26));
		lblCondicionesYTrminos.setBounds(247, 59, 517, 25);
		add(lblCondicionesYTrminos);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(129, 86, 750, 12);
		add(separator);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("Imagenes/bg.jpg"));
		background.setBounds(6, 6, 1279, 700);
		add(background);


	}
}
