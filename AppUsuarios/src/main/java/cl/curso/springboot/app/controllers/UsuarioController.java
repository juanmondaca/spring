package cl.curso.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.curso.springboot.app.entidad.Usuario;
import cl.curso.springboot.app.servicios.IUsuarioService;

// Operaaciones CRUD sobre Usuario
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	/********
	// para demo de operaciones CRUD con Usuario y con JPA ... inyectar servcicio
	*********/
	@Autowired
	private IUsuarioService us;
	// ***************************
	
	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public UsuarioController() {
		listaUsuarios.add(new Usuario("Juan", "Perez", "jp@b.cl"));
		listaUsuarios.add(new Usuario("Ana", "Rojas", "ar@b.cl"));
		listaUsuarios.add(new Usuario("Maria", "Gonzalez", "mg@b.cl"));
	}
	/**********
	 * 
	 * Para demo de JPA con Usuario ... Listar todos los usuarios
	 */
	@RequestMapping(value = "/listado-jpa")
	public String listaUsariosJPA(Model m) {
		m.addAttribute("tituloPagina","Lista de usuarios");
		m.addAttribute("tituloBody","Listado de todos los usuarios");
		m.addAttribute("listaDeUsuarios",this.us.listar());
		return "usuarios/listadoUsuarios";
	}
	/**********
	 * 
	 * Para demo de JPA con Usuario ... Agregar un nuevo usuario
	 */
	
	@GetMapping("/agregar-usuario-get-jpa")
	public String agregarUsuarioJPA(@RequestParam String nombreUsuario,
			@RequestParam String apellidoUsuario,
			@RequestParam String emailUsuario,
			Model modelo) {
		
		Usuario nuevoUsuario = new Usuario(nombreUsuario, apellidoUsuario, emailUsuario);
		this.us.grabar(nuevoUsuario);
		modelo.addAttribute("listaDeUsuarios",this.us.listar());
		return "usuarios/listadoUsuarios";
	}
	// este metodo llama a la vista formUsuariosGetJPA
	@GetMapping("/form-get-jpa")
	public String datosUsuariosJPA() {
		return "usuarios/formUsuariosGetJPA";
	}
	// ***************************
	
	
	// listar todos los usuarios
	@RequestMapping("/listado")
	public String listaUsuarios(Model m) {
		
		m.addAttribute("tituloPagina","Lista de usuarios");
		m.addAttribute("tituloBody","Listado de todos los usuarios");
		m.addAttribute("listaDeUsuarios",this.listaUsuarios);
		return "usuarios/listadoUsuarios";
	}
	// agregar un nuevo usuario a la listaUsuarios
	// 1. Via GET
	@GetMapping("/form-get")
	public String datosUsuarios() {
		return "usuarios/formUsuariosGet";
	}
	
	@GetMapping("/agregar-usuario-get")
	public String agregarUsuario(@RequestParam String nombreUsuario,
			@RequestParam String apellidoUsuario,
			@RequestParam String emailUsuario,
			Model modelo) {
		
		Usuario nuevoUsuario = new Usuario(nombreUsuario, apellidoUsuario, emailUsuario);
		this.listaUsuarios.add(nuevoUsuario);
		modelo.addAttribute("listaDeUsuarios",this.listaUsuarios);
		return "usuarios/listadoUsuarios";
	}
	// Via POST
	@GetMapping("/form-post")
	public String datosUsuariosPost(Model modelo) {
		// para esto se necesita un objeto de tipo usuario en el Model
		Usuario usua =  new Usuario();
		modelo.addAttribute("usuario",usua);
		return "usuarios/formUsuariosPost";
	}
	
	@PostMapping("/agregar-usuario-post")
	public String agregarUsuario(Usuario usuario, Model modelo) {

		// Agrega el POJO que viene en el request POST a la lista directamente
		this.listaUsuarios.add(usuario);

		modelo.addAttribute("listaDeUsuarios", this.listaUsuarios);
		
		return "/usuarios/listadoUsuarios";
	}
	// Modificar un usuario *****************************************
	// 1. metodo que llama al form de modificar
	@GetMapping("/form-modificar")
	public String formModificarUsuario() {
		
		return "/usuarios/formModificarUsuario";
	}
	//2. metodo que realiza la modificacion
	@PostMapping("/modificar-usuario")
	public String modificarUsuario(@RequestParam String emailUsuario,
			@RequestParam() String nombreUsuario, 
			@RequestParam String apellidoUsuario,
			Model modelo) {
		
		// busca un usuario por email y si lo encuentra
		// actualiza su nombre y apellido
		for(Usuario u : this.listaUsuarios) {
			if(u.getEmail().equalsIgnoreCase(emailUsuario.trim())) {
				u.setApellido(apellidoUsuario);
				u.setNombre(nombreUsuario);
				break;
			}
		}
		modelo.addAttribute("listaDeUsuarios",this.listaUsuarios);
		return "usuarios/listadoUsuarios";
	}
	// Eliminar un Usuario dado un email *****************************
	//1. Llamar al form para eliminar
	@GetMapping("/form-eliminar")
	public String formEliminarUsuario() {
		
		return "usuarios/formEliminarUsuario";
	}
	// 2. Elimina al primer usuario que coincida con el email
	@PostMapping("/eliminar-usuario")
	public String eliminarUsuario(@RequestParam String emailUsuario,
			Model modelo) {
		for(Usuario u : this.listaUsuarios) {
			if(u.getEmail().equalsIgnoreCase(emailUsuario.trim())) {
				this.listaUsuarios.remove(u);
				break;
			}
		}
		modelo.addAttribute("listaDeUsuarios",this.listaUsuarios);
		return "usuarios/listadoUsuarios";
	}
	
	// listado que usa @ModelAttribute ******************************
	@RequestMapping("/listado-actual")
	public String listaUsuariosActualizad(Model m) {
		
		m.addAttribute("tituloPagina","Lista de usuarios actualizado ");
		m.addAttribute("tituloBody","Listado de todos los usuarios actualizados");
		//m.addAttribute("listaUsuarios",this.listaUsuarios);
		return "usuarios/listadoUsuarios2";
	}
//	@ModelAttribute("listaUsuarios")
//	public List<Usuario> poblarUsuarios(){
//		// actualiza la lista de usuarios
//		listaUsuarios.add(new Usuario("John", "Perez", "jp@b.cl"));
//		listaUsuarios.add(new Usuario("Ane", "Rojas", "ar@b.cl"));
//		listaUsuarios.add(new Usuario("Mary", "Gonzalez", "mg@b.cl"));
//		
//		return this.listaUsuarios;
//	}
	
}
