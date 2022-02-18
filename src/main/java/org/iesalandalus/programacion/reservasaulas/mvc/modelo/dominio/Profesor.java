package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

public class Profesor {
	private static final String ER_TELEFONO = "[69][0-9]{8}";
	private static final String ER_CORREO = "([a-zA-z0-9.-_]{1,})(\\@[a-zA-z]{1,})(\\.[a-z]{1,3})";
	private String nombre;
	private String correo;
	private String telefono;

// Creo el contructor por defecto con los datos obligarorios que son nombre correo y telefono
	public Profesor(String nombre, String correo, String telefono) {
		// pedimos los datos con los setter
		setNombre(nombre);
		setCorreo(correo);
		setTelefono(telefono);

	}

// Creo constuctor copia con los dos datos que son obligatorios nombre y telefono
	public Profesor(String nombre, String correo) {
		setNombre(nombre);
		setCorreo(correo);
	}

	// Creo constructor
	public Profesor(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException("ERROR: No se puede copiar un profesor nulo.");
		}
		setNombre(profesor.getNombre());
		setCorreo(profesor.getCorreo());
		setTelefono(profesor.getTelefono());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre del profesor no puede ser nulo.");
		} else if (nombre.trim() == "") {
			throw new IllegalArgumentException("ERROR: El nombre del profesor no puede estar vacío.");
		}
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		if (correo == null) {
			throw new NullPointerException("ERROR: El correo del profesor no puede ser nulo.");
		} else if (correo.trim() == "" || !correo.matches(ER_CORREO)) {
			throw new IllegalArgumentException("ERROR: El correo del profesor no es válido.");
		}
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null) {
			this.telefono = null;
		} else if (telefono.trim() == "" || !telefono.matches(ER_TELEFONO)) {
			throw new IllegalArgumentException("ERROR: El teléfono del profesor no es válido.");
		}
		this.telefono = telefono;
	}

// creamos hashCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Profesor other = (Profesor) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

// Cremos el metodo toString
	@Override
	public String toString() {
		if (telefono == null) {
			return "nombre=" + this.nombre + ", correo=" + this.correo + "";
		} else {
			return "nombre=" + this.nombre + ", correo=" + this.correo + ", telefono=" + this.telefono + "";

		}
	}

}
