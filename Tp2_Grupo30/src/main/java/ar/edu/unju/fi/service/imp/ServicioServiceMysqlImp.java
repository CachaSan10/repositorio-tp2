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
	public List<Servicio> obtenerServicios() {
		return servicioRepository.findByEstado(true);
	}
	
	@Override
	public Servicio obtenerServicio() {
		return servicio;
	}
	@Override
	public void guardarServicio(Servicio servicio){
		servicio.setEstado(true);
		servicioRepository.save(servicio);
	}

	@Override
	public Servicio obtenerServicioEncontrado(Long id) {
		
		return servicioRepository.findById(id).get();
	}

	@Override
	public void actualizarServicio(Servicio servicio){
		servicio.setEstado(true);
		servicioRepository.save(servicio);

	}

	@Override
	public void eliminarServicio(Long id) {
		//Vamos a hacer eliminación lógica colcando en false
		Servicio unServicio = new Servicio();
		unServicio = obtenerServicioEncontrado(id);
		unServicio.setEstado(false);
		servicioRepository.save(unServicio);
	}
	@Override
	public List<Servicio> obtenerServiciosSegunDia(String dia) {
       return servicioRepository.findByDia(dia);
	}
	
}