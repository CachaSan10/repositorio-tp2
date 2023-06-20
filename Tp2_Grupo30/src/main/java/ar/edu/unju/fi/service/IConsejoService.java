package ar.edu.unju.fi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.entity.Consejo;

public interface IConsejoService {

	public List<Consejo> obtenerConsejos();
	
	public Consejo obtenerConsejo();
	
	public void agregarConsejo(Consejo consejo,MultipartFile imagen) throws IOException;
	
	public Consejo obtenerConsejoEncontrado(Long id);
	
	
	public void actualizarConsejo(Consejo consejoModificado,MultipartFile imagen) throws IOException;
	
	public void eliminarConsejo(Long id);
	
}
