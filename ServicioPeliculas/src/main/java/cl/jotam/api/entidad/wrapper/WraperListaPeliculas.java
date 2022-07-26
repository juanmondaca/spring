package cl.jotam.api.entidad.wrapper;

import java.util.ArrayList;
import java.util.List;

import cl.jotam.api.entidad.Pelicula;

public class WraperListaPeliculas {
	
	private List<Pelicula> listaPeliculas;
	
	public WraperListaPeliculas() {
		listaPeliculas = new ArrayList<Pelicula>();
	}

	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
	

}
