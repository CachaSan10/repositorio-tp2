package ar.edu.unju.fi.model;

public class Consejo {

	private String titulo;
	private String parrafo;
	private String imagenes;

	public Consejo() {
	}

	public Consejo(String titulo, String parrafo, String imagenes) {
		this.titulo = titulo;
		this.parrafo = parrafo;
		this.imagenes = imagenes;
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

	public String getImagenes() {
		return imagenes;
	}

	public void setImagenes(String imagenes) {
		this.imagenes = imagenes;
	}

}
