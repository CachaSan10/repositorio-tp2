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
	
	@Autowired
	@Qualifier("empleadoServiceMysqlImp")
	private IEmpleadoService empleadoService;
		
	@GetMapping("/listado")
	public String getListaServicio(Model model) {
		model.addAttribute("servicios", servicioService.obtenerServicios());
		return "servicios";
	}
	
	@GetMapping("/nuevo")
	public String getAgregarServicioPage(Model model) {
		boolean edicion=false;
		
		model.addAttribute("servicio", servicioService.obtenerServicio());
		model.addAttribute("empleados", empleadoService.obtenerEmpleados());
		model.addAttribute("edicion", edicion);
		return "nuevo_servicio";
	}
	
	@PostMapping("/guardar")
	public ModelAndView agregarServicio(@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult bindingResult){
		ModelAndView  mav = new ModelAndView("redirect:/servicio/gestion");
		
		if(bindingResult.hasErrors()) {
			mav.setViewName("nuevo_servicio");
			mav.addObject("empleados", empleadoService.obtenerEmpleados());
			mav.addObject("servicio",servicio);
			return mav;
		}
		servicioService.guardarServicio(servicio);
		mav.addObject("servicios",servicioService.obtenerServicios());
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarServicioPage(Model model,@PathVariable(value="id") Long id) {
		boolean edicion=true;
		model.addAttribute("empleados", empleadoService.obtenerEmpleados());
		model.addAttribute("servicio", servicioService.buscarServicio(id));
		model.addAttribute("edicion", edicion);
		return "nuevo_servicio";
	}
		
	@PostMapping("/modificar/{id}")
	public String modificarServicio(@ModelAttribute("servicio")Servicio servicioModificado){
		servicioService.actualizarServicio(servicioModificado);
		return "redirect:/servicio/gestion";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarServicio(@PathVariable(value="id")Long id) {
		servicioService.eliminarServicio(id);
		return "redirect:/servicio/gestion";
	}
	
	@GetMapping("/gestion")
	public String getGestionServicioPage(Model model) {
		model.addAttribute("empleados", empleadoService.obtenerEmpleados());
		model.addAttribute("servicios", servicioService.obtenerServicios());
		return "gestion_servicios";
	}
	
	@GetMapping("/buscar/{dia}")
	public ModelAndView getServicioDiaPage(ModelAndView modelAndView,@PathVariable(value = "dia")String dia) {
		modelAndView.setViewName("gestion_servicios");
		if(dia.equals("Todo")) {
			modelAndView.setViewName("redirect:/servicio/gestion");
			return modelAndView;
		}
		modelAndView.addObject("servicios", servicioService.obtenerServiciosSegunDia(dia));
		return modelAndView;
	}
	
}
