package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Docente;



public class ListadoDeDocentes {
	
	public static List<Docente> docentes =new ArrayList<Docente>();
	
	//metodos para listar doncentes
	
	public static List<Docente> listarDocentes(){
		return docentes;
	}
	
	//metodos para buscar
	public static Docente buscarDocentePorlegajo(int busc) {
		for(Docente d:docentes) {
			if(d.getLegajo()==busc) {
				return d;
			}
		}
		return null;
	}
	
	//metodo para agregar 
	public static void agregarDocente(Docente d) {
		docentes.add(d);
	}
	
	//metodo para modificar
	  public static void modificarDocente(Docente docenteModificado) {
	    for (int i = 0; i < docentes.size(); i++) {
	    	Docente docente = docentes.get(i);
	      if (docente.getLegajo()== docenteModificado.getLegajo()) {
	        docentes.set(i, docenteModificado);
	        break;
	      }
	    }
	  }

	  
	//metodo para eliminar 
	public static void eliminarDocente(int busc){
		docentes.removeIf(d->d.getLegajo()== busc);
	}
	
}
