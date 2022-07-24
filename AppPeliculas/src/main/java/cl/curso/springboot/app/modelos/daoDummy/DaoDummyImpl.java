package cl.curso.springboot.app.modelos.daoDummy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import cl.curso.springboot.app.modelos.entidades.Pelicula;

@Repository
//@Component
public class DaoDummyImpl implements IDaoDummy{
	
	private List<Pelicula> listaDeTodasLasPeliculas = new ArrayList<Pelicula>();
	
	public DaoDummyImpl() {
			
		listaDeTodasLasPeliculas.add(new Pelicula(1, "The Matrix", "SciFi", "Hermanos Wachowsky"));
		listaDeTodasLasPeliculas.add(new Pelicula(2, "Toys Story", "Infantil", "Pixar"));
		listaDeTodasLasPeliculas.add(new Pelicula(3, "Psicosis", "Thriller", "Hitchcock"));
	}

	@Override
	public List<Pelicula> listarTodas() {
		// TODO Listar todas las peliculas
		
		return listaDeTodasLasPeliculas;
	}

	@Override
	public void agregarPelicula(Pelicula pelicula) {
		// TODO Agregar la nueva pelicula a la BD
		listaDeTodasLasPeliculas.add(pelicula);
		System.out.println("Pelicula agregada a la BD");
	}

}
