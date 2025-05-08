package br.edu.fatec.gru.historia_brinquedo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
	@PostMapping("/api/brinquedos")
	public ResponseEntity<Brinquedo> inserir( @RequestBody Brinquedo brinquedo) {
	    Brinquedo savedBrinquedo = brinquedoService.SaveBrinquedo(brinquedo);
	   
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedBrinquedo);
	}
	
	
	
	@PostMapping ("/api/brinquedos") 
	public Brinquedo insert ( @RequestBody Brinquedo brinquedo) {
			return brinquedoService.SaveBrinquedo(brinquedo);
		}
	
}