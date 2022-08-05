package cl.jotam.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "redirect:/index";
	}
	@GetMapping("/g")
	public String google() {
		return "redirect:https://www.google.cl";
	}
	@RequestMapping("/saludo")
	public String saludo() {
		return "forward:/saludo";
	}

}
