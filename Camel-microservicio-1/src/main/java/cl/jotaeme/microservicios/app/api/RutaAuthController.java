package cl.jotaeme.microservicios.app.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// api que usa una ruta Camel para llamar al servicios de Auth usuarios
@RestController
@RequestMapping(value = "/api-camel-auth")
public class RutaAuthController {
	@Autowired
	ProducerTemplate pt;
	
	@PostMapping("/validar/{usuario}/{pwd}")
	public String autentificaUsuario(@PathVariable("usuario") String nombreUsuario,
			@PathVariable("pwd") String pwdUsuario) {
		
		this.pt.start();
		
		Map<String, Object> paramHeaders = new HashMap<String, Object>();
		paramHeaders.put("nombre", nombreUsuario);
		paramHeaders.put("pwd",pwdUsuario);
		
		Object objRespuesta = this.pt.sendBodyAndHeaders("direct:llamada-api-auth-usuarios", null, null, paramHeaders); 
		
		this.pt.stop();
		
		System.out.println("objRespuesta :-> " + objRespuesta.toString());
		
		return objRespuesta.toString();
	}
}
