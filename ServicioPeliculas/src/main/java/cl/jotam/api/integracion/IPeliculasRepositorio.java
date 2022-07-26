package cl.jotam.api.integracion;

import java.util.List;

import cl.jotam.api.entidad.Pelicula;

public interface IPeliculasRepositorio {
	
	public List<Pelicula> listarTodasLasPeliculas();

}
