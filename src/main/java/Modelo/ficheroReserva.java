package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ficheroReserva {

	private String DNIusuario;
	private String nombreUsuario;
	private String nombreHotel;
	private float precio;
	private int numPersonas;
	private int numHabitaciones;
	private String ubicacion;
	private String fecha_entrada;
	private String fecha_salida;
	

	public ficheroReserva(String DNIusuario, String nombreUsuario, String nombreHotel, float precio, int numPersonas, 
			int numHabitaciones, String ubicacion, String fecha_entrada, String fecha_salida) 
	{
		this.DNIusuario = DNIusuario;
		this.nombreUsuario = nombreUsuario;
		this.nombreHotel = nombreHotel;
		this.precio = precio;
		this.numPersonas = numPersonas;
		this.numHabitaciones = numHabitaciones;
		this.ubicacion = ubicacion;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
	}

	public ficheroReserva() {

	}
	
	public String getDNIusuario() {
		return DNIusuario;
	}

	public void setDNIusuario(String dNIusuario) {
		DNIusuario = dNIusuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public String getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public String getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
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
			Path path = Paths.get("Reto4_TFC");

			if (!Files.exists(path))
				Files.createDirectory(path);

			// Para abrir el fichero sobreescribiendo
			FileWriter fich = new FileWriter("Reto4_TFC\\ficheroReserva.txt");

			// Para abrir el fichero y anadir al final del mismo
			// FileWriter fich = new FileWriter("C:\\temporal2\\log.txt",true);

			// Que pasa si ejecutamos dos veces seguida el mismo programa
			// Esto es: Se anaden nuevas lineas?
			// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			// Calendar cal = Calendar.getInstance();

			fich.write(" DNI usuario: " + this.DNIusuario + "\r\n" + " Nombre de usuario: "+ this.nombreUsuario + "\r\n" + " Hotel: " + this.nombreHotel 
					+ "\r\n" + " Precio: " + this.precio + "\r\n" + " Numero de personas: " + this.numPersonas + "\r\n" + " Numero de habitaciones: " 
					+ this.numHabitaciones + "\r\n" + " Ubicacion: " + this.ubicacion + "\r\n" + " Fecha de entrada: "
					+ this.fecha_entrada + "\r\n" + " Fecha de salida: " + this.fecha_salida);
			fich.close();

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "No se puede escribir en el archivo porque  "
					+ "no existe y no puede ser creado o no puede ser abierto o es un directorio");

		}
	}
	
	public static ArrayList<String> leerTicket()
	{
		ArrayList <String> fichero_texto = new ArrayList<String>();
		ArrayList <String> palabra = new ArrayList<String>();
		
		try
		{
			String linea;
			FileReader fichero = new FileReader("Reto4_TFC\\ficheroReserva.txt");
			BufferedReader buf = new BufferedReader(fichero);
			
			
			while ((linea = buf.readLine()) != null)
			{
				fichero_texto.add(linea);
			}
			
			for(int cont=0; cont < fichero_texto.size(); cont++)
			{
				int posicion = fichero_texto.size() - cont - 1;
				String [] partes = fichero_texto.get(cont).split(": ");
				palabra.add(partes[1]);
			}
			
			
			buf.close();
			fichero.close();
		}
		catch(IOException ex)
		{
			JOptionPane.showMessageDialog(null, "No se pudo leer el archivo");
		   	 System.exit(-1);
		}
		
		return palabra;
	}

}
