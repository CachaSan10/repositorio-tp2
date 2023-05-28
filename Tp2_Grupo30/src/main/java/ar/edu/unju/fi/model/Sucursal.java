package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
//Se instancia objeto sucursal
@Component
public class Sucursal {
	private int codigo;
	private String nombre;
	private String direccion;
	private String provincia;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio;
	private String email;
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
