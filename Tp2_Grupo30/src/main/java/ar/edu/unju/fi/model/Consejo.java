package ar.edu.unju.fi.model;

import java.util.ArrayList;

public class Consejo {
	
	private String titulo;
	private ArrayList<String> parrafos;
	private String imagenes;
	
	public Consejo() {
		super();
	}

	

	public Consejo(String titulo, ArrayList<String> parrafos, String imagenes) {
		super();
		this.titulo = titulo;
		this.parrafos = parrafos;
		this.imagenes = imagenes;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<String> getParrafos() {
		return parrafos;
	}

	public void setParrafos(ArrayList<String> parrafos) {
		this.parrafos = parrafos;
	}



	public String getImagenes() {
		return imagenes;
	}



	public void setImagenes(String imagenes) {
		this.imagenes = imagenes;
	}
	
	

}
