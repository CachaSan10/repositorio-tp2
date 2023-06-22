package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;

@Service("servicioServiceMysqlImp")
public class ServicioServiceMysqlImp implements IServicioService {
	
	@Autowired
	private IServicioRepository servicioRepository;
	@Autowired
	private Servicio servicio;
	
	@Override
	public List<Servicio> getServicios() {
		return servicioRepository.findByEstado(true);
	}
	/**
	 * Metodo que retorna un servicio
	 * @return un servicio
	*/
	@Override
	public Servicio getServicio() {
		return servicio;
	}
	@Override
	public void addServicio(Servicio servicio){
		servicio.setEstado(true);
		servicioRepository.save(servicio);
	}

	@Override
	public Servicio getServicioEncontrado(Long id) {
		
		return servicioRepository.findById(id).get();
	}

	@Override
	public void updateServicio(Servicio servicio){
		servicioRepository.save(servicio);

	}

	@Override
	public void deleteServicio(Servicio servicio) {
		//Vamos a hacer eliminación lógica colcando en false
		
		servicio.setEstado(false);
		servicioRepository.save(servicio);
	}
	
}