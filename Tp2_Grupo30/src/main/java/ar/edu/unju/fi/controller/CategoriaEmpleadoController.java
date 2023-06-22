/**
 * 
 */
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
import ar.edu.unju.fi.entity.CategoriaEmpleado;
import ar.edu.unju.fi.service.ICategoriaEmpleadoService;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/categoriaEmpleado")
public class CategoriaEmpleadoController {
	
	@Autowired
	@Qualifier("categoriaEmpleadoServiceMysqlImp")
	private ICategoriaEmpleadoService categoriaEmpleadoService;
	
	@GetMapping("/listado")
	public String getCategoriaEmpleadoPageString(Model model) {
		model.addAttribute("categorias_empleado", categoriaEmpleadoService.obtenerCategoriasEmpleado());
		return "empleados";
	}
	@GetMapping("/gestion")
	public String getCategoriaEmpleadoGestionPage(Model model) {
		model.addAttribute("categorias_empleado", categoriaEmpleadoService.obtenerCategoriasEmpleado());
		return "gestion_categorias_empleado";
	}
	
	@GetMapping("/nuevo")
	public ModelAndView getNuevaCategoriaEmpleadoPage(ModelAndView modelAndView) {
		modelAndView.setViewName("nueva_categoria_empleado");
		modelAndView.addObject("categoria_empleado", categoriaEmpleadoService.obtenerCategoriaEmpleado());
		return modelAndView;
	}
	
	@PostMapping("/guardar")
	public ModelAndView agregarCategoriaEmpleado(@Valid @ModelAttribute("categoria_empleado") CategoriaEmpleado categoriaEmpleado, BindingResult result) {
		ModelAndView  modelAndView = new ModelAndView("gestion_categorias_empleado");
		if(result.hasErrors()) {
			modelAndView.setViewName("nueva_categoria_empleado");
			modelAndView.addObject("categoria_empleado", categoriaEmpleadoService.obtenerCategoriaEmpleado());
			return modelAndView;
		}
		
		categoriaEmpleadoService.guardarCategoriaEmpleado(categoriaEmpleado);
		modelAndView.addObject("categorias",categoriaEmpleadoService.obtenerCategoriasEmpleado());

		return modelAndView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarCategoriaEmpleadoPage(Model model,@PathVariable(value="id")Long id) {
		boolean edicion=true;
		model.addAttribute("categoria_empleado", categoriaEmpleadoService.buscarCategoriaEmpleado(id));
		model.addAttribute("edicion", edicion);
		
		return "nueva_categoria_empleado";
	}
	
	
	@PostMapping("/modificar/{id}")
	public String modificarCategoriaEmpleado(@ModelAttribute("categoria_empleado")CategoriaEmpleado categoriaEmpleadoModificado)  {
		categoriaEmpleadoService.modificarCategoriaEmpleado(categoriaEmpleadoModificado);
		return "redirect:/categoria_empleado/gestion";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCategoriaEmpleado(@PathVariable(value="id")Long id) {
		categoriaEmpleadoService.eliminarCategoriaEmpleado(id);
		return "redirect:/categoria_empleado/gestion";
	}
	

}
