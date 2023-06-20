package ar.edu.unju.fi.service.imp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.service.IConsejoService;
import ar.edu.unju.fi.util.UploadFile;

@Service("consejoServiceListaImp")
public class ConsejoServiceImp implements IConsejoService {

	@Autowired
	private ListaConsejo consejos;

	@Autowired
	private UploadFile uploadFile;
	
	@Autowired
	private Consejo consejo;

	@Override
	public List<Consejo> obtenerConsejos() {
		return consejos.getConsejos();
	}

	@Override
	public void agregarConsejo(Consejo consejo, MultipartFile imagen) throws IOException {
		ListaConsejo.id++;
		consejo.setFechaPublicacion(LocalDate.now());
		consejo.setId(ListaConsejo.id);
		String uniqueFileName = uploadFile.copy(imagen);
		consejo.setImagen(uniqueFileName);
		obtenerConsejos().add(consejo);
	}

	@Override
	public Consejo obtenerConsejoEncontrado(Long id) {
		Consejo consejoEncontrado = new Consejo();
		for (Consejo consejo : obtenerConsejos()) {
			if (consejo.getId() == id) {
				consejoEncontrado = consejo;
				break;
			}
		}
		return consejoEncontrado;
	}

	@Override
	public void actualizarConsejo(Consejo consejoModificado, MultipartFile imagen) throws IOException {

		for (Consejo consejo : obtenerConsejos()) {
			System.out.println(consejo.getId());
			if (consejo.getId() == consejoModificado.getId()) {
				consejo.setFechaPublicacion(LocalDate.now());
				consejo.setParrafo(consejoModificado.getParrafo());
				consejo.setTitulo(consejoModificado.getTitulo());

				if (!imagen.isEmpty()) {
					String imagenString = imagen.getOriginalFilename();

					if (imagenString.compareTo(consejo.getImagen()) != 0) {
						uploadFile.delete(consejo.getImagen());
						imagenString = uploadFile.copy(imagen);
						consejo.setImagen(imagenString);
					}
				}
				break;

			}
		}
	}

	@Override
	public void eliminarConsejo(Long id) {
		for (Consejo consejo : obtenerConsejos()) {
			if (consejo.getId() == id) {
				uploadFile.delete(consejo.getImagen());
				obtenerConsejos().remove(consejo);
				break;
			}
		}
	}

	@Override
	public Consejo obtenerConsejo() {
		return consejo;
	}

}
