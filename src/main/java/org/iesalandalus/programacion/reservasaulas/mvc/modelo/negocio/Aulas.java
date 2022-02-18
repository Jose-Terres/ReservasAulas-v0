package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;

public class Aulas {
	private int capacidad;
	private int tamano;
	private Aula[] coleccionAulas;

	// Creamos constructor
	// el cosntructor lanza tipos de excpcion illegal y null
	public Aulas(int capacidad) throws IllegalArgumentException, NullPointerException {

		if (capacidad < 1) {
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		}
		this.capacidad = capacidad;
		coleccionAulas = new Aula[capacidad];
		this.tamano = 0;
	}

	// Creamos get de Aula (constructor copia)
	public Aula[] get() {
		return copiaProfundaAulas();
	}

	// Creamos copia profunda Aulas
	private Aula[] copiaProfundaAulas() throws IllegalArgumentException, NullPointerException {
		Aula[] copiaAulas = new Aula[tamano];
		for (int i = 0; !tamanoSuperado(i); i++) {
			copiaAulas[i] = new Aula(coleccionAulas[i]);
		}
		return copiaAulas;
	}

	// Creamos getter y setter de capacidad y tamano
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	// Creamos Insertar

	public void insertar(Aula aula) throws OperationNotSupportedException {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede insertar un aula nula.");
		}
		// Con buscar indice sabremos si el aula ya exsite o por lo contrario es nueva
		int indice = buscarIndice(aula);
		// Si superamos el indice máximo es que no hay hueco
		if (capacidadSuperada(indice)) {
			throw new OperationNotSupportedException("ERROR: No se aceptan más aulas.");
		} else if (tamanoSuperado(indice)) {
			coleccionAulas[indice] = aula;
			this.tamano++;
		} else {
			throw new OperationNotSupportedException("Aula ya existente");
		}

	}

	// Creamos Buscar Indice
	private int buscarIndice(Aula Aula) {
		int indice = 0;
		boolean aulaEncontrada = false;
		while (!tamanoSuperado(indice) && !aulaEncontrada) {
			if (coleccionAulas[indice].equals(Aula)) {
				aulaEncontrada = true;
			} else {
				indice++;
			}
		}
		return indice;
	}

	// Tamanio Superado
	private boolean tamanoSuperado(int indice) {
		return indice >= tamano;
	}

	// Capacidad Superada
	private boolean capacidadSuperada(int indice) {
		return indice >= capacidad;
	}

	// Buscar(Aula)
	public Aula buscar(Aula aula) throws IllegalArgumentException, NullPointerException {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede buscar un aula nula.");
		}
		int indice = buscarIndice(aula);
		if (tamanoSuperado(indice)) {
			return null;
		} else {
			Aula aulaBuscado = new Aula(coleccionAulas[indice]);
			return aulaBuscado;
		}

	}

	// creamos Borrar

	public void borrar(Aula aula) throws OperationNotSupportedException {
		if (aula == null) {
			throw new NullPointerException("ERROR: No se puede borrar un aula nula.");
		}
		if (tamanoSuperado(buscarIndice(aula))) {
			throw new OperationNotSupportedException("ERROR: No existe ningún aula con ese nombre.");
		} else {
			desplazarUnaPosicionHaciaIzquierda(buscarIndice(aula));
		}

	}

	private void desplazarUnaPosicionHaciaIzquierda(int posicion) {
		int i;
		for (i = posicion; !tamanoSuperado(i); i++) {
			coleccionAulas[i] = coleccionAulas[i + 1];
		}
		coleccionAulas[i] = null;
		tamano--;
	}
	
	public String[] representar() {
		String[] cadena = new String[tamano];
		for (int i = 0; !tamanoSuperado(i); i++) {
			cadena[i] = coleccionAulas[i].toString();
		}
		return cadena;
	}
	
	
}
