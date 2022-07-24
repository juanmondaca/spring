package cl.curso.springboot.app.modelos.daoDummy;

import java.util.List;

import cl.curso.springboot.app.modelos.entidades.Pelicula;

public interface IDaoDummy {
	
	public List<Pelicula> listarTodas();
	
	public void agregarPelicula(Pelicula pelicula);

}
