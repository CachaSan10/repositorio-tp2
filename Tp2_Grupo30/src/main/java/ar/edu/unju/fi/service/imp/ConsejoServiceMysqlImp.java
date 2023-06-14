package ar.edu.unju.fi.service.imp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;
import ar.edu.unju.fi.util.UploadFile;

@Service("consejoServiceMysqlImp")
public class ConsejoServiceMysqlImp implements IConsejoService {

	@Autowired
	private IConsejoRepository consejoRepository;
	
	@Autowired
	private UploadFile uploadFile;
	
	@Autowired
	private Consejo consejo;
	
	/**
	 * Metodo que retorna una lista de consejos que estan disponibles
	 * @return lista de consejos disponible
	 */
	@Override
	public List<Consejo> getConsejos() {
		return consejoRepository.findByEstado(true); 
	}

	/**
	 * Metodo que retorna un consejo
	 * @return un consejo
	 */
	@Override
	public Consejo getConsejo() {
		return consejo;
	}

	/**
	 * Metodo que agrega un consejo a la base de datos
	 * @param consejo representa un consejo
	 * @param imagen representa una imagen de la publicacion del consejo
	 */
	@Override
	public void addConsejo(Consejo consejo, MultipartFile imagen) throws IOException {
		consejo.setFechaPublicacion(LocalDate.now());
		String uniqueFileName = uploadFile.copy(imagen);
		consejo.setImagen(uniqueFileName);
		consejo.setEstado(true);
		System.out.println(consejo.toString());
		consejoRepository.save(consejo);
	}

	/**
	 * Metodo que retorna un consejo de la base de datos
	 * @param id representa un id del consejo que se desea encontrar
	 * @return el consejo que se encontro a traves del id
	 */
	@Override
	public Consejo getConsejoEncontrado(Long id) {
		Consejo consejoEncontrado = new Consejo();
		consejoEncontrado.setId(id);
		consejoEncontrado.setFechaPublicacion(consejoRepository.findById(id).get().getFechaPublicacion());
		consejoEncontrado.setEstado(true);
		consejoEncontrado.setImagen(consejoRepository.findById(id).get().getImagen());
		consejoEncontrado.setTitulo(consejoRepository.findById(id).get().getTitulo());
		consejoEncontrado.setParrafo(consejoRepository.findById(id).get().getParrafo());
		
		System.out.println("consejo encontrado:" + consejoRepository.findById(id).get().toString());
		return consejoEncontrado;
	}

	/**
	 * Metodo que modifica el consejo de la base de datos
	 * @param consejoModificado representa el consejo que quiere modificar
	 * @param imagen representa la imagen que se va a modificar en consejo
	 */
	@Override
	public void updateConsejo(Consejo consejoModificado, MultipartFile imagen) throws IOException {
		Consejo unConsejo = new Consejo();
		System.out.println("consejo modificado: " + consejoModificado.toString());
		System.out.println("consejo modificado2: " + consejoRepository.findById(consejoModificado.getId()).get().toString());

		unConsejo.setId(consejoModificado.getId());
		unConsejo.setEstado(true);
		unConsejo.setFechaPublicacion(LocalDate.now());
		unConsejo.setTitulo(consejoModificado.getTitulo());
		unConsejo.setParrafo(consejoModificado.getParrafo());
		
		if (!imagen.isEmpty()) {
			String imagenString = imagen.getOriginalFilename();

			if (imagenString.compareTo(getConsejoEncontrado(consejoModificado.getId()).getImagen()) != 0) {
				uploadFile.delete(getConsejoEncontrado(consejoModificado.getId()).getImagen());
				imagenString = uploadFile.copy(imagen);
				unConsejo.setImagen(imagenString);
			}
		}else {
			unConsejo.setImagen(getConsejoEncontrado(consejoModificado.getId()).getImagen());
		}
		
		consejoRepository.save(unConsejo);

	}

	/**
	 * Metodo que elimina el consejo de manera logica de la base de datos
	 * @param id representa el id del consejo que se desea eliminar de manera logica de la base de datos
	 */
	@Override
	public void deleteConsejo(Long id) {
		
		Consejo otroConsejo = new Consejo();
		otroConsejo = consejoRepository.findById(id).get();
		uploadFile.delete(otroConsejo.getImagen());
		otroConsejo.setEstado(false);
		consejoRepository.save(otroConsejo);
		
	}

}
