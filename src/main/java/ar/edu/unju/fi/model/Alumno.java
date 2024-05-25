package ar.edu.unju.fi.model;

public class Alumno {
	private int DNI;
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	private Date fechNac;
	private String Domicilio;
	private int LU;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	@Override
	public String toString() {
		return "Alumno [DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", Domicilio=" + Domicilio + ", LU=" + LU + "]";
	}






	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
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

	public Date getFechNac() {
		return fechNac;
	}

	public void setFechNac(Date fechNac) {
		this.fechNac = fechNac;
	}

	public String getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}

	public int getLU() {
		return LU;
	}

	public void setLU(int lU) {
		LU = lU;
	}
	
	
	
	
	
	
}
