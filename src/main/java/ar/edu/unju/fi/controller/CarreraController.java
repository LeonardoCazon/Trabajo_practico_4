package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDeCarreras;
import ar.edu.unju.fi.model.Carrera;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CarreraController {
	
	@Autowired
	Carrera nuevaCarrera = new Carrera();
	
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		//vista del formulario Carrera en html
		ModelAndView MV = new ModelAndView("formCarrera");
		
		//agrega el objeto
		MV.addObject("nuevaCarrera", nuevaCarrera);
		MV.addObject("band", false);
		return MV;
	}
	
	@GetMapping("/listadoTCarreras")
	public ModelAndView getlist() {
		// mostrar el listado
		ModelAndView MV = new ModelAndView("listaCarrera");
		MV.addObject("listadoDeCarreras", ListadoDeCarreras.listarCarreras());

		return MV;
	}
	
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") Carrera CarreraParaGuardar) {
		//guardar
		ListadoDeCarreras.agregarCarrera(CarreraParaGuardar);
		
		//mostrar el listado
		ModelAndView MV = new ModelAndView("listaCarrera");
		MV.addObject("listadoDeCarreras",ListadoDeCarreras.listarCarreras());
		
		return MV;
	}
	
	@GetMapping("/borrarCarrera/{codigo}")
	public static ModelAndView deleteCarrera(@PathVariable(name="codigo")String codigo) {
		//borrar
		ListadoDeCarreras.eliminarCarrera(codigo);
		
		//mostrar el nuevo listado
		ModelAndView MV=new ModelAndView("listaCarrera");
		MV.addObject("listadoDeCarreras", ListadoDeCarreras.listarCarreras());
		
		return MV;
	}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView editCarrera(@PathVariable(name="codigo") String codigo) {
		//buscar
		Carrera carreraParaModificar = ListadoDeCarreras.buscarCarreraPorCodigo(codigo);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", carreraParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
	}
	
	@PostMapping("/modificarCarrera")
	public ModelAndView updateCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraModificada) {
					
		//guardar
		ListadoDeCarreras.modificarCarrera(carreraModificada);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaCarrera");
		modelView.addObject("listadoDeCarreras", ListadoDeCarreras.listarCarreras());	
		
		return modelView;		
	}
	
	
}
