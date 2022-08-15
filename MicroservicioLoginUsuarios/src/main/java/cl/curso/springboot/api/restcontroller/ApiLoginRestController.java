package cl.curso.springboot.api.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.curso.springboot.api.servicios.ILoginService;

@RestController
@RequestMapping(value = "/api-auth")
public class ApiLoginRestController {

	@Autowired
	private ILoginService servicioLogin;
	@PostMapping("/login/{nombre}/{pwd}")
	//@GetgMapping("/login")
	public boolean validarCredenciales(@PathVariable String nombre, @PathVariable String pwd) {
		boolean respuesta = false;
		
		respuesta = this.servicioLogin.validaCredenciales(nombre, pwd);
		return respuesta;
	}
}
