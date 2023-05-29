package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * Esta clase representa un Consejo de salud del sistema
 * @author Cachambi Nahuel Alberto
 *
 */
@Component
public class Consejo {

	private int id;
	private String titulo;
	private String parrafo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaPublicacion;

	
	/**
	 * Constructor por defecto
	 */
	public Consejo() {
	}

	
	
	/**
	 * Constructor Parametrizado
	 * @param id es el id de consejo de salud
	 * @param titulo es el titulo de consejo de salud
	 * @param parrafo es el parrafo de consejo de salud
	 * @param fechaPublicacion es la fecha de publicacion de consejo de salud
	 */
	public Consejo(int id, String titulo, String parrafo, LocalDate fechaPublicacion) {
		this.id = id;
		this.titulo = titulo;
		this.parrafo = parrafo;
		this.fechaPublicacion = fechaPublicacion;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getParrafo() {
		return parrafo;
	}

	public void setParrafo(String parrafo) {
		this.parrafo = parrafo;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

}
