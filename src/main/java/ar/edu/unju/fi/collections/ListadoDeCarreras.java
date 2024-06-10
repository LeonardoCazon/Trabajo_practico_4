package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Carrera;

public class ListadoDeCarreras {
	
	public static List<Carrera> carreras =new ArrayList<Carrera>();
	
	//metodos para listar
	public static List<Carrera> listarCarreras(){
		List<Carrera> carrerasFiltradas=carreras.stream().filter(carrera -> carrera.isEstado()).collect(Collectors.toList());
		
		return carrerasFiltradas;
	}
	
	public static List<Carrera> listarTodasLasCarreras(){
		return carreras;
	}
	
	//metodos para buscar
	public static Carrera buscarCarreraPorCodigo(String cod) {
		for(Carrera c:carreras) {
			if(c.getCodigo().equals(cod)) {
				return c;
			}
		}
		return null;
	}
	
	//metodo para agregar
	public static void agregarCarrera(Carrera c) {
		c.setEstado(true);
		carreras.add(c);
	}
	
	//metodo para modificar
	  public static void modificarCarrera(Carrera carreraModificada) {
		  carreraModificada.setEstado(true);
	    for (int i = 0; i < carreras.size(); i++) {
	      Carrera carrera = carreras.get(i);
	      if (carrera.getCodigo().equals(carreraModificada.getCodigo())) {
	        carreras.set(i, carreraModificada);
	        break;
	      }
	    }
	  }
		/*
		 * public static void modificarCarrera(Carrera cModif) {
		 * carreras.stream().filter(c->c.getCodigo().equals(cModif.getCodigo())).
		 * findFirst().ifPresent(c -> { int i = carreras.indexOf(c); carreras.set(i,
		 * cModif); }); }
		 */
	

	  
	//metodo para eliminar 
	public static void eliminarCarrera(String cod){
		
		carreras.removeIf(c->c.getCodigo().equals(cod));
		
		/*
		 * for (int i = 0; i < carreras.size(); i++) { Carrera carrera =
		 * carreras.get(i); if (carrera.getCodigo().equals(cod)) {
		 * carrera.setEstado(false); break; } }
		 */
		
	}
	
}
