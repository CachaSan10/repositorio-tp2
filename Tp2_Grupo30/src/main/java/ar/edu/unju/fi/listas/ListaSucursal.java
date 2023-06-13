package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Sucursal;
//Se instancia objeto de tipo sucursal
@Component
public class ListaSucursal {
	
	private ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();

	
	public ListaSucursal() {

	}

	public ArrayList<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(ArrayList<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	

	
}
