package cl.curso.springboot.app.apirest.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/test/apirest")
public class TestLlamadaApiRest {

	@GetMapping(value = "/saludorest")
	public String mensajeSaludo(Model modelo) {
		// para consultar:
		// https://www.geeksforgeeks.org/how-to-call-or-consume-external-api-in-spring-boot/
		
		String uriApiRest = "http://localhost:8081/textos/saludo";
		RestTemplate rt = new RestTemplate();
		String resultadoLlamada = rt.getForObject(uriApiRest, String.class);
		
		modelo.addAttribute("saludoapi",resultadoLlamada);
		return "saludoRest";
	}
}
