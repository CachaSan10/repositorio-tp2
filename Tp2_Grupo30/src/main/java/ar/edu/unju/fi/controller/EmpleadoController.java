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
import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.service.IEmpleadoService;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("/listado")
	public String getEmpleadoPageString(Model model) {
		model.addAttribute("empleados", empleadoService.getLista());
		return "empleados";
	}
	
	
	@GetMapping("/nuevo")
	public String getNuevoEmpleadoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("empleado",new Empleado() );
		model.addAttribute("edicion", edicion);
		return "nuevo_empleado";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarEmpledoPage(@Valid @ModelAttribute("empleado")Empleado empleado, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView("empleados");
		
		if(bindingResult.hasErrors()) {
			mav.setViewName("nuevo_empleado");
			mav.addObject("edicion", false);
			return mav;
		}
		empleadoService.guardarEmpleado(empleado);
		mav.setViewName("redirect:/empleado/listado");
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarEmpleadoPage(Model model, @PathVariable(value="id")Long id) {
		boolean edicion=true;
		Empleado empleadoEncontrado = empleadoService.buscarEmpleado(id);
		
		model.addAttribute("empleado",	empleadoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_empleado";
	}
	
	
	@PostMapping("/modificar/{id}")
	public String modificarEmpleado(@Valid @ModelAttribute("empleado")Empleado empleadoModificado, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "nuevo_empleado";
		}
		empleadoService.modificarEmpleado(empleadoModificado);
		return "redirect:/empleado/listado";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable(value="id")Long id) {
		Empleado empleadoEncontrado = empleadoService.buscarEmpleado(id);
		empleadoService.eliminarEmpleado(empleadoEncontrado);
	
		return "redirect:/empleado/listado";
	}
	@GetMapping("/gestion")
	public String getGestionEmpleadoPage(Model model) {
		model.addAttribute("empleados", empleadoService.getLista());
		return "gestion_empleados";
	}
	
}
