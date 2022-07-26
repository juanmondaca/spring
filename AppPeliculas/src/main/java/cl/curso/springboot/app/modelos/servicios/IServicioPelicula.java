package cl.curso.springboot.app.modelos.servicios;

import java.util.List;

import cl.curso.springboot.app.modelos.entidades.Pelicula;

public interface IServicioPelicula {

	public List<Pelicula> listarTodas();
	
	public List<Pelicula> apiListar();
	
	public void agregarPelicula(Pelicula pelicula);
}
