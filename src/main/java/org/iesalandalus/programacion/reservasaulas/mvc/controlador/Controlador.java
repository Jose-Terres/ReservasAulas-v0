package org.iesalandalus.programacion.reservasaulas.mvc.controlador;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.Modelo;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.*;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.Vista;
// creamos clse controlador cons los atributos
public class Controlador {

	Vista vista;
	Modelo modelo;
// constructor
	public Controlador(Modelo modelo, Vista vista) {
		if (modelo == null) {
			throw new IllegalArgumentException("ERROR: El modelo no puede ser nulo.");
		}
		if (vista == null) {
			throw new IllegalArgumentException("ERROR: La vista no puede ser nula.");
		}
		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);
	}
// cremaos comenzar
	public void comenzar() {
		vista.comenzar();
	}
// creamso terminal
	public void terminar() {
		System.out.println("¡ADIOS!");
	}
// creamos insertarAula
	public void insertarAula(Aula aula) throws OperationNotSupportedException {
		modelo.insertarAula(aula);
	}
// creamos insertarProfesor
	public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
		modelo.insertarProfesor(profesor);
	}
// creamos borrarAula
	public void borrarAula(Aula aula) throws OperationNotSupportedException {
		modelo.borrarAula(aula);
	}
	// creamos borrarProfesor
	public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
		modelo.borrarProfesor(profesor);
	}
	// creamos buscarAula
	public Aula buscarAula(Aula aula) {
		return modelo.buscarAula(aula);
	}
	// creamos buscarProfesor
	public Profesor buscarProfesor(Profesor profesor) {
		return modelo.buscarProfesor(profesor);
	}
	// creamos representarAulas
	public String[] representarAulas() {
		return modelo.representarAulas();
	}
	// creamos representarProfesor 
	public String[] representarProfesores() {
		return modelo.representarProfesores();
	}
	// creamosrepresentarReservas
	public String[] representarReservas() {
		return modelo.representarReservas();
	}
	// creamos realizarReserva
	public void realizarReserva(Reserva reserva) throws OperationNotSupportedException {
		modelo.realizarReserva(reserva);
	}
	//creamos anularReserva
	public void anularReserva(Reserva reserva) throws OperationNotSupportedException {
		modelo.anularReserva(reserva);
	}
	
	public Reserva[] getReservasAula(Aula aula) {
		return modelo.getReservaAula(aula);
	}
	
	public Reserva[] getReservasProfesor(Profesor profesor) {
		return modelo.getReservasProfesor(profesor);
	}
	
	public Reserva[] getReservasPermanencia(Permanencia permanencia) {
		return modelo.getReservasPermanencia(permanencia);
	}
	
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanecia) {
		return modelo.consultarDisponibilidad(aula, permanecia);
	}
}

