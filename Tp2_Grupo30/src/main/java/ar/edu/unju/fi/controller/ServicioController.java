package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	@Qualifier("servicioServiceMysqlImp")
	private IServicioService servicioService;
		
	@GetMapping("/listado")
	public String getListaServicio(Model model) {
		model.addAttribute("servicios", servicioService.getServicios());
		return "servicios";
	}
	
	@GetMapping("/nuevo")
	public String getAgregarServicioPage(Model model) {
		boolean edicion=false;
		model.addAttribute("servicio", servicioService.getServicio());
		model.addAttribute("edicion", edicion);
		return "nuevo_servicio";
	}
	
	@PostMapping("/guardar")
	public ModelAndView agregarServicio(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result){
		ModelAndView  modelView = new ModelAndView("servicios");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_servicio");
			modelView.addObject("servicio",servicio);
			return modelView;
		}
		servicioService.addServicio(servicio);
		modelView.addObject("servicios",servicioService.getServicios());

		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarServicioPage(Model model, @PathVariable(value="id") Long id) {
		boolean edicion=true;
		model.addAttribute("servicio", servicioService.getServicioEncontrado(id));
		model.addAttribute("edicion", edicion);
		
		return "nuevo_servicio";
	}
		
	@PostMapping("/modificar/{id}")
	public String modificarServicio(@ModelAttribute("servicio")Servicio servicioModificado){//Tener en cuenta s
		//servicioModificado.setId("id");
		servicioService.updateServicio(servicioModificado);
		return "redirect:/servicio/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarServicio(@PathVariable(value="id")Long id) {
		Servicio servicioEncontrado = servicioService.getServicioEncontrado(id);
		servicioService.deleteServicio(servicioEncontrado);
		return "redirect:/servicio/listado";
	}
	
	@GetMapping("/gestion")
	public String getGestionServicioPage(Model model) {
		model.addAttribute("servicios", servicioService.getServicios());
		return "gestion_servicios";
	}
	
}
