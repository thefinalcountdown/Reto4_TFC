package Vista;

import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.junit.Test;

public class VentanaTest {

	private Ventana ventana = new Ventana();
	
	@Test
	public void testCambio_panel() {
		JPanel ocultar = new JPanel();
		JPanel mostrar = new JPanel();
		ventana.cambio_panel(ocultar, mostrar);
		assertEquals(false, ocultar.isVisible());
		assertEquals(true, mostrar.isVisible());
	}

}
