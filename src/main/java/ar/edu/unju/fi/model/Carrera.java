package ar.edu.unju.fi.model;

public class Carrera {
	private int codigo;
	private String nombre;
	private int cantAnios;
	private String estado;
	
	public Carrera() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", cantAnios=" + cantAnios + ", estado=" + estado
				+ "]";
	}



	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantAnios() {
		return cantAnios;
	}
	public void setCantAnios(int cantAnios) {
		this.cantAnios = cantAnios;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
