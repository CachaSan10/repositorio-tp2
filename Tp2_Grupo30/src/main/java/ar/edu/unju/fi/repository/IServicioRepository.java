package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Servicio;

@Repository
public interface IServicioRepository extends CrudRepository<Servicio, Long> {
	//Podemos crear metodos personalizados
	public List<Servicio> findByEstado(boolean estado);
}
