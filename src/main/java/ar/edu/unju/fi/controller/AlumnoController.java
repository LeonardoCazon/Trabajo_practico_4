package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDeAlumnos;
import ar.edu.unju.fi.model.Alumno;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AlumnoController {
	
	@Autowired
	Alumno nuevoAlumno = new Alumno();
	
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		//vista del formulario alumno en html
		ModelAndView MV = new ModelAndView("formAlumno");
		//agrega el objeto
		MV.addObject("nuevoAlumno", nuevoAlumno);
		MV.addObject("band", false);
		return MV;
	}
	
	@GetMapping("/listadoTAlumnos")
	public ModelAndView getlist() {
		// mostrar el listado
		ModelAndView MV = new ModelAndView("listaAlumno");
		MV.addObject("listadoDeAlumnos", ListadoDeAlumnos.listarAlumnos());

		return MV;
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoParaGuardar) {
		//guardar
		ListadoDeAlumnos.agregarAlumno(alumnoParaGuardar);
		
		//mostrar el listado
		ModelAndView MV = new ModelAndView("listaAlumno");
		MV.addObject("listadoDeAlumnos",ListadoDeAlumnos.listarAlumnos());
		
		return MV;
	}
	
	@GetMapping("/borrarAlumno/{dni}")
	public static ModelAndView deleteAlumno(@PathVariable(name="dni")int dni) {
		//borrar
		ListadoDeAlumnos.eliminarAlumno(dni);
		
		//mostrar el nuevo listado
		ModelAndView MV=new ModelAndView("listaAlumno");
		MV.addObject("listadoDeAlumnos", ListadoDeAlumnos.listarAlumnos());
		
		return MV;
	}
	
	@GetMapping("/modificarAlumno/{dni}")
	public ModelAndView editAlumno(@PathVariable(name="dni") int dni) {
		//buscar
		Alumno alumnoParaModificar = ListadoDeAlumnos.buscarAlumnoPorDNI(dni);
		
		//mostrar el nuevo formulario
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", alumnoParaModificar);
		modelView.addObject("band", true);
		return modelView;		
	}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView updateAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoModificado) {
					
		//guardar
		ListadoDeAlumnos.modificarAlumno(alumnoModificado);
		
		//mostrar el listado
		ModelAndView modelView = new ModelAndView("listaAlumno");
		modelView.addObject("listadoDeAlumnos", ListadoDeAlumnos.listarAlumnos());	
		
		return modelView;		
	}
	
	
}
