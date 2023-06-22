/**
 * 
 */
package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

@Component
public class CategoriaEmpleado {
	
	//Representa el nombre de categoria
	private int id;
	private String nombre;
	/**
	 * Constructor por defecto
	 */
	public CategoriaEmpleado() {}

	/**
	 * Constructor Parametrizado
	 * @param id representa el id de la categoria
	 * @param nombre  representa el nombre de la categoria
	 */

	public CategoriaEmpleado(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
		
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que retorna el nombre de categoria
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que modifica el nombre de categoria
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "CategoriaEmpleado [id=" + id + ", nombre=" + nombre + "]";
	}
	
		
}
