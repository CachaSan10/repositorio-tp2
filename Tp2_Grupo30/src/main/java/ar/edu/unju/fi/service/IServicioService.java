package ar.edu.unju.fi.service;

import java.io.IOException;
import java.util.List;

import ar.edu.unju.fi.model.Servicio;

public interface IServicioService {
	
	public List<Servicio> getServicios();
	
	public void addServicio(Servicio servicio) throws IOException;
	
	public Servicio getServicioEncontrado(int id);
	
	public void updateServicio(Servicio servicioModificado) throws IOException;
	
	public void deleteServicio(int id);
}
