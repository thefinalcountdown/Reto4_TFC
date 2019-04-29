package Modelo;

public class Dormitorio extends Habitaciones {
	
	String cod_dormitorio;
	int camaIndividual;
	int camaInfantil;
	int camaMatrimonio;
	
	
	public Dormitorio(String cod_dormitorio, float metrosCuadrados, int camaIndividual, int camaInfantil, int camaMatrimonio) {
		super(metrosCuadrados);
		this.cod_dormitorio = cod_dormitorio;
		this.camaIndividual = camaIndividual;
		this.camaInfantil = camaInfantil;
		this.camaMatrimonio = camaMatrimonio;
	}

	public String getCod_dormitorio() {
		return cod_dormitorio;
	}


	public void setCod_dormitorio(String cod_dormitorio) {
		this.cod_dormitorio = cod_dormitorio;
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
		return "Dormitorio [cod_dormitorio=" + cod_dormitorio + ", camaIndividual="
				+ camaIndividual + ", camaInfantil=" + camaInfantil + ", camaMatrimonio=" + camaMatrimonio + "]";
	}

}
