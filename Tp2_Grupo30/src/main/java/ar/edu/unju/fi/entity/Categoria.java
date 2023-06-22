/**
 * 
 */
package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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
	@NotEmpty()
	@Pattern(regexp="[a-z A-Z]*")
	@Size(min=5, max=20)
	@Column(name = "categoria_nombre")
	private String nombre;

	@Column(name = "categoria_estado")
	private boolean estado;
	
	@OneToMany(mappedBy = "categoria")
	private List<Producto> productos;
	
	
	/**
	 * Constructor por defecto
	 */
	public Categoria() {
	}

	/**
	 * Constructor Parametrizado
	 * @param id representa el id de la categoria
	 * @param nombre  representa el nombre de la categoria
	 * @param productos representa la lista de productos que pertence la categoria
	 */

	public Categoria(Long id, String nombre, boolean estado, List<Producto> productos) {
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.productos = productos;
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
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", productos=" + productos + "]";
	}

	
}
