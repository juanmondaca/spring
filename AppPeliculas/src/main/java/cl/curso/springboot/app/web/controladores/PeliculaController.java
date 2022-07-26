package cl.curso.springboot.app.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.curso.springboot.app.modelos.entidades.Pelicula;
import cl.curso.springboot.app.modelos.servicios.IServicioPelicula;

@RequestMapping("/pel")
@Controller
public class PeliculaController {
	
	@Autowired
	private IServicioPelicula servicioPelicula;
	
	@RequestMapping(value = "/listarapi", method = RequestMethod.GET)
	public String listarApi(Model modelo) {
		modelo.addAttribute("tituloListar","Lista de las Peliculas");
		modelo.addAttribute("tituloBody","Peliculas");
		
		modelo.addAttribute("todasLasPeliculas", servicioPelicula.apiListar());
		return "listar";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listarPeliculas(Model modelo) {
		modelo.addAttribute("tituloListar","Lista de las Peliculas");
		modelo.addAttribute("tituloBody","Peliculas");
		
		modelo.addAttribute("todasLasPeliculas", servicioPelicula.listarTodas());
		return "listar";
	}
	
	@GetMapping(value = "/agregar")
	public ModelAndView agregarPelicula(ModelAndView modelo) {
		Pelicula pelicula = new Pelicula();
		
		modelo.addObject("pelicula", pelicula);
		
		modelo.addObject("tituloHeadAgregar", "Pagina de Agregar una nueva Pelicula");
		modelo.addObject("tituloBodyAgregar", "Agregar una nueva Pelicula");
		modelo.setViewName("agregar");
		
		return modelo;
	}
	
	@PostMapping(value="/agregar")
	public String grabarNuevaPelicula(Pelicula pelicula) {

		servicioPelicula.agregarPelicula(pelicula);
		
		return "redirect:listar";
	}
	
}
