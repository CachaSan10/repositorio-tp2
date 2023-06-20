package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Servicio;

@Component
public class ListaServicio {
	private List<Servicio> servicios;
	public static Long id;
	
	public ListaServicio(){
		
		servicios = new ArrayList<Servicio>();
		/**
		servicios.add(new Servicio(1l,LocalTime.of(7, 30), LocalTime.of(8, 30),"Lunes"));
		servicios.add(new Servicio(2l,LocalTime.of(9, 00), LocalTime.of(10, 00),"Lunes"));
		servicios.add(new Servicio(3l,LocalTime.of(7, 30), LocalTime.of(8, 30),"Martes"));
		servicios.add(new Servicio(4l,LocalTime.of(9, 00), LocalTime.of(10, 00),"Martes"));
		servicios.add(new Servicio(5l,LocalTime.of(7, 30), LocalTime.of(8, 30),"Miercoles"));
		servicios.add(new Servicio(6l,LocalTime.of(9, 00), LocalTime.of(10, 00),"Miercoles"));
		servicios.add(new Servicio(7l,LocalTime.of(7, 30), LocalTime.of(8, 30),"Jueves"));
		servicios.add(new Servicio(8l,LocalTime.of(9, 00), LocalTime.of(10, 00),"Jueves"));
		servicios.add(new Servicio(9l,LocalTime.of(7, 30), LocalTime.of(8, 30),"Viernes"));
		servicios.add(new Servicio(10l,LocalTime.of(9, 00), LocalTime.of(10, 00),"Viernes"));
		id=10l;*/
	}
	
	
	/**
	 * Creacion del getter y setter del atributo List servicios
	 *
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
}

