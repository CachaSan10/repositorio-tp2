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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
//Se instancia objeto sucursal
@Component
@Entity
@Table(name="sucursales")
public class Sucursal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sucu_id")
	private Long id;
	
	@NotEmpty(message="El nombre de la sucursal no puede estar vacio")
	@Size(min=5, max=50,message="El nombre de sucursal debe tener entre 5 y 50 caracteres")
	@Column(name="sucu_nombre")
	private String nombre;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(min=5, max=50,message="El nombre de la direccion debe tener entre 5 y 50 caracteres")
	@Column(name="sucu_direccion")
	private String direccion;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(min=5, max=15,message="El nombre de provincia debe tener entre 5 y 15 caracteres")
	@Column(name="sucu_provincia")
	private String provincia;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "La fecha no puede ser nula")
	@FutureOrPresent(message = "La fecha debe ser hoy o posterior")
	@Column(name="sucu_fecha_inicio")
	private LocalDate fechaInicio;

	@Email(message = "Ingrese un mail valido")
	@NotEmpty(message="El mail de la sucursal no puede estar vacio")
	@Column(name="sucu_email")
	private String email;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(min=11, max=11,message="Ingrese un numero de telefono valido")
	@Column(name="sucu_telefono")
	private String telefono;
	@Column(name = "sucu_estado")
	private boolean estado;
	



	public Sucursal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Sucursal(Long id, String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
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


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
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
