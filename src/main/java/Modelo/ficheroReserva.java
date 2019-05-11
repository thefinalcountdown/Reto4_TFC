package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Vista.Ventana;

public class ficheroReserva {

	private int Cod_Hotel;

	private String nombreHotel;
	private float precio;
	private int numPersonas;
	private int numHabitaciones;
	private String ubicacion;
	private String fecha_entrada;
	private String fecha_salida;
	private String DNI;
	private String usuario;
	private static String nombre_fichero;
	
	
	private Ventana ventana;
	private modelo modelo;

	public ficheroReserva(int Cod_Hotel,  String nombreHotel, float precio, int numPersonas, int numHabitaciones, String ubicacion, String fecha_entrada, String fecha_salida,
			String DNI, String usuario) 
	{
		this.Cod_Hotel= Cod_Hotel;

		this.nombreHotel = nombreHotel;
		this.precio = precio;
		this.numPersonas = numPersonas;
		this.numHabitaciones = numHabitaciones;
		this.ubicacion = ubicacion;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.DNI = DNI;
		this.usuario = usuario;
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
	
	

	public int getCod_Hotel() {
		return Cod_Hotel;
	}

	public void setCod_Hotel(int cod_Hotel) {
		Cod_Hotel = cod_Hotel;
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

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static String getNombre_fichero() {
		return nombre_fichero;
	}

	public static void setNombre_fichero(String nombre_fichero) {
		ficheroReserva.nombre_fichero = nombre_fichero;
	}

	public Ventana getVentana() {
		return ventana;
	}

	public void setVentana(Ventana ventana) {
		this.ventana = ventana;
	}

	public modelo getModelo() {
		return modelo;
	}

	public void setModelo(modelo modelo) {
		this.modelo = modelo;
	}

	public void imprimirTicket(String DNI, String alojamiento, String fecha_entrada, String fecha_salida) {
		try {
			// ruta relativa- buscar donde deja el fichero
			// FileWriter fich = new FileWriter(".\\log.txt");

			// ruta absoluta - que pasa si no existe el directorio?
			// FileWriter fich = new FileWriter("C:\\temporal2\\log.txt");

			// nos aseguramos de que existe el directorio, si no es asi
			// lo creamos
			Path path = Paths.get("Ficheros");

			if (!Files.exists(path))
				Files.createDirectory(path);
			
			alojamiento = conversion_espacio_a_guion(alojamiento);
			fecha_entrada = conversion_slash_a_guion(fecha_entrada);
			fecha_salida = conversion_slash_a_guion(fecha_salida);
			nombre_fichero = "Ficheros/"+DNI + "_" + alojamiento + "_" + fecha_entrada + "_" + fecha_salida+".txt";
			File archivo = new File(nombre_fichero);
			
			// Para abrir el fichero sobreescribiendo
			FileWriter fich = new FileWriter(archivo);

			// Para abrir el fichero y anadir al final del mismo
			// FileWriter fich = new FileWriter("C:\\temporal2\\log.txt",true);

			// Que pasa si ejecutamos dos veces seguida el mismo programa
			// Esto es: Se anaden nuevas lineas?
			// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			// Calendar cal = Calendar.getInstance();

			fich.write(" Codigo Hotel: "+this.Cod_Hotel+"\r\n"+" Hotel: " + this.nombreHotel + "\r\n" + " Precio: " + this.precio + "\r\n" 
					+ " Numero de personas: " + this.numPersonas + "\r\n" + " Numero de habitaciones: " + this.numHabitaciones + "\r\n" 
					+ " Ubicacion: " + this.ubicacion + "\r\n" + " Fecha de entrada: " + this.fecha_entrada + "\r\n" + " Fecha de salida: " 
					+ this.fecha_salida + "\r\n" + " DNI del usuario: " + this.DNI + "\r\n" + " Nombre del usuario: " + this.usuario);
			fich.close();

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "No se puede escribir en el archivo porque  "
					+ "no existe y no puede ser creado o no puede ser abierto o es un directorio");
			System.exit(0);

		}
	}
	
	public ArrayList<String> leerTicket()
	{
		ArrayList <String> fichero_texto = new ArrayList<String>();
		ArrayList <String> palabra = new ArrayList<String>();
		
		try
		{
			String linea;
			FileReader fichero = new FileReader(nombre_fichero);
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
	
	public String conversion_espacio_a_guion (String texto)
	{
		texto.replace(' ', '-');
		return texto;
	}
	
	public String conversion_slash_a_guion (String texto)
	{
		texto = texto.replace("/","-");
		return texto;
	}

}
