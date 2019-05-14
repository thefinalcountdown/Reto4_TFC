package Modelo;
import java.time.LocalDate;

public class TemporadaAlta {
	
	private LocalDate inicio;
	private LocalDate fin;
	
	public TemporadaAlta(LocalDate inicio, LocalDate fin) {
		this.inicio = inicio;
		this.fin = fin;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

}

