package cl.curso.springboot.microservicios.app.apiweb;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/operaciones")
public class NumerosRest {


	@RequestMapping(value="/sumar")
	public int sumar2numeros(@RequestParam() int n1, @RequestParam() int n2) {
		return n1  + n2;
	}
	// mas info en https://www.baeldung.com/spring-pathvariable
	@PostMapping(value = "/multiplicar/{n1}/{n2}")
	public int multiplicar2numeros(@PathVariable int n1, @PathVariable int n2) {
		
		return n1 * n2;
	}
}
