package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDeCarreras;
import ar.edu.unju.fi.collections.ListadoDeDocentes;
import ar.edu.unju.fi.collections.ListadoDeMaterias;
import ar.edu.unju.fi.model.Materia;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MateriaController {
	
	@Autowired
	Materia nuevaMateria = new Materia();
	
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		//vista del formulario
		ModelAndView MV = new ModelAndView("formMateria");
		
		
		//agrega el objeto
		MV.addObject("nuevaMateria", nuevaMateria);
		MV.addObject("listadoDeDocentes", ListadoDeDocentes.listarDocentes());
		MV.addObject("listadoDeCarreras", ListadoDeCarreras.listarCarreras());
		MV.addObject("band", false);
		return MV;
	}
	
	@GetMapping("/listadoTMaterias")
	public ModelAndView getlist() {
		// mostrar el listado
		ModelAndView MV = new ModelAndView("listaMateria");
		MV.addObject("listadoDeMaterias", ListadoDeMaterias.listarMaterias());

		return MV;
	}
	
	

  @PostMapping("/guardarMateria") public ModelAndView
  saveMateria(@ModelAttribute("nuevaMateria") Materia MateriaParaGuardar) {
	  //guardar 
	  ListadoDeMaterias.agregarMateria(MateriaParaGuardar);
  
	  //mostrar el listado 
	  ModelAndView MV = new ModelAndView("listaMateria");
	  MV.addObject("listadoDeMaterias",ListadoDeMaterias.listarMaterias());
  
	  return MV;
  
  
  
  }
 
	
	@GetMapping("/borrarMateria/{codigo}")
	public static ModelAndView deleteMateria(@PathVariable(name="codigo")String codigo) {
		//borrar
		ListadoDeMaterias.eliminarMateria(codigo);
		
		//mostrar el nuevo listado
		ModelAndView MV=new ModelAndView("listaMateria");
		MV.addObject("listadoDeMaterias", ListadoDeMaterias.listarMaterias());
		
		return MV;
	}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView editMateria(@PathVariable(name="codigo") String codigo) {
		//buscar
		Materia materiaParaModificar = ListadoDeMaterias.buscarMateriaPorCodigo(codigo);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", materiaParaModificar);	
		modelView.addObject("listadoDeDocentes", ListadoDeDocentes.listarDocentes());
		modelView.addObject("listadoDeCarreras", ListadoDeCarreras.listarCarreras());
		modelView.addObject("band", true);
		return modelView;		
	}
	
	@PostMapping("/modificarMateria")
	public ModelAndView updateCarrera(@ModelAttribute("nuevaMateria") Materia materiaModificada) {
					
		//guardar
		ListadoDeMaterias.modificarMateria(materiaModificada);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaMateria");
		modelView.addObject("listadoDeMaterias", ListadoDeMaterias.listarMaterias());	
		
		return modelView;		
	}
	
	
}