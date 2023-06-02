package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	private ListaServicio listaServicio;
	/*
	 * Servicio inyectado
	 */
	@Autowired
	private Servicio servicio;
	@GetMapping("/listado")
	public String getListaServicio(Model model) {
		model.addAttribute("servicios", listaServicio.getServicios());
		return "servicios";
	}
	
	@GetMapping("/nuevo")
	public String getAgregarServicioPage(Model model) {
		boolean edicion=false;
		model.addAttribute("servicio", servicio);
		model.addAttribute("edicion", edicion);
		return "nuevo_servicio";
	}
	
	@PostMapping("/guardar")
	public ModelAndView agregarServicio(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result) {
		ModelAndView  modelView = new ModelAndView("servicios");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_servicio");
			modelView.addObject("servicio",servicio);
			return modelView;
		}
		listaServicio.addServicio(servicio);
		modelView.addObject("servicios",listaServicio.getServicios());

		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarServicioPage(Model model, @PathVariable(value="id") int id) {
		boolean edicion=true;
		model.addAttribute("servicio", listaServicio.getServicio(id));
		model.addAttribute("edicion", edicion);
		
		return "nuevo_servicio";
	}
		
	@PostMapping("/modificar/{id}")
	public String modificarServicio(@ModelAttribute("servicio")Servicio servicioModificado) {
		//servicioModificado.setId("id");
		listaServicio.updateServicio(servicioModificado);
		return "redirect:/servicio/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarServicio(@PathVariable(value="id")int id) {
		listaServicio.deleteServicio(id);
		return "redirect:/servicio/listado";
	}
	
	
	
}
