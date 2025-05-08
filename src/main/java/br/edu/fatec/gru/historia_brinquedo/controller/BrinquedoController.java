package br.edu.fatec.gru.historia_brinquedo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService2;
import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;

@RestController
public class BrinquedoController {
	
	@Autowired
	private BrinquedoService2  BrinquedoService;
	
	
	@PostMapping("/{id}")
    public ResponseEntity<Object> criar(@RequestBody BrinquedoEntity brinquedoEntity, @PathVariable Long id){
        try{
            if(!usuarioService.validar(id).isEmpty()){
                return ResponseEntity.status(HttpStatus.CREATED).body(BrinquedoService.criar(brinquedoEntity));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário inválido");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
	
}