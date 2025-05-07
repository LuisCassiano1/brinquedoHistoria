package br.edu.fatec.gru.historia_brinquedo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService2;
import br.edu.fatec.gru.historia_brinquedo.model.Brinquedo;

@RestController
public class BrinquedoController {
	
	@Autowired
	private BrinquedoService2  brinquedoService;
	
	
	@GetMapping ("/api/brinquedos")
	public List <Brinquedo> todosOsBrinquedos() {
		return brinquedoService.listall();
	}
	
	
	
	@PostMapping ("/api/brinquedos") 
	public Brinquedo insert ( @RequestBody Brinquedo brinquedo) {
			return brinquedoService.SaveBrinquedo(brinquedo);
		}
	
}