package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Component
@Entity
@Table(name="empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empl_id")
	private Long id;
	/**Representa los nombres del paseador/paseadora*/
	@NotBlank(message="Debe ingresar los nombres")
	@Size(min=3,max=30, message="Los nombres deben tener entre 3 y 30 caracteres")
	@Pattern(regexp="[a-z A-ZÀ-ÿ\\u00f1\\u00d1]*", message="Los nombres solo pueden contener letras")
	@Column(name= "empl_nombres",nullable = false)
	private String nombres;
	/**Representa el apellido del paseador/paseadora*/
	@NotBlank(message="Debe ingresar un apellido")
	@Size(min=3,max=20, message="El apellido debe tener entre 3 y 30 caracteres")
	@Pattern(regexp="[a-z A-ZÀ-ÿ\\u00f1\\u00d1]*", message="El apellido solo puede contener letras")
	@Column(name= "empl_apellidos",nullable = false)
	private String apellido;
	/**Representa el dni del paseador/a o encargado/a*/
	@NotNull(message="Debe ingresar un dni")
	@Column(name= "empl_dni",length =10, nullable = false, unique=true)
	private Integer dni;
	/**Representa la fecha de nacimiento del paseador/a o encargado/a*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Debe ingresar la fecha de nacimiento")
	@Column(name= "empl_fecha de Nac", nullable = false)
	private LocalDate fechaNacimiento;
	/**Representa la dirección del paseador/a o encargado/a*/
	@NotBlank(message="Debe ingresar una dirección")
	@Column(name="empl_dirección", length =50, nullable = false)
	private String direccion;
	/**Representa el telefono del paseador/a o encargado/a*/
	@NotBlank(message="Debe ingresar una teléfono")
	@Column(name="empl_telefono", length =20, nullable = false)
	private String telefono;
	/**Representa si el estado es activo o pasivo del paseador/a o encargado/a*/
	@Column(name="empl_estado")
	private boolean estado;
		
	/**
	 * Constructor por defecto
	 */
	public Empleado() {
	}
	
	/**
	 * @param id
	 * @param nombres
	 * @param apellido
	 * @param dni
	 * @param fechaNacimiento
	 * @param direccion
	 * @param telefono
	 * @param estado
	
	 */
	public Empleado(String nombres, String apellido, Integer dni, LocalDate fechaNacimiento, String direccion, String telefono, boolean estado) {
		this.nombres = nombres;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
	}
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
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the dni
	 */
	public Integer getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(Integer dni) {
		this.dni = dni;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		return "Empleado [id=" + id + ", nombres=" + nombres + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento="
				+ fechaNacimiento + ", direccion=" + direccion + ", telefono=" + telefono + ", estado=" + estado + "]";
	}

	
}
