package ar.edu.unju.fi.listas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Servicio;

@Component
public class ListaServicio {
	private List<Servicio> servicios;
	public static int id;
	
	public ListaServicio(){
		servicios = new ArrayList<Servicio>();
		
		servicios.add(new Servicio(1,LocalTime.of(7, 30), LocalTime.of(8, 30),"Luis", "Martinez","Lunes"));
		servicios.add(new Servicio(2,LocalTime.of(9, 00), LocalTime.of(10, 00),"Maria", "Darco","Lunes"));
		servicios.add(new Servicio(3,LocalTime.of(7, 30), LocalTime.of(8, 30),"Horacio", "Campos","Martes"));
		servicios.add(new Servicio(4,LocalTime.of(9, 00), LocalTime.of(10, 00),"Luna", "Jara","Martes"));
		servicios.add(new Servicio(5,LocalTime.of(7, 30), LocalTime.of(8, 30),"Luis", "Martinez","Miercoles"));
		servicios.add(new Servicio(6,LocalTime.of(9, 00), LocalTime.of(10, 00),"Maria", "Darco","Miercoles"));
		servicios.add(new Servicio(7,LocalTime.of(7, 30), LocalTime.of(8, 30),"Horacio", "Campos","Jueves"));
		servicios.add(new Servicio(8,LocalTime.of(9, 00), LocalTime.of(10, 00),"Luna", "Jara","Jueves"));
		servicios.add(new Servicio(9,LocalTime.of(7, 30), LocalTime.of(8, 30),"Lucas", "Diaz","Viernes"));
		servicios.add(new Servicio(10,LocalTime.of(9, 00), LocalTime.of(10, 00),"Marisol", "Davalo","Viernes"));
		id=10;
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
