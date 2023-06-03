package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
//Se instancia objeto sucursal
@Component
public class Sucursal {
	private int codigo;
	@NotEmpty(message="El nombre de la sucursal no puede estar vacio")
	@Size(min=3, max=10,message="El nombre de sucursal debe tener entre 3 y 10 caracteres")
	private String nombre;
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(min=10, max=30,message="El nombre de la direccion debe tener entre 10 y 30 caracteres")
	private String direccion;
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(min=5, max=15,message="El nombre de provincia debe tener entre 5 y 15 caracteres")
	private String provincia;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "La fecha no puede ser nula")
	@FutureOrPresent(message = "La fecha debe ser hoy o posterior")
	private LocalDate fechaInicio;
	@Email(message = "Ingrese un mail valido")
	@NotEmpty(message="El mail de la sucursal no puede estar vacio")
	private String email;
	@NotEmpty(message="Este campo no puede estar vacio")
	@Size(min=11, max=11,message="Ingrese un numero de telefono valido")
	private String telefono;
	
	public Sucursal() {
		// TODO Auto-generated constructor stub
	}

	public Sucursal(int codigo, String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		return "Sucursal [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", provincia="
				+ provincia + ", fechaInicio=" + fechaInicio + ", email=" + email + ", telefono=" + telefono + "]";
	}
	
	
	
	
	
}
