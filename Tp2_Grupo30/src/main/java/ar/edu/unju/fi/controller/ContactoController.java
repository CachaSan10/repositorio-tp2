package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

/**
*Villena Franco
*/
@Controller
public class ContactoController {
	
	@GetMapping("/contacto")
	public String getContactoPage() {
		
		return "contacto";
	}
}
