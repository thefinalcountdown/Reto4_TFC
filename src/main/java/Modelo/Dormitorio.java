package Modelo;

public class Dormitorio extends Habitaciones {
	
	String cod_Dormi;
	int camaIndividual;
	int camaInfantil;
	int camaMatrimonio;
	
	public Dormitorio(float metrosCuadrados, String RelacionMobiliario, int CamaIndividual, int CamaInfantil, int CamaMatrimonio) {
		super(metrosCuadrados);
		this.cod_Dormi = RelacionMobiliario;
		this.camaIndividual = CamaIndividual;
		this.camaInfantil = CamaInfantil;
		this.camaMatrimonio = CamaMatrimonio;
	}

	public float getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(float metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public String getRelacionMobiliario() {
		return cod_Dormi;
	}

	public void setRelacionMobiliario(String relacionMobiliario) {
		this.cod_Dormi = relacionMobiliario;
	}

	public int getCamaIndividual() {
		return camaIndividual;
	}

	public void setCamaIndividual(int camaIndividual) {
		this.camaIndividual = camaIndividual;
	}
	public int getCamaInfantil() {
		return camaInfantil;
	}

	public void setCamaInfantil(int camaInfantil) {
		this.camaInfantil = camaInfantil;
	}
	public int getCamaMatrimonio() {
		return camaMatrimonio;
	}

	public void setCamaMatrimonio(int camaMatrimonio) {
		this.camaMatrimonio = camaMatrimonio;
	}
	
	@Override
	public String toString() {
		return super.toString()+" "+this.cod_Dormi+" "+this.camaIndividual+" "+this.camaInfantil+" "+this.camaMatrimonio;
		//return "Dormitorio [metros cuadrados=" + metrosCuadrados+ ", relacione mobiliario=" + relacionMobiliario + ", camas disponibles=" + camasDisponibles+"]";
	}
}
