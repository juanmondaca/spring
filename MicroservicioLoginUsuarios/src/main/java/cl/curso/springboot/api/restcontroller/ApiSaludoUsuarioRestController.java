package cl.curso.springboot.api.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiSaludoUsuarioRestController {
	@GetMapping("/saludo")
	public String mensajeSaludo() {
		
		return "Bienvenido usuario";
	}

}
