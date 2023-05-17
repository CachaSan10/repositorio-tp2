package ar.edu.unju.fi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/sucursal")
public class SucursalesController {
	ListaSucursal listaSucursales = new ListaSucursal();
	
	@GetMapping("/listado")
	public String getSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion= false;
		model.addAttribute("sucursal", new Sucursal());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursal) {
		ModelAndView mav = new ModelAndView("sucursales");
		listaSucursales.getSucursales().add(sucursal);
		mav.addObject("sucursales", listaSucursales.getSucursales());
		return mav;
	}
	@GetMapping("/modificar/{codigo}")
	public String getModificarSucursalPage(Model model,@PathVariable(value="codigo")int codigo) {
		boolean edicion=true;
		Sucursal sucursalEncontrada = new Sucursal();
		for(Sucursal sucu: listaSucursales.getSucursales()) {
			if(sucu.getCodigo()==codigo) {
				sucursalEncontrada = sucu;
				break;
			}
		}
		
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("sucursal")Sucursal sucursal) {
		for(Sucursal sucu: listaSucursales.getSucursales()) {
			if(sucu.getCodigo()==sucursal.getCodigo()) {
				sucu.setNombre(sucursal.getNombre());
				sucu.setEmail(sucursal.getEmail());
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setFechaInicio(sucursal.getFechaInicio());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setTelefono(sucursal.getTelefono());
				
			}
		}
		return "redirect:/sucursal/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarSucursal(@PathVariable(value="codigo")int codigo) {
		for(Sucursal sucu: listaSucursales.getSucursales()) {
			if(sucu.getCodigo()==codigo) {
				listaSucursales.getSucursales().remove(sucu);
				break;
			}
		}
		
		return "redirect:/sucursal/listado";
	}
	
}
