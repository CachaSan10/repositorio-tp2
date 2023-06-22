package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.entity.CategoriaEmpleado;

@Component
public class ListaCategoria {
	
	private List<CategoriaEmpleado> listaCategorias;
	public static int id;
	
	public void ListaCategorias(){
		
		listaCategorias = new ArrayList<CategoriaEmpleado>();
		
		listaCategorias.add(new CategoriaEmpleado(1,"Pasaador"));
		listaCategorias.add(new CategoriaEmpleado(2,"Encargado"));
		id=2;
	}
	
	/** Getter and Setter*/
	/**
	 * @return the listaCategorias
	 */
	public List<CategoriaEmpleado> getListaCategorias() {
		return listaCategorias;
	}

	/**
	 * @param listaCategorias the listaCategorias to set
	 */
	public void setListaCategorias(List<CategoriaEmpleado> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

}
