package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Permanencia {
	// cremos los atributos
	private LocalDate dia;
	private Tramo tramo; // este atributo lo traemos de tramo
	static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Creamos constructor e ingresamos los datos con los set
	public Permanencia(LocalDate dia, Tramo tramo) {
		setDia(dia);
		setTramo(tramo);
	}

	// Cremos el constructor copia
	public Permanencia(Permanencia permanencia) {
		if (permanencia == null) {
			throw new NullPointerException("ERROR: No se puede copiar una permanencia nula.");
		} else {
			setDia(permanencia.getDia());
			setTramo(permanencia.getTramo());
		}
	}

	// Creamps los getters y setters
	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		if (dia == null) {
			throw new NullPointerException("ERROR: El día de una permanencia no puede ser nulo.");
		} else {
			this.dia = dia;
		}
	}

	public Tramo getTramo() {
		return tramo;
	}

	public void setTramo(Tramo tramo) {
		if (tramo == null) {
			throw new NullPointerException("ERROR: El tramo de una permanencia no puede ser nulo.");
		} else {
			this.tramo = tramo;
		}
	}

	// Creamos hashCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((tramo == null) ? 0 : tramo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permanencia other = (Permanencia) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (tramo != other.tramo)
			return false;
		return true;
	}

	// creamos metodo toString
	@Override
	public String toString() {
		return "dia=" +this.dia.format(FORMATO_DIA) + ", tramo=" + tramo + "";
	}

}
