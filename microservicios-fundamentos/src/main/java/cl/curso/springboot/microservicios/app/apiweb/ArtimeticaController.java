package cl.curso.springboot.microservicios.app.apiweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.curso.springboot.microservicios.app.servicios.IArtimeticaService;
@RestController
@RequestMapping("/api-aritmetica")
public class ArtimeticaController {

	@Autowired
	private IArtimeticaService as;
	@PostMapping("/opera/{n1}/{n2}/{op}")
	public Long operacionAritmetica(@PathVariable Long n1,
			@PathVariable Long n2,
			@PathVariable String op) {
		
		return this.as.operacionAritmetica(n1, n2, op);
	}
}
