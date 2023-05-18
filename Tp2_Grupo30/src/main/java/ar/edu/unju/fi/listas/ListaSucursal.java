package ar.edu.unju.fi.listas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Sucursal;

public class ListaSucursal {
	private List<Sucursal> sucursales;
	
	
	
	public ListaSucursal() {
		sucursales = new ArrayList<Sucursal>();
		LocalDate fechaInicio;
		
		fechaInicio = LocalDate.of(2010, 2, 22);
		sucursales.add(new Sucursal(322,"CASA CENTRAL","Av. General Belgrano Nº 3915","Jujuy",fechaInicio,"central@gmail.com","388-4999999"));
		
		
		fechaInicio = LocalDate.of(2012, 5, 15);
		sucursales.add(new Sucursal(644,"SUCURSAL NECOCHEA","Av. General Belgrano Nº 3915","Salta",fechaInicio,"snecocheal@gmail.com","388-4666666"));
	
		fechaInicio = LocalDate.of(2020, 3, 5);
		sucursales.add(new Sucursal(566,"SUCURSAL MERCADO","Av. General Belgrano Nº 3915","Formosa",fechaInicio,"mercado@gmail.com","388-4777777"));
	
		
		fechaInicio = LocalDate.of(2015, 1, 20);
		sucursales.add(new Sucursal(822,"SUCURSAL PUPPIS","Av. General Belgrano Nº 3915","Tucuman",fechaInicio,"puppis@gmail.com","388-4888888"));
	}



	public List<Sucursal> getSucursales() {
		return sucursales;
	}



	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	
	
	
	
}
