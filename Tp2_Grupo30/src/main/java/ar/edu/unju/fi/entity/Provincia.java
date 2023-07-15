package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

/**
 * Clase que representa la provincia en el sistema
 */
@Component
@Entity
@Table(name="provincias")
public class Provincia {

	/**Representa el id de la provincia */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prov_id")
	private Long id;
	
	/**Representa el nombre de la provincia */
    @NotEmpty(message="El nombre de la provincia no puede estar vacio")
    @Size(min=5, max=50,message="El nombre de provincia debe tener entre 5 y 50 caracteres")
	@Column(name="prov_nombre")
	private String nombre;
	
	/**Representa la fecha de la provincia */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "La fecha debe ser anterior a la fecha actual")
	@Column(name="prov_fecha")
	private LocalDate fechaCreacion;
	
	/**Representa el codigo postal de la provinicia */
	@Min(value = 1000, message = "El código postal debe tener al menos 4 dígitos")
	@Max(value = 9999, message = "El código postal debe tener máximo 4 dígitos")
	@Column(name="prov_cp")
	private int codigoPostal;
	
	
	@OneToMany(mappedBy = "provincia")
	private List<Sucursal> sucursales;
	
	/**Representa el estado de la provincia */
	@Column(name="prov_estado")
	private boolean estado;

	
	/**Constructor por defecto */
	public Provincia() {
		
	}

	/**
	 * Constructor parametrizado
	 * @param id representa el id de la provincia
	 * @param nombre representa el nombre de la provinicia
	 * @param fechaCreacion representa la fecha de creacion de la provincia
	 * @param codigoPostal representa el codido postal de la provincia
	 * @param estado representa el estado de la provincia
	 */
	public Provincia(Long id, String nombre, LocalDate fechaCreacion, int codigoPostal, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.codigoPostal = codigoPostal;
		this.estado = estado;
	}
	

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
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

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", codigoPostal="
				+ codigoPostal + ", sucursales=" + sucursales + ", estado=" + estado + "]";
	}
	
	
	
	
}
