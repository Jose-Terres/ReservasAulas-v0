package org.iesalandalus.programacion.reservasaulas.mvc.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;
// creamos clase consola
public class Consola {

	static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	// constructor
	private  Consola(){
		
	}
	// mostrarMenu
	public static void mostrarMenu() {
		System.out.println("OPCIONES:");
		for (Opcion opcion: Opcion.values()) {
			System.out.println(opcion);
		}
	}
	
	public  static void mostrarCabecera(String mensaje) {
		int longitudmensaje = mensaje.length();
		for (int i = 0; i>longitudmensaje; i++ ) {
			System.out.println("-");
		}
	}
	// opcion que nos da empezaria por 1 al ponerle el -1 en opcion leng asi que ahora tenemos que ponerle tambien -1 a la entrada entero para que conincida con el valor que nso introducen
	public static int elegirOpcion() {
		int opcion;
		do {
			System.out.println("Elige una opción");
			opcion = Entrada.entero() - 1;
		}while (!Opcion.esOrdinalValido(opcion));
		return opcion;
	}
	
	public static Aula leerAula() {
		boolean centinela = false;
		Aula aula= null;
		// NOMBRE
		do {
			try {
				aula = new Aula(leerNombreAula());
				centinela = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}	
		} while (!centinela);
		return aula;
	}
	
	public static String leerNombreAula() {
		System.out.println("introduce el nombre del aula");
		String nombre = Entrada.cadena();
		return nombre;
	}
	
	public static Profesor leerProfesor() {
		boolean centinela = false;
		Profesor profesor = null;
		do {
			try {
				String nombre = leerNombreProfesor();
				System.out.println("Introduce el correo del profesor");
				String correo = Entrada.cadena();
				System.out.println("Introduzca el numero del profesor (Pulse Enter si no desea introducirlo");
				String telefono = Entrada.cadena();
				//validamos siguiendo las indicaciones si nos meten solo nombre y correo es valido 
				if (telefono.trim().equals("")) {
					profesor = new Profesor(nombre, correo);
				} else {
					profesor = new Profesor(nombre, correo, telefono);
				}
				centinela = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!centinela);
		return profesor;
	}
	
	public static String leerNombreProfesor() {
		System.out.println("introduce el nombre del profesor");
		String nombre = Entrada.cadena();
		return nombre;
	}
	
	public static Tramo leerTramo() {
		int opcion = 0;
		do {
			System.out.println("introduce el tramo horarior");
			System.out.println("1 - " + Tramo.MANANA.toString());
			System.out.println("2 - " + Tramo.TARDE.toString());
			System.out.print("ELECCION: ");
			opcion = Entrada.entero();
		} while (opcion != 1 && opcion != 2);
		if (opcion == 1) {
			return Tramo.MANANA;
		} else {
			return Tramo.TARDE;
		}
	}
	
	public static LocalDate leerDia() {
		boolean centinela = false;
		LocalDate fecha = null;
		do {
			System.out.print("Introduce la fecha con formato dd/mm/yyyy: ");
			String cadena = Entrada.cadena();
			fecha = LocalDate.parse(cadena, FORMATO_DIA);
			centinela = true;
		} while (!centinela);
		return fecha;
	}
	
}
