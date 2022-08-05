package cl.jotam.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pathVariables")
public class PathVariableController {
	// para probar este controlador hacerlo con:
	// http://localhost:8080/pathVariables/string/Algun texto
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable(name="texto") String texto, Model modelo) {
		
		modelo.addAttribute("titulo","Recibir parametro de la ruta con @PathVariable");
		modelo.addAttribute("pTexto","El valor del text enviado en la ruta es: " + texto);
		return "/pathVariables/ver";
	}
	// con mas pathvariables
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable(name="texto") String texto,
			@PathVariable Integer numero, Model modelo) {
		
		modelo.addAttribute("titulo","Recibir parametro de la ruta con @PathVariable");
		modelo.addAttribute("pTexto","El valor del texto enviado en la ruta es: " + texto 
				+ ", y el valos del numero es : " + numero);
		return "/pathVariables/ver";
	}
	// para definir un metodo handler index
	@RequestMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("titulo","Enviar parametro de la ruta con @PathVariable");
		return "/pathVariables/index";
	}
}
