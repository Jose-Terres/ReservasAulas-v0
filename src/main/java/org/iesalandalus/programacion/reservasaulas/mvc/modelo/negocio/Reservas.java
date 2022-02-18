package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;
// creamos reservas con los atributos y la clase  reserva
public class Reservas {
	private int capacidad;
	private int tamano;
	private Reserva[] coleccionReservas;
	
	// Creamos el constructor 
	public Reservas(int capacidad) {
		if (capacidad < 1) {
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		}
		this.capacidad = capacidad;
		coleccionReservas = new Reserva[capacidad];
		this.tamano = 0;
	}
	//Creamos gert de Profesor (cosntructor copia)
	public Reserva[] get() {
		return copiaProfundaReservas();
	}
	// creamos copia profunda
	private Reserva[] copiaProfundaReservas() {
		Reserva[] copiaReservas = new Reserva[tamano];
		for (int i = 0; !tamanoSuperado(i); i++) {
			copiaReservas[i] = new Reserva(coleccionReservas[i]);
		}
		return copiaReservas;
	}
	// get tramo y capacidad
	public int getTamano() {
		return tamano;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
// cramos metodo insertar
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");
		}
		// Con buscar indice sabremos si el aula ya exsite o por lo contrario es nueva
		int indice = buscarIndice(reserva);
		// Si superamos el indice máximo es que no hay hueco
		if (capacidadSuperada(indice)) {
			throw new OperationNotSupportedException("ERROR: No se aceptan más reservas.");
		} else if (tamanoSuperado(indice)) {
			coleccionReservas[indice] = reserva;
			this.tamano++;
		} else {
			throw new OperationNotSupportedException("Reserva ya existente");
		}
	}
	// creamos metodo bucarIndice
	private int buscarIndice(Reserva reserva) {
		int indice = 0;
		boolean reservaEncontrada = false;
		while (!tamanoSuperado(indice) && !reservaEncontrada) {
			if (coleccionReservas[indice].equals(reserva)) {
				reservaEncontrada = true;
			} else {
				indice++;
			}
		}
		return indice;
	}
	// creamos tamanoSuperado
	private boolean tamanoSuperado(int indice) {
		return indice >= tamano;
	}
// creamos capacidadSuperada
	private boolean capacidadSuperada(int indice) {
		return indice >= capacidad;
	}
	// creamos buscar
	public Reserva buscar(Reserva reserva) throws IllegalArgumentException, NullPointerException {
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede buscar una reserva nula.");
		}
		int indice = buscarIndice(reserva);
		if (tamanoSuperado(indice)) {
			return null;
		} else {
			return new Reserva(coleccionReservas[indice]);
		}

	}
	// creamos borrar
	public void borrar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");
		}
		if (tamanoSuperado(buscarIndice(reserva))) {
			throw new OperationNotSupportedException("ERROR: No existe ninguna reserva con ese nombre.");
		} else {
			desplazarUnaPosicionHaciaIzquierda(buscarIndice(reserva));
		}

	}
	// creamos desplazarUnaPosicionHaciaIzquierda
	private void desplazarUnaPosicionHaciaIzquierda(int posicion) {
		int i;
		for (i = posicion; !tamanoSuperado(i); i++) {
			coleccionReservas[i] = coleccionReservas[i + 1];
		}
		coleccionReservas[i] = null;
		tamano--;
	}
	// creamos representar
	public String[] representar() {
		String[] cadena = new String[tamano];
		for (int i = 0; !tamanoSuperado(i); i++) {
			cadena[i] = coleccionReservas[i].toString();
		}
		return cadena;
	}
	// getReservasProfesor
	public Reserva[] getReservasProfesor(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException("ERROR: El profesor no puede ser nulo.");
		}
		Reserva[] copiaReservas = new Reserva[capacidad];
		int contador = 0;
		for (int i = 0; !tamanoSuperado(i); i++) {
			if (coleccionReservas[i].getProfesor().equals(profesor)) {
				copiaReservas[contador] = new Reserva(coleccionReservas[i]);
				contador++;
			}
		}
		return copiaReservas;
	}
	// getReservasAula
	public Reserva[] getReservasAula(Aula aula) {
		if (aula == null) {
			throw new NullPointerException("ERROR: El profesor no puede ser nulo.");
		}
		Reserva[] copiaReservas = new Reserva[capacidad];
		int contador = 0;
		for (int i = 0; !tamanoSuperado(i); i++) {
			if (coleccionReservas[i].getAula().equals(aula)) {
				copiaReservas[contador] = new Reserva(coleccionReservas[i]);
				contador++;
			}
		}
		return copiaReservas;
	}
	// Creamos getReservasPermanencia
	public Reserva[] getReservasPermanencia(Permanencia permanecia) {
		if (permanecia == null) {
			throw new NullPointerException("ERROR: El profesor no puede ser nulo.");
		}
		Reserva[] copiaReservas = new Reserva[capacidad];
		int contador = 0;
		for (int i = 0; !tamanoSuperado(i); i++) {
			if (coleccionReservas[i].getPermanencia().equals(permanecia)) {
				copiaReservas[contador] = new Reserva(coleccionReservas[i]);
				contador++;
			}
		}
		return copiaReservas;
	}
	// Creamos consultarDisponibilidad
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede consultar la disponibilidad de un aula nula.");
		} 
		if (permanencia == null) {
			throw new NullPointerException("ERROR: No se puede consultar la disponibilidad de una permanencia nula.");
		}
		Reserva[] reservas = getReservasAula(aula);
		for (Reserva reserva : reservas) {
			if (reserva != null) {
				if (reserva.getPermanencia().equals(permanencia)) {
					return false;
				}
			}
		}
		return true;
	}
}
