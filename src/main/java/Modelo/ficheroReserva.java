package Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class ficheroReserva {

	private int numPersonas;
	private String nombreHotel;
	private String ubicacion;
	private float precio;

	public ficheroReserva(int numPersonas, String nombreHotel, String ubicacion, float precio) {
		this.numPersonas = numPersonas;
		this.nombreHotel = nombreHotel;
		this.ubicacion = ubicacion;
		this.precio = precio;
	}

	public ficheroReserva() {

	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void imprimirTicket() {
		try {
			// ruta relativa- buscar donde deja el fichero
			// FileWriter fich = new FileWriter(".\\log.txt");

			// ruta absoluta - que pasa si no existe el directorio?
			// FileWriter fich = new FileWriter("C:\\temporal2\\log.txt");

			// nos aseguramos de que existe el directorio, si no es asi
			// lo creamos
			Path path = Paths.get("c:\\TemporalReto");

			if (!Files.exists(path))
				Files.createDirectory(path);

			// Para abrir el fichero sobreescribiendo
			FileWriter fich = new FileWriter("C:\\TemporalReto\\ficheroReserva.txt");

			// Para abrir el fichero y anadir al final del mismo
			// FileWriter fich = new FileWriter("C:\\temporal2\\log.txt",true);

			// Que pasa si ejecutamos dos veces seguida el mismo programa
			// Esto es: Se anaden nuevas lineas?
			// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			// Calendar cal = Calendar.getInstance();

			fich.write(" Hotel: " + this.nombreHotel + "\r\n" + " Numero de personas: " + this.numPersonas + "\r\n"
					+ " Ubicacion: " + this.ubicacion + "\r\n" + " Precio: " + this.precio + "\r\n");

			fich.close();

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "No se puede escribir en el archivo porque  "
					+ "no existe y no puede ser creado o no puede ser abierto o es un directorio");

		}

	}

}
