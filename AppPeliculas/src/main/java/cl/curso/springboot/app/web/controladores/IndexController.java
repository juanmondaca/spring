package cl.curso.springboot.app.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
	
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	@GetMapping(value = {"/index","/","/home"})
	public String index(Model modelo) {
		modelo.addAttribute("tituloForm", "Index!");
		modelo.addAttribute("tituloBody","App de Peliculas");
		return "index";
	}

}
