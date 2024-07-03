package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	private String codigo;
	private String nombre;
	private String curso;
	private int cantHoras;
	private String modalidad;
	private Docente docente;
	private Carrera carrera;
	private Boolean estado;
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}
	

	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public Materia(String codigo, String nombre, String curso, int cantHoras, String modalidad, Docente docente,
			Carrera carrera, Boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantHoras = cantHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Materia [codigo=" + codigo + ", nombre=" + nombre + ", curso=" + curso + ", cantHoras=" + cantHoras
				+ ", modalidad=" + modalidad + ", docente=" + docente + ", carrera=" + carrera + ", estado=" + estado
				+ "]";
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	
}
