package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Servicio;

public class ListaServicio {
	private List<Servicio> servicios;
	
	public ListaServicio(){
		servicios = new ArrayList<Servicio>();
		
		servicios.add(new Servicio("1","07:30", "08:30","Luis Martinez","Lunes"));
		servicios.add(new Servicio("2","09:00", "10:00","Maria Darco","Lunes"));
		servicios.add(new Servicio("3","07:30", "08:30","Horacio Campos","Martes"));
		servicios.add(new Servicio("4","09:00", "10:00","Luna Jara","Martes"));
		servicios.add(new Servicio("5","07:30", "08:30","Luis Martinez","Miercoles"));
		servicios.add(new Servicio("6","09:00", "10:00","Maria Darco","Miercoles"));
		servicios.add(new Servicio("7","07:30", "08:30","Horacio Campos","Jueves"));
		servicios.add(new Servicio("8","09:00", "10:00","Luna Jara","Jueves"));
		servicios.add(new Servicio("9","07:30", "08:30","Lucas Diaz","Viernes"));
		servicios.add(new Servicio("10","09:00", "10:00","Marisol Davalo","Viernes"));
	}
	
	public void addServicio(Servicio servicio) {
		String id = Integer.toString(1 + servicios.size());
		servicio.setId(id);
		servicios.add(servicio);
	}
	
	public void updateServicio(Servicio servicioModificado) {
		List<Servicio> listaServicio = new ArrayList<Servicio>();
		listaServicio= getServicios();
		 for(Servicio servicio: listaServicio) {
		    	if(servicio.getId().equals(servicioModificado.getId())) {
		    		servicio.setStartTime(servicioModificado.getStartTime());
		    		servicio.setFinishTime(servicioModificado.getFinishTime());
		    		servicio.setFullName(servicioModificado.getFullName());
		    		servicio.setDay(servicioModificado.getDay());
		    		break;
		    	}
		    }
		 setServicios(listaServicio);
	}
	
	
	public Servicio getServicio(String id) {
	    Servicio servicioEncontrado = new Servicio();
	    for(Servicio servicio: getServicios()) {
	    	if(servicio.getId().equals(id)) {
	    		servicioEncontrado=servicio;
	    		break;
	    	}
	    }
		return servicioEncontrado;
	}
	
	public void deleteServicio(String id) {
		for(Servicio servicio: getServicios()) {
	    	if(servicio.getId().equals(id)) {
	    		getServicios().remove(servicio);
	    		break;
	    	}
	    }
	}
	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
}
