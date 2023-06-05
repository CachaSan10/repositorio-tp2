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

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ListaProducto listaProductos;

	@Autowired
	private Producto producto;
	
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos",listaProductos.getProductos());
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
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
		ModelAndView  modelAndView = new ModelAndView("productos");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_producto");
			modelAndView.addObject("producto",producto);
			return modelAndView;
		}
		listaProductos.addProducto(producto);
		modelAndView.addObject("productos",listaProductos.getProductos());
		return modelAndView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarProductoPage(Model model, @PathVariable(value="id") int id){
		boolean edicion=true;
		model.addAttribute("producto", listaProductos.productoBuscado(id));
		model.addAttribute("edicion", edicion);
		
		return "nuevo-producto";
	}
	
	@PostMapping("/modificar/{id}")
	public String modificarProducto(@ModelAttribute("producto") Producto productoModificado) {
		listaProductos.actualizarProducto(productoModificado);
		return "redirect:/productos/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable(value="id")int id) {
		listaProductos.deleteProducto(id);
		return "redirect:/productos/listado";
	}
}
