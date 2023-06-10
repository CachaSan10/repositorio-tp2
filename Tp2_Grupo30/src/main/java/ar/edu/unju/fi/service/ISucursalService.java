package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;

public interface ISucursalService {
	public Sucursal getSucursal();
	public void guardarSucursal(Sucursal sucursal);
	public void modificarSucursal(Sucursal sucursal);
	public void eliminarSucursal(Sucursal sucursal);
//	public ListaSucursal getListaSucursal();
	public List<Sucursal> getLista();
	public Sucursal buscarSucursal(int codigo);
}