package cl.jotam.api.integracion;

import java.util.ArrayList;
import java.util.List;

import cl.jotam.api.entidad.Pelicula;

public class PeliculasRepositorio implements IPeliculasRepositorio {
	
	private List<Pelicula> peliculas;
	
	public PeliculasRepositorio() {
		peliculas = new ArrayList<Pelicula>();
		peliculas.add(new Pelicula(1, "The Matrix recargado", "SciFi", "Hermanos Wachowsky"));
		peliculas.add(new Pelicula(2, "Toys Story", "Infantil", "Pixar"));
		peliculas.add(new Pelicula(3, "Psicosis", "Thriller", "Hitchcock"));
	}

	@Override
	public List<Pelicula> listarTodasLasPeliculas() {
		// TODO Auto-generated method stub
		return this.peliculas;
	}

}
