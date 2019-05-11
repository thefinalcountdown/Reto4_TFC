package Modelo;

public class Dormitorio extends Habitacion {

	private int camaIndividual;
	private int camaInfantil;
	private int camaMatrimonio;

	public Dormitorio(String cod_habitacion, float metrosCuadrados, String tipo, String descripcion, float precio,
			int camaIndividual, int camaInfantil, int camaMatrimonio) {
		super(cod_habitacion, metrosCuadrados, descripcion, tipo, precio);

		this.camaIndividual = camaIndividual;
		this.camaInfantil = camaInfantil;
		this.camaMatrimonio = camaMatrimonio;
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
		return "Dormitorio [, camaIndividual=" + camaIndividual + ", camaInfantil=" + camaInfantil + ", camaMatrimonio="
				+ camaMatrimonio + "]";
	}

}
