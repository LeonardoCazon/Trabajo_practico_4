package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Alumno;

public class ListadoDeAlumnos {
	
	public static List<Alumno> alumnos =new ArrayList<Alumno>();
	
	//listar alumnos
	public static List<Alumno> listarAlumnos(){
		return alumnos;
	}
	
	//metodos para buscar por DNI
	public static Alumno buscarAlumnoPorDNI(int busc) {
		for(Alumno a: alumnos) {
			if(a.getDni()==busc) {
				return a;
			}
		}
		return null;
	}
	
	//metodo para agregar
	public static void agregarAlumno(Alumno a) {
		alumnos.add(a);
	}
	
	//metodo para modificar
	  public static void modificarAlumno(Alumno alumnoModificado) {
	    for (int i = 0; i < alumnos.size(); i++) {
	    	Alumno alumno= alumnos.get(i);
	    	
	      if (alumno.getDni()== alumnoModificado.getDni()) {
	        alumnos.set(i, alumnoModificado);
	        break;
	      }
	    }
	  }
	  
	//metodo para eliminar
	public static void eliminarAlumno(int busc){		
		alumnos.removeIf(a->a.getDni()==busc);
	}
	
}
