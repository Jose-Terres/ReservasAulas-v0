package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

public class Reserva {

	// los atributos serian los objetos a los que señalan las flechas que son
	// Permanencia Profesor y Aula
	private Profesor profesor;
	private Aula aula;
	private Permanencia permanencia;

	// creamos constructor con tres parametros
	public Reserva(Profesor profesor, Aula aula, Permanencia permanencia) {
		setProfesor(profesor);
		setAula(aula);
		setPermanencia(permanencia);
	}

	// Creamos constructor copia
	public Reserva(Reserva reserva) {
		// comprobamos que no sea null y si lo es lanzamos mensaje de error
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede copiar una reserva nula.");
		} else {
			// si no es null entonces pedimos los datos con set
			setPermanencia(reserva.getPermanencia());
			setProfesor(reserva.getProfesor());
			setAula(reserva.getAula());
		}
	}

	// creamos getter y seters
	public Permanencia getPermanencia() {
		return permanencia;
	}

	public void setPermanencia(Permanencia permanencia) {
		if (permanencia == null) {
			throw new NullPointerException("ERROR: La reserva se debe hacer para una permanencia concreta.");
		}
		this.permanencia = new Permanencia(permanencia.getDia(), permanencia.getTramo());
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException("ERROR: La reserva debe estar a nombre de un profesor.");
		}
		this.profesor = profesor;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		if (aula == null) {
			throw new NullPointerException("ERROR: La reserva debe ser para un aula concreta.");
		}
		this.aula = new Aula(aula.getNombre());
	}

	// creamos hasCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((permanencia == null) ? 0 : permanencia.hashCode());
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
		Reserva other = (Reserva) obj;
		if (aula == null) {
			if (other.aula != null)
				return false;
		} else if (!aula.equals(other.aula))
			return false;
		if (permanencia == null) {
			if (other.permanencia != null)
				return false;
		} else if (!permanencia.equals(other.permanencia))
			return false;
		return true;
	}

	// creamos toString
	@Override
	public String toString() {
		return "Profesor=" + profesor + ", aula=" + aula + ", permanencia=" + permanencia + "";
	}

}
