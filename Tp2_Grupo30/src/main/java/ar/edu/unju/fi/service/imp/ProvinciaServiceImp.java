package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;
@Service
public class ProvinciaServiceImp implements IProvinciaService {
	
	@Autowired
	private IProvinciaRepository provinciaRepository;
	
	@Autowired
	private Provincia provincia;
	
	@Override
	public Provincia getProvincia() {
		// TODO Auto-generated method stub
		return provincia;
	}

	@Override
	public void guardarProvincia(Provincia provincia) {
		provincia.setEstado(true);
		provinciaRepository.save(provincia);
		
	}

	@Override
	public void modificarProvincia(Provincia provincia) {
		provincia.setEstado(true);
		provinciaRepository.save(provincia);
		
	}

	@Override
	public void eliminarProvincia(Provincia provincia) {
		provincia.setEstado(false);
		provinciaRepository.save(provincia);
		
	}

	@Override
	public List<Provincia> getLista() {
		// TODO Auto-generated method stub
		return provinciaRepository.findByEstado(true);
	}

	@Override
	public Provincia buscarProvincia(Long id) {
		// TODO Auto-generated method stub
		return provinciaRepository.findById(id).get();
	}

}
