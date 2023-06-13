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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Esta clase representa un Consejo de salud del sistema
 * 
 * @author Cachambi Nahuel Alberto
 *
 */
@Component
@Entity
@Table(name = "consejos")
public class Consejo {

	// Representa el id de consejo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consejo_id")
	private int id;
	
	// Representa el titulo de consejo
	@NotEmpty()
	@NotBlank()
	@Size(min = 10, max = 100)
	@Column(name = "consejo_titulo", nullable = false)
	private String titulo;
	
	// Representa el parrafo de consejo
	@NotEmpty()
	@NotBlank()
	@Size(min = 10, max = 5000)
	@Column(name = "consejo_parrafo", nullable = false)
	private String parrafo;
	
	// Representa la fecha de publicacion de consejo
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "consejo_fecha_publicacion")
	private LocalDate fechaPublicacion;

	// Representa la imagen de consejo
	@Column(name = "consejo_imagen", length = 30, nullable = false)
	private String imagen;

	/**
	 * Constructor por defecto
	 */
	public Consejo() {
	}

	/**
	 * Constructor Parametrizado
	 * 
	 * @param id               es el id de consejo de salud.
	 * @param titulo           es el titulo de consejo de salud.
	 * @param parrafo          es el parrafo de consejo de salud.
	 * @param fechaPublicacion es la fecha de publicacion de consejo de salud.
	 * @param imagen           es la imagen de la publicacion de consejo de salud.
	 */
	public Consejo(int id, @NotEmpty @NotBlank @Size(min = 10, max = 100) String titulo,
			@NotEmpty @NotBlank @Size(min = 10, max = 100) String parrafo, LocalDate fechaPublicacion, String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.parrafo = parrafo;
		this.fechaPublicacion = fechaPublicacion;
		this.imagen = imagen;
	}

	/**
	 * Metodo que retorna el id de consejo
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que modifica el id de consejo
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que retorna el titulo de consejo
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo que modifica el titulo de consejo
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Metodo que retorna el parrafo de consejo
	 * @return the parrafo
	 */
	public String getParrafo() {
		return parrafo;
	}

	/**
	 * Metodo que modifica el parrafo de consejo
	 * @param parrafo the parrafo to set
	 */
	public void setParrafo(String parrafo) {
		this.parrafo = parrafo;
	}

	/**
	 * Metodo que retorna la fecha de publicacion de consejo
	 * @return the fechaPublicacion
	 */
	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	/**
	 * Metodo que modifica la fecha de publicacion de consejo
	 * @param fechaPublicacion the fechaPublicacion to set
	 */
	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * Metodo que retorna la imagen de consejo
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Metodo que modifica la imagen de consejo
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Consejo [id=" + id + ", titulo=" + titulo + ", parrafo=" + parrafo + ", fechaPublicacion="
				+ fechaPublicacion + ", imagen=" + imagen + "]";
	}

}
