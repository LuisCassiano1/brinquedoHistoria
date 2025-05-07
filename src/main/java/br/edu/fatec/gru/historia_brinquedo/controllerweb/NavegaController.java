package br.edu.fatec.gru.historia_brinquedo.controllerweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService2;
import br.edu.fatec.gru.historia_brinquedo.model.Brinquedo;

@Controller
public class NavegaController {
	
	@Autowired
	private BrinquedoService2 brinquedoService;
			
				@GetMapping ("/home") 
				public String home() {
					return "home";
				}
				
				@GetMapping ("/adm") 
				public String adm() {
					return "adm";
				}
}