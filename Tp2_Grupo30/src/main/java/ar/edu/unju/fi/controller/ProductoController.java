package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	ListaProducto listaProductos = new ListaProducto();
	

	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos",listaProductos.getProductos());
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		model.addAttribute("producto", new Producto());
		return "nuevo-producto";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@ModelAttribute("producto") Producto producto) {
		ModelAndView  modelAndView = new ModelAndView("productos");
		listaProductos.addProducto(producto);
		modelAndView.addObject("productos",listaProductos.getProductos());
		return modelAndView;
	}
}
