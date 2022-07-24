package cl.curso.springboot.microservicios.app.apiweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.curso.springboot.microservicios.app.servicios.ServiciosTexto;

@RestController
@RequestMapping(value = "/textos")
public class TextoController {
	
	@Autowired
	private ServiciosTexto serviciosTexto;
	
	@GetMapping(value = {"/saludo"})
	public String saludo() {
		return "hola a todos desde una api rest !";
	}
	
	@RequestMapping(value = "/largo")
	public String comparaLargosTextos(@RequestParam() String t1, @RequestParam String t2) {
		
		return serviciosTexto.textoMasLargo(t1, t2);
	}

}
