package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDeDocentes;
import ar.edu.unju.fi.model.Docente;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DocenteController {
	
	@Autowired
	Docente nuevoDocente = new Docente();
	
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		//vista del formulario
		ModelAndView MV = new ModelAndView("formDocente");
		
		//agrega el objeto
		MV.addObject("nuevoDocente", nuevoDocente);
		MV.addObject("band", false);
		return MV;
	}
	
	@GetMapping("/listadoTDocentes")
	public ModelAndView getlist() {
		// mostrar el listado
		ModelAndView MV = new ModelAndView("listaDocente");
		MV.addObject("listadoDeDocentes", ListadoDeDocentes.listarDocentes());
		return MV;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") Docente docenteParaGuardar) {
		//guardar
		ListadoDeDocentes.agregarDocente(docenteParaGuardar);
		
		//mostrar el listado
		ModelAndView MV = new ModelAndView("listaDocente");
		MV.addObject("listadoDeDocentes",ListadoDeDocentes.listarDocentes());
		
		return MV;
	}
	
	@GetMapping("/borrarDocente/{legajo}")
	public static ModelAndView deleteDocente(@PathVariable(name="legajo")int legajo) {
		//borrar
		ListadoDeDocentes.eliminarDocente(legajo);
		
		//mostrar el nuevo listado
		ModelAndView MV=new ModelAndView("listaDocente");
		MV.addObject("listadoDeDocentes", ListadoDeDocentes.listarDocentes());
		
		return MV;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView editDocente(@PathVariable(name="legajo") int legajo) {
		//buscar
		Docente docenteParaModificar = ListadoDeDocentes.buscarDocentePorlegajo(legajo);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", docenteParaModificar);	
		modelView.addObject("band", true);
		return modelView;		
	}
	
	@PostMapping("/modificarDocente")
	public ModelAndView updateDocente(@ModelAttribute("nuevoDocente") Docente docenteModificado) {
					
		//guardar
		ListadoDeDocentes.modificarDocente(docenteModificado);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaDocente");
		modelView.addObject("listadoDeDocentes", ListadoDeDocentes.listarDocentes());	
		
		return modelView;		
	}
	
	
}
