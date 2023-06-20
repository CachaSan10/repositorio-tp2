package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.entity.Servicio;

public interface IServicioService {
	
	List<Servicio> getServicios();
	
	void addServicio(Servicio servicio);
	
	Servicio getServicioEncontrado(Long id);
	
	void updateServicio(Servicio servicioModificado);
	
	void deleteServicio(Servicio servicio);

	Servicio getServicio();
}