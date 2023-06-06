package ar.edu.unju.fi.service;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;

public interface IConsejoService {

	public ListaConsejo getConsejos();
	
	public void addConsejo(Consejo consejo,MultipartFile imagen);
	
	public Consejo getConsejo(int id);
	
	public void updateConsejo(Consejo consejoModificado,MultipartFile imagen);
	
	public void deleteConsejo(int id);
	
}
