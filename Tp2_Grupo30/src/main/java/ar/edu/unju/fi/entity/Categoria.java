/**
 * 
 */
package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author Nahuel Alberto Cachambi 
 * Clase que representa una categoria de producto
 */
@Component
@Entity
@Table(name = "categorias")
public class Categoria {


	//Representa el id de categoria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoria_id")
	private Long id;
	
	//Representa el nombre de categoria
	@Column(name = "categoria_nombre")
	private String nombre;

	@OneToOne(mappedBy = "producto")
	private Producto producto;
	
	
	/**
	 * Constructor por defecto
	 */
	public Categoria() {
	}

	/**
	 * Constructor Parametrizado
	 * @param id representa el id de la categoria
	 * @param nombre  representa el nombre de la categoria
	 * @param producto representa el producto que pertence la categoria
	 */
	public Categoria(Long id, String nombre, Producto producto) {
		this.id = id;
		this.nombre = nombre;
		this.producto = producto;
	}

	/**
	 * Metodo que retorna el id de categoria
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo que modifica el id de categoria
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}

}
