package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Component
@Entity
@Table(name="Categorias")
public class CategoriaEmpleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "cat_id")
	private Long id;
	@NotBlank(message="Debe ingresar una categoria")
	@Size(min=3,max=20, message="Los nombres deben tener entre 3 y 20 caracteres")
	@Pattern(regexp="[a-z A-Z]*", message="Las categorias solo pueden contener letras")
	@Column(name= "cat_nombre",nullable = false)
	private String nombre;
	@Column(name = "cat_estado")
	private boolean estado;
	
	/**
	 * Constructor por defecto
	 */
	public CategoriaEmpleado() {
	}
	/**
	 * @param nombre
	 */
	public CategoriaEmpleado(String nombre) {
		this.nombre = nombre;
	}
	/**Declacion de los getters and setters */
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "CategoriaEmpleado [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
		
}
