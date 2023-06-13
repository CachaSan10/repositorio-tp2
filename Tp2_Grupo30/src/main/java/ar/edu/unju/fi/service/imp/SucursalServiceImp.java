package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;

@Service("sucursalServiceMysql")
public class SucursalServiceImp implements ISucursalService {
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;
	
	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}

	@Override
	public void guardarSucursal(Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);

	}

	@Override
	public void modificarSucursal(Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);

	}

	@Override
	public void eliminarSucursal(Sucursal sucursal) {
		sucursal.setEstado(false);
		sucursalRepository.save(sucursal);

	}

	@Override
	public List<Sucursal> getLista() {
		return sucursalRepository.findByEstado(true);
	}

	@Override
	public Sucursal buscarSucursal(Long id) {
		
		return sucursalRepository.findById(id).get();
	}

}
