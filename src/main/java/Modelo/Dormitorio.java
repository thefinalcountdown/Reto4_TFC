package Modelo;

public class Dormitorio extends Habitaciones {
	
	private int num_habitacion;
	private String cod_dormitorio;
	private int camaIndividual;
	private int camaInfantil;
	private int camaMatrimonio;
	
	
	public Dormitorio(int num_habitacion, String cod_dormitorio, float metrosCuadrados, int camaIndividual, int camaInfantil, int camaMatrimonio) {
		super(metrosCuadrados);
		this.num_habitacion = num_habitacion;
		this.cod_dormitorio = cod_dormitorio;
		this.camaIndividual = camaIndividual;
		this.camaInfantil = camaInfantil;
		this.camaMatrimonio = camaMatrimonio;
	}

	
	public int getNum_habitacion() {
		return num_habitacion;
	}



	public void setNum_habitacion(int num_habitacion) {
		this.num_habitacion = num_habitacion;
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
		return "Dormitorio [num_habitacion=" + num_habitacion + ", cod_dormitorio=" + cod_dormitorio
				+ ", camaIndividual=" + camaIndividual + ", camaInfantil=" + camaInfantil + ", camaMatrimonio="
				+ camaMatrimonio + "]";
	}
	
	

}
