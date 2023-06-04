package ar.edu.unju.fi.listas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Servicio;

@Component
public class ListaServicio {
	private List<Servicio> servicios;
	private int id;
	
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
	 * Metodo que agrega servicio a la lista de servicio
	 * @param servicio representa el servicio que se va agregar a la 
	 * lista de servicio.
	 */
	public void addServicio(Servicio servicio) {
	    id++;
		servicio.setId(id);
		servicios.add(servicio);
	}
	
	/**
	 * Metodo que modifica el servicio de la lista servicio
	 * @param servicioModificado representa el servicio modificado
	 * que se modifico en la lista servicio.
	 */
	public void updateServicio(Servicio servicioModificado) {
		List<Servicio> listaServicio = new ArrayList<Servicio>();
		listaServicio= getServicios();
		 for(Servicio servicio: listaServicio) {
		    	if(servicio.getId()==servicioModificado.getId()) {
		    		servicio.setStartTime(servicioModificado.getStartTime());
		    		servicio.setFinishTime(servicioModificado.getFinishTime());
		    		servicio.setFirstName(servicioModificado.getFirstName());
		    		servicio.setLastName(servicioModificado.getLastName());
		    		servicio.setDay(servicioModificado.getDay());
		    		break;
		    	}
		    }
		 setServicios(listaServicio);
	}
	
	/**
	 * Metodo que busca el servicio de a traves de su id.
	 * @param id representa el id del servicio que se esta buscando en 
	 * la lista de servicio.
	 * @return el servicio que se encontro en la lista.
	 */
	public Servicio getServicio(int id) {
	    Servicio servicioEncontrado = new Servicio();
	    for(Servicio servicio: getServicios()) {
	    	if(servicio.getId()==id) {
	    		servicioEncontrado=servicio;
	    		break;
	    	}
	    }
		return servicioEncontrado;
	}
	
	/**
	 * Metodo que elimina el servicio dependiendo del id
	 * @param id representa el id del servicio que se quiere eliminar
	 */
	public void deleteServicio(int id) {
		for(Servicio servicio: getServicios()) {
	    	if(servicio.getId()==id) {
	    		getServicios().remove(servicio);
	    		break;
	    	}
	    }
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
