package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Materia;


public class ListadoDeMaterias {
	
	public static List<Materia> materias =new ArrayList<Materia>();
	
	//metodos para listar
	public static List<Materia> listarMaterias(){
		return materias;
	}
	
	//metodos para buscar
	public static Materia buscarMateriaPorCodigo(String cod) {
		for(Materia m:materias) {
			if(m.getCodigo().equals(cod)) {
				return m;
			}
		}
		return null;
	}
	
	//metodo para agregar
	public static void agregarMateria(Materia m) {
		m.setEstado(true);
		
		  int legajoDocente = m.getDocente().getLegajo(); 
		  String codigoCarrera = m.getCarrera().getCodigo();
		  
		  m.setDocente(ListadoDeDocentes.buscarDocentePorlegajo(legajoDocente));
		  m.setCarrera(ListadoDeCarreras.buscarCarreraPorCodigo(codigoCarrera));
		 
		materias.add(m);
	}
	
	//metodo para modificar
	  public static void modificarMateria(Materia materiaModificada) {
		  int legajoDocente = materiaModificada.getDocente().getLegajo(); 
		  String codigoCarrera = materiaModificada.getCarrera().getCodigo();
		  
		  materiaModificada.setDocente(ListadoDeDocentes.buscarDocentePorlegajo(legajoDocente));
		  materiaModificada.setCarrera(ListadoDeCarreras.buscarCarreraPorCodigo(codigoCarrera));
	    for (int i = 0; i < materias.size(); i++) {
	    	Materia materia = materias.get(i);
	      if (materia.getCodigo().equals(materiaModificada.getCodigo())) {
	        materias.set(i, materiaModificada);
	        break;
	      }
	    }
	  }

	  
	//metodo para eliminar 
	public static void eliminarMateria(String cod){
		materias.removeIf(m->m.getCodigo().equals(cod));
	}
	
}
