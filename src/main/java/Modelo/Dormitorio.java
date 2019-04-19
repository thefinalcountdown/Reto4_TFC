package Modelo;

public class Dormitorio extends Habitaciones {
	
	String relacionMobiliario;
	int camasDisponibles;
	
	public Dormitorio(float metrosCuadrados, String RelacionMobiliario, int CamasDisponibles) {
		super(metrosCuadrados);
		this.relacionMobiliario = RelacionMobiliario;
		this.camasDisponibles = CamasDisponibles;
	}

	public float getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(float metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public String getRealcionMobiliario() {
		return relacionMobiliario;
	}

	public void setRealcionMobiliario(String realcionMobiliario) {
		this.relacionMobiliario = realcionMobiliario;
	}

	public int getCamasDisponibles() {
		return camasDisponibles;
	}

	public void setCamasDisponibles(int camasDisponibles) {
		this.camasDisponibles = camasDisponibles;
	}
	
	@Override
	public String toString() {
		return super.toString()+" "+this.relacionMobiliario+" "+this.camasDisponibles;
		//return "Dormitorio [metros cuadrados=" + metrosCuadrados+ ", relacione mobiliario=" + relacionMobiliario + ", camas disponibles=" + camasDisponibles+"]";
	}
}
