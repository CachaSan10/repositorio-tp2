package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;

@Service
public interface IProvinciaService {

	public Provincia getProvincia();
	public void guardarProvincia(Provincia provincia);
	public void modificarProvincia(Provincia provincia);
	public void eliminarProvincia(Provincia provincia);
	public List<Provincia> getLista();
	public Provincia buscarProvincia(Long id);
	
}
