package cl.jotam.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.jotam.springboot.app.modelos.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public UsuarioController() {
		// TODO Crear los usuarios inciales
		listaUsuarios.add(new Usuario("Arturo", "Prat", "ap@curso.cl"));
		listaUsuarios.add(new Usuario("Ana", "Tijoux", "at@curso.cl"));
		listaUsuarios.add(new Usuario("Han", "Solo", "hs@curso.cl"));
	}
	
	@RequestMapping("/crud")
	public String homeUsuarios(Model modelo) {
		// se muestra un ejemplo de la funcion agregarUsuario
		// para esto se necesita un objeto de tipo usuario en el Model
		Usuario usua =  new Usuario();
		modelo.addAttribute("usuario",usua);
		// se llama a la vista para agregar un nuevo Usuario
		return "/usuarios/agregarUsuarioPost"; // /usuarios/agregarUsuario   para el caso GET
	}
	
	@RequestMapping("/agregar")
	public String agregarUsuario(@RequestParam String nombre, 
		@RequestParam String apelliido, @RequestParam  String email, Model modelo) {
		// crea un nuevo POJO Usuario con los datos recibidos y los agrega a listaUsuarios
		
		Usuario usua = new Usuario(nombre,apelliido,email);
		listaUsuarios.add(usua);
		
		modelo.addAttribute("tituloBodyListado","Lista de todos los usuarios");
		modelo.addAttribute("listaUsuarios", this.listaUsuarios);
		
		return "/usuarios/listadoUsuarios";
	}
	
	@PostMapping("/agregarpost")
	public String agregarUsuario(Usuario usuario, Model modelo) {

		// Agrega el POJO que viene en el request POST a la lista directamente
		listaUsuarios.add(usuario);

		modelo.addAttribute("listaUsuarios", this.listaUsuarios);
		
		return "/usuarios/listadoUsuarios";
	}

}
