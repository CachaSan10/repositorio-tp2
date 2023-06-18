package ar.edu.unju.fi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
@Service
public interface ISucursalService {
	public Sucursal getSucursal();
	public void guardarSucursal(Sucursal sucursal);
	public void modificarSucursal(Sucursal sucursal);
	public void eliminarSucursal(Sucursal sucursal);
//	public ListaSucursal getListaSucursal();
	public List<Sucursal> getLista();
	public Sucursal buscarSucursal(Long id);
	public List<Sucursal> buscarPorFecha(LocalDate fecha);
}
