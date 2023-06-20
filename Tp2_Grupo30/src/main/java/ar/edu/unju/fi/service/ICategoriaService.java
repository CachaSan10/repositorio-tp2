package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Categoria;

public interface ICategoriaService {
	
	public Categoria getCategoria();
	public void guardarCategoria(Categoria categoria);
	public void modificarCategoria(Categoria categoria);
	public void eliminarCategoria(Long id);
	public Categoria buscarCategoria(Long id);
	public List<Categoria> getLista();
 
}
