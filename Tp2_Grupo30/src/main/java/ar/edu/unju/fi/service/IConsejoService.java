package ar.edu.unju.fi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.entity.Consejo;

public interface IConsejoService {

	public List<Consejo> getConsejos();
	
	public Consejo getConsejo();
	
	public void addConsejo(Consejo consejo,MultipartFile imagen) throws IOException;
	
	public Consejo getConsejoEncontrado(Long id);
	
	
	public void updateConsejo(Consejo consejoModificado,MultipartFile imagen) throws IOException;
	
	public void deleteConsejo(Long id);
	
}
