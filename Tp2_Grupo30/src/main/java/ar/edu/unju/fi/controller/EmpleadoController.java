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
import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.service.IEmpleadoService;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	@Autowired
	@Qualifier("empleadoServiceMysqlImp")
	private IEmpleadoService empleadoService;
	/**
	@GetMapping("/listado")
	public String getEmpleadoPageString(Model model) {
		model.addAttribute("empleados", empleadoService.obtenerEmpleados());
		return "empleados";
	}
	*/
	
	@GetMapping("/nuevo")
	public ModelAndView getNuevoEmpleadoPage(ModelAndView mav) {
		mav.setViewName("nuevo_empleado");
		mav.addObject("empleado", empleadoService.obtenerEmpleado());
		return mav;
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarEmpledoPage(@Valid @ModelAttribute("empleado")Empleado empleado, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView("gestion_empleados");
		
		if(bindingResult.hasErrors()) {
			mav.setViewName("nuevo_empleado");
			mav.addObject("empleado", empleado);
			return mav;
		}
		
		empleadoService.guardarEmpleado(empleado);
		mav.addObject("empleados",empleadoService.obtenerEmpleados());
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarEmpleadoPage(Model model, @PathVariable(value="id")Long id) {
		boolean edicion=true;
		model.addAttribute("empleado",	empleadoService.buscarEmpleado(id));
		model.addAttribute("edicion", edicion);
		return "nuevo_empleado";
	}
	
	@PostMapping("/modificar/{id}")
	public String modificarEmpleado(@ModelAttribute("empleado")Empleado empleadoModificado) {
		empleadoService.modificarEmpleado(empleadoModificado);
		return "redirect:/empleado/gestion";
	}
		
	@GetMapping("/eliminar/{id}")
	public String eliminarEmpleado(@PathVariable(value="id")Long id) {
		empleadoService.eliminarEmpleado(id);
		return "redirect:/empleado/gestion";
	}
	@GetMapping("/gestion")
	public String getGestionEmpleadoPage(Model model) {
		model.addAttribute("empleados", empleadoService.obtenerEmpleados());
		return "gestion_empleados";
	}
	
}
