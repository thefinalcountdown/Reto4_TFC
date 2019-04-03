package Vista;

import javax.swing.JPanel;

public class Vista 
{
	public Ventana ventana = new Ventana();
	public vistaPago pago = new vistaPago();
	
	public Vista() {
		mostrarPanel(pago);
		ventana.setVisible(true);
	}
	
	public void mostrarPanel(JPanel panel) {
		ventana.setContentPane(panel);
	}
}
