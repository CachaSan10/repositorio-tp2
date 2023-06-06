package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;

@Service
public class SucursalServiceImp implements ISucursalService {
	
	@Autowired
	private ListaSucursal listaSucursal;
	@Autowired
	private Sucursal sucursal;
	
	@Override
	public Sucursal getSucursal() {
		
		return sucursal;
	}

	@Override
	public void guardarSucursal(Sucursal sucursal) {
		
		listaSucursal.getSucursales().add(sucursal);
	}

	@Override
	public void modificarSucursal(Sucursal sucursal) {
		for(Sucursal suc :this.listaSucursal.getSucursales()) {
			if(suc.getCodigo()==sucursal.getCodigo()) {
				suc.setNombre(sucursal.getNombre());
				suc.setDireccion(sucursal.getDireccion());
				suc.setEmail(sucursal.getEmail());
				suc.setFechaInicio(sucursal.getFechaInicio());
				suc.setProvincia(sucursal.getProvincia());
				suc.setTelefono(sucursal.getTelefono());
			}
		}
		
	}

	@Override
	public void eliminarSucursal(Sucursal sucursal) {
		listaSucursal.getSucursales().remove(sucursal);
		
	}

//	@Override
//	public ListaSucursal getListaSucursal() {
//		
//		return this.listaSucursal;
//	}

	@Override
	public Sucursal buscarSucursal(int codigo) {
		Sucursal devolverSucursal = null;
		for(Sucursal sucursal : this.listaSucursal.getSucursales()) {
			if(sucursal.getCodigo()==codigo) {
				devolverSucursal=sucursal;
			}
		}
		
		return devolverSucursal;
	}

	@Override
	public List<Sucursal> getLista() {
	
		return listaSucursal.getSucursales();
	}



}
