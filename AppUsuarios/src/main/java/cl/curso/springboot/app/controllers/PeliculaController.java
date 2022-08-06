package cl.curso.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.curso.springboot.app.entidad.Pelicula;
import cl.curso.springboot.app.servicios.IPeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	// iinyectar el servicio de Peliculas
	@Autowired
	private IPeliculaService peliculaService;
	
	// obtener todas las peliculas
	@GetMapping("/lista")
	public String todasLasPeliculas(Model modelo) {
		modelo.addAttribute("listaPeliculas",this.peliculaService.findAll());
		return "pelicula/lista";
	}
	// Agregar ***********************************************************
	// llama form de agregar nueva pelicula
	@GetMapping("/form-agregar")
	public String formNuevaPelicula(Model modelo) {
		Pelicula pel = new Pelicula();;
		modelo.addAttribute("pelicula",pel);
		return "pelicula/formAgregarPelicula";
	}
	
	// llama a servicio de agregar la nueva peliicula
	@PostMapping("/agregar-pelicula-post")
	public String agregarPelicula(
			Pelicula pelicula,
			Model modelo) {
		peliculaService.save(pelicula);
		modelo.addAttribute("listaPeliculas",this.peliculaService.findAll());
		return "pelicula/lista";
	}
	// Actualizar **********************************************************
	// Actulizar los datos de un pelicula dado su id
	@GetMapping("/form-actualizar")
	public String formActualizarPelicula() {
		
		return "/pelicula/formActualizarPelicula";
	}
	
	// llama a servicio de agregar la nueva peliicula
	@PostMapping("/actualizar-pelicula-post")
	public String actualizarPelicula(
			@RequestParam Long idPelicula,
			@RequestParam String nombrePelicula,
			@RequestParam String generoPelicula,
			@RequestParam String directorPelicula,
			Model modelo) {
		// buscamos la pelicula para ver si existe
		Pelicula pel = this.peliculaService.findOne(idPelicula);
		if(pel != null) {
			// si existe actualizamos los datos
			pel.setNombrePelicula(nombrePelicula);
			pel.setDirectorPelicula(directorPelicula);
			pel.setGeneroPelicula(generoPelicula);
			// grabar la actualizacion
			peliculaService.save(pel);
		}
		
		modelo.addAttribute("listaPeliculas",this.peliculaService.findAll());
		return "pelicula/lista";
	}

}
