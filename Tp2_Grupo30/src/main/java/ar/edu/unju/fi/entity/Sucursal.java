package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Representa la clase sucursal en el sistema
 */
@Component
@Entity
@Table(name="sucursales")
public class Sucursal {

	/**Representa el id de la sucursal */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sucu_id")
	private Long id;
	
	/**
	 * Representa el nombre de la sucursal
	 */
	@NotEmpty(message="El nombre de la sucursal no puede estar vacio")
	@Size(min=5, max=50,message="El nombre de sucursal debe tener entre 5 y 50 caracteres")
	@Column(name="sucu_nombre")
	private String nombre;
	
	/**
	 * Representa la direccion de la sucursal
	 */
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(min=5, max=50,message="El nombre de la direccion debe tener entre 5 y 50 caracteres")
	@Column(name="sucu_direccion")
	private String direccion;
	
	/**
	 * Representa la fecha de inicio de la sucursal
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "La fecha no puede ser nula")
	@FutureOrPresent(message = "La fecha debe ser hoy o posterior")
	@Column(name="sucu_fecha_inicio")
	private LocalDate fechaInicio;
	
	/**
	 * Representa el email de la sucursal
	 */
	@Email(message = "Ingrese un mail valido")
	@NotEmpty(message="El mail de la sucursal no puede estar vacio")
	@Column(name="sucu_email")
	private String email;
	
	/**
	 * Representa el telefono de la sucursal
	 */
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(min=11, max=11,message="Ingrese un numero de telefono valido")
	@Column(name="sucu_telefono")
	private String telefono;

	/**
	 * Representa el estado de la sucursal
	 */
	@Column(name = "sucu_estado")
	private boolean estado;

	@NotNull(message="Debe seleccionar una provincia")
	@ManyToOne
	@JoinColumn(name = "provincia_id")
	private Provincia provincia;



	/**
	 * Constructor por defecto
	 */
	public Sucursal() {
		
	}


	/**
	 * Constructor parametrizado 
	 * @param id representa el id de la sucursal
	 * @param nombre representa el nombre de la sucursal
	 * @param direccion representa la direccion de la sucursal
 	 * @param fechaInicio representa la fecha de inicio de la sucursal
 	 * @param email representa el email de la sucursal
	 * @param telefono representa el telefono de la sucursal
	 * @param estado representa eñ estado de la sucursal
	 * @param provincia representa la provincia donde se ubica la sucursal
	 */
	public Sucursal(Long id, String nombre, String direccion, LocalDate fechaInicio, String email,
			String telefono, boolean estado, Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaInicio = fechaInicio;
		
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
		this.provincia = provincia;
	}

	
	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}





	public boolean isEstado() {
		return estado;
	}





	public void setEstado(boolean estado) {
		this.estado = estado;
	}





	@Override
	public String toString() {
		return "Sucursal [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", provincia=" + provincia
				+ ", fechaInicio=" + fechaInicio + ", email=" + email + ", telefono=" + telefono + ", estado=" + estado
				+ "]";
	}


	
	
	

}
