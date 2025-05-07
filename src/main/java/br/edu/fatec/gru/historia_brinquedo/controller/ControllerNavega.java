package br.edu.fatec.gru.historia_brinquedo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerNavega {
			
				@GetMapping ("/home") 
				public String home() {
					return "home";
				}
				
				@GetMapping ("/adm") 
				public String adm() {
					return "adm";
				}
}