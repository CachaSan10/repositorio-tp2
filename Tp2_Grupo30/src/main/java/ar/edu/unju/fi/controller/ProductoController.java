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

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;

	@Autowired
	private Producto producto;
	
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos",productoService.getListaProducto());
		return "productos";
	}
	
	@GetMapping("/nuevo")	
	public String getNuevoProductoPage(Model model) {
		boolean edicion=false;
		
		model.addAttribute("producto", producto);
		model.addAttribute("edicion", edicion);
		return "nuevo-producto";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@ModelAttribute("producto") Producto producto) {
		ModelAndView  modelAndView = new ModelAndView("productos");
		productoService.guardarProducto(producto);
		modelAndView.addObject("productos",productoService.getListaProducto());
		return modelAndView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarProductoPage(Model model, @PathVariable(value="id") int id){
		boolean edicion=true;
		model.addAttribute("producto", productoService.buscarProducto(id));
		model.addAttribute("edicion", edicion);
		
		return "nuevo-producto";
	}
	
	@PostMapping("/modificar/{id}")
	public String modificarProducto(@ModelAttribute("producto") Producto productoModificado) {
		productoService.modificarProducto(productoModificado);
		return "redirect:/productos/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable(value="id")int id) {
		productoService.eliminarProducto(id);
		return "redirect:/productos/listado";
	}
}
