package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;

public class Profesores{
	private int capacidad;
	private int tamano;
	private Profesor[] coleccionProferores;
	
	// Creamos el constructor 
	public Profesores(int capacidad) {
		if(capacidad <1) {
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		}
		this.capacidad = capacidad;
		coleccionProferores = new Profesor[capacidad];
		this.tamano = 0;
	}
	
	//Creamos gert de Profesor (cosntructor copia)
	public Profesor[] get() {
		return copiaProfundaProfesores();
	}
	//creamos copia profunda
	// Creamos copia profunda Aulas
		private Profesor[] copiaProfundaProfesores() throws IllegalArgumentException, NullPointerException {
			Profesor[] copiaProfesores = new Profesor[tamano];
			for (int i = 0; !tamanoSuperado(i); i++) {
				copiaProfesores[i] = new Profesor(coleccionProferores[i]);
			}
			return copiaProfesores;
		}
	//creamos getter y sertter de capacidad y tamano

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
	// cramos Insertar
	public void insertar(Profesor profesor) throws OperationNotSupportedException {
	if(profesor==null) {
		throw new NullPointerException("ERROR: No se puede insertar un profesor nulo.");
	}
	//COn buscar indice sabremos si el profesor ya existe o por lo contrario es nuevo
	int indice = buscarIndice(profesor);
	//Si superamos el indice maximo es que no hay hueco y lanza un error
	if(capacidadSuperada(indice)) {
		throw new OperationNotSupportedException("ERROR: No se aceptan más profesores.");
		
	}else if (tamanoSuperado(indice)) {
		coleccionProferores[indice]=profesor;
		this.tamano++;
	}else {
		throw new OperationNotSupportedException("El profesor ya existe.");
	}
	
	}
	//creamos Buscar Indice
	private int buscarIndice(Profesor Profesor) {
		int indice = 0;
		boolean profesorEncontrado = false;
		while (!tamanoSuperado(indice) && !profesorEncontrado) {
			if (coleccionProferores[indice].equals(Profesor)) {
				profesorEncontrado = true;
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
		// Buscar(Profesor)
		public Profesor buscar(Profesor profesor) throws IllegalArgumentException, NullPointerException {
			if (profesor == null) {
				throw new NullPointerException("ERROR: No se puede buscar un profesor nulo.");
			}
			int indice = buscarIndice(profesor);
			if (tamanoSuperado(indice)) {
				return null;
			} else {
				Profesor profesorBuscado = new Profesor(coleccionProferores[indice]);
				return profesorBuscado;
			}

		}
		// creamos Borrar

		public void borrar(Profesor profesor) throws OperationNotSupportedException {
			if (profesor == null) {
				throw new NullPointerException("ERROR: No se puede borrar un profesor nulo.");
			}
			if (tamanoSuperado(buscarIndice(profesor))) {
				throw new OperationNotSupportedException("ERROR: No existe ningún profesor con ese nombre.");
			} else {
				desplazarUnaPosicionHaciaIzquierda(buscarIndice(profesor));
			}

		}

		private void desplazarUnaPosicionHaciaIzquierda(int posicion) {
			int i;
			for (i = posicion; !tamanoSuperado(i); i++) {
				coleccionProferores[i] = coleccionProferores[i + 1];
			}
			coleccionProferores[i] = null;
			tamano--;
		}
		
		public String[] representar() {
			String[] cadena = new String[tamano];
			for (int i = 0; !tamanoSuperado(i); i++) {
				cadena[i] = coleccionProferores[i].toString();
			}
			return cadena;
		}
}