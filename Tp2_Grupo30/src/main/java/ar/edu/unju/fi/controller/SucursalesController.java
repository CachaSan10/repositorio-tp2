package ar.edu.unju.fi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		model.addAttribute("sucursal", new Sucursal());
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursal) {
		ModelAndView mav = new ModelAndView("sucursales");
		listaSucursales.getSucursales().add(sucursal);
		mav.addObject("sucursales", listaSucursales.getSucursales());
		return mav;
	}
}
