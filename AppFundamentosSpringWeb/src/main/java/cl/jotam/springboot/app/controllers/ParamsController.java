package cl.jotam.springboot.app.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	// probar desde el browser con http://localhost:8080/params/p1?texto=Hola Mundo
	// si el parameetro no va sale error
	@GetMapping("/p1")
	public String param(@RequestParam(name="texto", required = true, defaultValue = "inicio") String texto, Model modelo)
	{
		modelo.addAttribute("pTexto","El valor del param enviado es: " + texto);
		return "params/ver";
	}

	@GetMapping("/")
	public String param2(Model modelo) {
		
		return "/params/index";
	}
	// segunda parte del ejercicio: varios parametrtos con RequestParam
	@GetMapping("/varios-params")
	public String param(@RequestParam String texto, 
			@RequestParam Integer numero,Model modelo)
	{
		modelo.addAttribute("pTexto","El valor del text enviado es: " + texto + ", ya del numero es : " +
							numero);
		return "params/ver";
	}
	// tercera parte usar HttpServletRequest para obtener los paramtros
	@GetMapping("/request-params")
	public String param(HttpServletRequest request,Model modelo)
	{
		String texto   = request.getParameter("texto");
		Integer numero = null;
		try {	
			numero = Integer.parseInt(request.getParameter("numero"));
		}
		catch(NumberFormatException nfe) {
			numero = -100;
		}
		modelo.addAttribute("pTexto","El valor del text enviado es: " + texto + ", ya del numero es : " +
							numero);
		return "params/ver";
	}
	
	
}
