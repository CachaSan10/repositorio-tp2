package ar.edu.unju.fi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.model.Consejo;

public interface IConsejoService {

	public List<Consejo> getConsejos();
	
	public void addConsejo(Consejo consejo,MultipartFile imagen) throws IOException;
	
	public Consejo getConsejo(int id);
	
	public void updateConsejo(Consejo consejoModificado,MultipartFile imagen) throws IOException;
	
	public void deleteConsejo(int id);
	
}
