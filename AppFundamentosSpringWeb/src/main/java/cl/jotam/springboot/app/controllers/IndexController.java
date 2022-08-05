package cl.jotam.springboot.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jotam.springboot.app.modelos.Usuario;

@Controller
public class IndexController {
	// estos atributo se usan en la demo de @Value
	
	@Value("${texto.indexcontroller.index.tituloForm}")
	private String titForm;
	@Value("${texto.indexcontroller.index.tituloBody}")
	private String titBody;

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	@GetMapping("/saludo")
	public String saludo(Model modelo) {

		modelo.addAttribute("tituloForm", "Titulo de la pagina");
		modelo.addAttribute("tituloBody", "Pagina de saludo !");
		return "saludo";
	}

	@GetMapping("/perfil")
	public String perfilUsuario(Model modelo) {
		Usuario usa = new Usuario();
		usa.setNombre("Alan");
		usa.setApelliido("Turing");
		// no agregar email para mostrar if en thymeleaf

		modelo.addAttribute("tituloPrincipalPerfil", "Pagina del perfil de usuario");
		modelo.addAttribute("tituloBodyPerfil", "Perfil del usuario !".concat(usa.getNombre()));
		modelo.addAttribute("usuario", usa);

		return "perfilUsuario";
	}

	@RequestMapping("/listado")
	public String listado(Model modelo) {

		List<Usuario> listado = new ArrayList<Usuario>();
		// primero probar con la lista vacia
		// luego agregar usuarios
		listado.add(new Usuario("Arturo", "Prat", "ap@curso.cl"));
		listado.add(new Usuario("Ana", "Tijoux", "at@curso.cl"));
		listado.add(new Usuario("Han", "Solo", "hs@curso.cl"));

		modelo.addAttribute("tituloBodyListado", "Listado de usuarios");

		modelo.addAttribute("listaUsuarios", listado);

		return "listado";
	}

	// este metodo es usado por cualquier vista que use "atributoListaUsuarios" en
	// su template
	// el metodo llena la lista y la devuelve a la vista que la pida. Es un codigo reusable
	// No requiere RequestMapping
	@ModelAttribute("atributoListaUsuarios")
	public List<Usuario> poblarUsuarios() {
		// aca una alternativa para llenar una lista en Java
		List<Usuario> listado = Arrays.asList(new Usuario("Arturo", "Prat", "ap@curso.cl"),
				new Usuario("Ana", "Tijoux", "at@curso.cl"), new Usuario("Han", "Solo", "hs@curso.cl"));
		return listado;
	}
	// para probar el metodo poblarUsuarios usar la vista listado2.html
	@GetMapping("/listado2")
	public String listado2(Model modelo) {
		modelo.addAttribute("tituloBodyListado", "Listado 2 de usuarios");

		return "listado2";
	}
	
	// para demo de anotacion @Value
	@GetMapping("/saludo2")
	public String saludo2(Model modelo) {

		modelo.addAttribute("tituloForm", this.titForm);
		modelo.addAttribute("tituloBody", this.titBody);
		return "saludo2";
	}
	
	
	
	
}
