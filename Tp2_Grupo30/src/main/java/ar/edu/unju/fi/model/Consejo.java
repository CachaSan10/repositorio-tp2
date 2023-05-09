package ar.edu.unju.fi.model;

import java.util.ArrayList;

public class Consejo {
	
	private String titulo;
	private ArrayList<String> parrafos;
	
	public Consejo() {
		super();
	}

	public Consejo(String titulo, ArrayList<String> parrafos) {
		super();
		this.titulo = titulo;
		this.parrafos = parrafos;
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
	
	

}
