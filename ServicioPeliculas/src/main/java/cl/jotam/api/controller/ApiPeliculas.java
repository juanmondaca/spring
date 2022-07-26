package cl.jotam.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.jotam.api.entidad.Pelicula;
import cl.jotam.api.entidad.wrapper.WraperListaPeliculas;
import cl.jotam.api.servicio.IServicioPeliculas;
import cl.jotam.api.servicio.ServicioPeliculas;

@RestController
@RequestMapping("/api/peliculas")
public class ApiPeliculas {

	private IServicioPeliculas sp = new ServicioPeliculas();
	
	@GetMapping("/listar")
	public WraperListaPeliculas listar(){
		List<Pelicula> lista = sp.listarTodasLasPeliculas();
		WraperListaPeliculas wlp = new WraperListaPeliculas();
		
		wlp.setListaPeliculas(lista);
		
		return wlp;
	}
}
