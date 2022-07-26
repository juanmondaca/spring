package cl.jotam.api.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.jotam.api.entidad.Pelicula;
import cl.jotam.api.integracion.IPeliculasRepositorio;
import cl.jotam.api.integracion.PeliculasRepositorio;

@Service
public class ServicioPeliculas implements IServicioPeliculas{

	private IPeliculasRepositorio pr = new PeliculasRepositorio();
	
	public List<Pelicula> listarTodasLasPeliculas(){
		
		return this.pr.listarTodasLasPeliculas();
	}
	
	
}
