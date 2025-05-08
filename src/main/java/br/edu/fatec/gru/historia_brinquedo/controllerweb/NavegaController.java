package br.edu.fatec.gru.historia_brinquedo.controllerweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService;
import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;

@Controller
public class NavegaController {
	
			@Autowired
			private BrinquedoService brinquedoService;
					
			
			
			@GetMapping ({"/","/home"}) 
			public String home() {
				return "home";
			}
			
			@GetMapping ("/adm") 
			public String adm() {
				return "adm";
			}
			
			@GetMapping ("/sobre") 
			public String sobre() {
				return "sobre";
			}
			
			@GetMapping ("/catalogo") 
			public String catalogo() {
				return "catalogo";
			}
			
			@GetMapping ("/form-brinquedo") 
			public String formBrinquedo() {
				return "form-brinquedo";
			}
}