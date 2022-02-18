package org.iesalandalus.programacion.reservasaulas.mvc.modelo;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.*;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.*;

public class Modelo {
	// creamos la clase y le asignamos los atributos, en cantidad constante  le pongo 10 
		private static int CANTIDAD = 10;
		private Profesores profesores;
		private Aulas aulas;
		private Reservas reservas;
		
		public Modelo() {
			profesores = new Profesores(CANTIDAD);
			aulas = new Aulas(CANTIDAD);
			reservas = new Reservas(CANTIDAD);
		}
		// llamamos a los metos que nos indica en el diagrama de clases
		public Aula[] getAulas() {
			return aulas.get();
		}
		// llamamos a getNumAulas
		public int getNumAulas() {
			return getAulas().length;
		}
		
		public String[] representarAulas() {
			return aulas.representar();
		}
		
		public Aula buscarAula(Aula aula) {
			return aulas.buscar(aula);
		}
		
		public void insertarAula(Aula aula) throws OperationNotSupportedException {
			aulas.insertar(aula);
		}
		
		public void borrarAula(Aula aula) throws OperationNotSupportedException {
			aulas.borrar(aula);
		}
		
		public Profesor[] getProfesores() {
			return profesores.get();
		}
		
		public int getNumProfesores() {
			return getProfesores().length;
		}
		
		public String[] representarProfesores() {
			return profesores.representar();
		}
		
		public Profesor buscarProfesor(Profesor profesor) {
			return profesores.buscar(profesor);
		}
		
		public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
			profesores.insertar(profesor);
		}
		
		public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
			profesores.borrar(profesor);
		}
		
		public Reserva[] getReservas() {
			return reservas.get();
		}
		
		public int getNumReservas() {
			return getReservas().length;
		}
		
		public String[] representarReservas() {
			return reservas.representar();
		}
		
		public Reserva buscarReserva(Reserva reserva) {
			return reservas.buscar(reserva);
		}
		
		public void realizarReserva(Reserva reserva) throws OperationNotSupportedException {
			reservas.insertar(reserva);
		}
		
		public void anularReserva(Reserva reserva) throws OperationNotSupportedException {
			reservas.borrar(reserva);
		}
		
		public Reserva[] getReservaAula(Aula aula) {
			return reservas.getReservasAula(aula);
		}
		
		public Reserva[] getReservasProfesor(Profesor profesor) {
			return reservas.getReservasProfesor(profesor);
		}
		
		public Reserva[] getReservasPermanencia(Permanencia permanencia) {
			return reservas.getReservasPermanencia(permanencia);
		}
		
		public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
			return reservas.consultarDisponibilidad(aula, permanencia);
		}
}
