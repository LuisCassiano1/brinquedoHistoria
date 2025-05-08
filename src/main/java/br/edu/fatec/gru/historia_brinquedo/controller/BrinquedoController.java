package br.edu.fatec.gru.historia_brinquedo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService;
import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import br.edu.fatec.gru.historia_brinquedo.model.UsuarioEntity;
import br.edu.fatec.gru.historia_brinquedo.Service.UsuarioService;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{id}")
    public ResponseEntity<Object> criar(@RequestBody BrinquedoEntity brinquedoEntity, @PathVariable Long id){
        try{
            if(!usuarioService.validar(id).isEmpty()){
                return ResponseEntity.status(HttpStatus.CREATED).body(brinquedoService.criar(brinquedoEntity));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário inválido");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<BrinquedoEntity>> listarTodos(){
        return ResponseEntity.ok(brinquedoService.listarTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> ler(@PathVariable Long id){
        try{
            return ResponseEntity.ok(brinquedoService.ler(id));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@RequestBody BrinquedoEntity brinquedoEntity, @PathVariable Long id){
        try{
            brinquedoEntity.setId(id);
            return ResponseEntity.status(HttpStatus.OK).body(brinquedoService.editar(brinquedoEntity));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id){
        try{
            brinquedoService.deletar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
