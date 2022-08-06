package cl.curso.springboot.app.servicios;

import java.util.List;

import cl.curso.springboot.app.entidad.Pelicula;

public interface IPeliculaService {
	
	public List<Pelicula> findAll() ;

	public void save(Pelicula pelicula) ;

	public Pelicula findOne(Long id) ;

	public void delete(Long id);


}
