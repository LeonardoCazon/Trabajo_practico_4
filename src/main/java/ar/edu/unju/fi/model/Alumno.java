package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Alumno {
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	private LocalDate fechNac;
	private String domicilio;
	private int lu;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Alumno [DNI=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", Domicilio=" + domicilio + ", LU=" + lu + "]";
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechNac() {
		return fechNac;
	}

	public void setFechNac(LocalDate fechNac) {
		this.fechNac = fechNac;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getLu() {
		return lu;
	}

	public void setLu(int lu) {
		this.lu = lu;
	}
	
	
}
