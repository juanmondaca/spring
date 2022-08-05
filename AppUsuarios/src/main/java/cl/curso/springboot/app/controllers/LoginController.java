package cl.curso.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.curso.springboot.app.servicios.ILoginService;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	// usar este atributo e inyeccion en la demo de servicios	
	@Autowired
	private ILoginService loginService;
	
	// llama al formulario de login
	@GetMapping("/form-login")
	public String loginUsuario() {
		
		return "login/formLoginUsuario";
	}
	// metodo simple que valida las credenciales del usuario
	@PostMapping("/login-usuario")
	public String loginUsuario(
			@RequestParam(value = "nombreUsuario") String l,
			@RequestParam(value = "pwdUsuario") String pwd,
			Model modelo) {
		// 1. primera solucion: sin usar el servicio de Login
		// verifica el usuario y la pwd contra valores fijos
//		String nu = "usuario1";
//		String pw = "Pwd1";
//		
//		if(l.trim().equalsIgnoreCase(nu) && pwd.trim().equals(pw)) {
//			return "forward:/usuarios/listado";
//		}
		
		// 2. segunda solucion: usando el servicio de Login
		// primero inyectar el servicio en un atributo del controlador
		// segundo: usar el metodo de validacion
		if(loginService.validaCredenciales(l, pwd)) {
			return "forward:/usuarios/listado";
		}
		
		return "forward:/"; //  redirect:https://www.google.com
	}

}
