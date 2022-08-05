package cl.curso.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class LoginController {
	// llama al formulario de login
	@GetMapping("/form-login")
	public String loginUsuario() {
		
		return "login/formLoginUsuario";
	}
	// metodo que valida las credenciales del usuario
	@PostMapping("/login-usuario")
	public String loginUsuario(
			@RequestParam(value = "nombreUsuario") String l,
			@RequestParam(value = "pwdUsuario") String pwd,
			Model modelo) {
		
		// verifica el usurio y la pwd contra valores fijos
		String nu = "usuario1";
		String pw = "Pwd1";
		
		if(l.trim().equalsIgnoreCase(nu) && pwd.trim().equals(pw)) {
			return "forward:/usuarios/listado";
		}
		
		return "forward:/";
	}

}
