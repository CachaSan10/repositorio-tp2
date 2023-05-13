package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Consejo {

	private String titulo;
	private String parrafo;
	private LocalDate fechaPublicacion;

	public Consejo() {
	}

	

	public Consejo(String titulo, String parrafo, LocalDate fechaPublicacion) {
		this.titulo = titulo;
		this.parrafo = parrafo;
		this.fechaPublicacion = fechaPublicacion;
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
