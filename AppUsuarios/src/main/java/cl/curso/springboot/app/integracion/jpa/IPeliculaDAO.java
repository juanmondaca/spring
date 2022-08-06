package cl.curso.springboot.app.integracion.jpa;

import java.util.List;

import cl.curso.springboot.app.entidad.Pelicula;

public interface IPeliculaDAO {
	
	public List<Pelicula> findAll();
	
	public void save(Pelicula pelicula);
	
	public Pelicula findOne(Long id);
	
	public void delete(Long id);
	
	
	

}
