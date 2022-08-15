package cl.jotaeme.microservicios.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.jotaeme.microservicios.app.servicios.GeneraTokenService;

@RestController
@RequestMapping(value = "/api-token")
public class GeneratTokenController {

	@Autowired
	private GeneraTokenService gts;
	
	@PostMapping(value = "/crear/{nombreusuario}/{statususuario}")
	public String creaTokenUsuario(@PathVariable("nombreusuario") String nombre,
			@PathVariable("statususuario") String status) {
		
		return this.gts.nuevoTicket(nombre, status);
		
	}
}
