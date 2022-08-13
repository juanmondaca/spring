package cl.curso.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping("/")
	public String home(Model modelo) {
		modelo.addAttribute("titulo","Autentificacion de Usuario");
		return "/home/index";
	}

	@PostMapping("/log")
	public String homeapp(Model modelo) {
		modelo.addAttribute("titulo","Autentificacion de Usuario");
		return "/home/index";
	}
}
