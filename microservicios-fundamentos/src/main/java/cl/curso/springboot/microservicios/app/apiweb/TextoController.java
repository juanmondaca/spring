package cl.curso.springboot.microservicios.app.apiweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cl.curso.springboot.microservicios.app.servicios.ServiciosTexto;

@RestController
@RequestMapping(value = "/textos")
public class TextoController {
	
	@Autowired
	private ServiciosTexto serviciosTexto;
	
	@GetMapping(value = {"/saludo"})
	public boolean saludo() {
		return true; //"hola a todos desde una api rest !";
	}
	
	@RequestMapping(value = "/largo")
	public String comparaLargosTextos(@RequestParam() String t1, @RequestParam String t2) {
		
		return serviciosTexto.textoMasLargo(t1, t2);
	}	
	


}
