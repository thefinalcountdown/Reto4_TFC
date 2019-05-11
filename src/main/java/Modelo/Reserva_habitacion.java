package Modelo;

public class Reserva_habitacion
{
	private int num_habitacion;
	private String fecha_entrada;
	private String fecha_salida;
	
	public Reserva_habitacion()
	{
		
	}
	
	public Reserva_habitacion(int num_habitacion, String fecha_entrada, String fecha_salida)
	{
		this.num_habitacion = num_habitacion;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
	}

	public int getNum_habitacion() {
		return num_habitacion;
	}

	public void setNum_habitacion(int num_habitacion) {
		this.num_habitacion = num_habitacion;
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

	@Override
	public String toString() {
		return "N\u00famero de habitaci\u00f3n=" + num_habitacion + " Fecha de entrada=" + fecha_entrada + " Fecha de salida=" + fecha_salida;
	}

}
