package Modelo;

public class Servicios 
{
	private String tipo_servicio;
	private boolean servicio_elegido;
	
	public Servicios()
	{
		
	}
	
	public Servicios(String tipo_servicio, boolean servicio_elegido)
	{
		this.tipo_servicio = tipo_servicio;
		this.servicio_elegido = servicio_elegido;
	}

	public String getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public boolean isServicio_elegido() {
		return servicio_elegido;
	}

	public void setServicio_elegido(boolean servicio_elegido) {
		this.servicio_elegido = servicio_elegido;
	}

	@Override
	public String toString() {
		if (servicio_elegido == true)
		{
			return "Tipo de servicio=" + tipo_servicio + " Servicio elegido = Si";
		}
		else
		{
			return "Tipo de servicio=" + tipo_servicio + " Servicio elegido = No";
		}
		
	}
	
	
}
