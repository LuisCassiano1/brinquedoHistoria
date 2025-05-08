package br.edu.fatec.gru.historia_brinquedo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService;

@RestController
@RequestMapping("/api/brinquedos")
@CrossOrigin(origins = "*") // Permite chamadas de qualquer origem (útil para testes front-end locais)
public class BrinquedoController {

    @Autowired
    private BrinquedoService service;

    @PostMapping
    public BrinquedoEntity criar(@RequestBody BrinquedoEntity brinquedo) {
        return service.salvar(brinquedo);
    }

    @PutMapping("/{id}")
    public BrinquedoEntity editar(@PathVariable Long id, @RequestBody BrinquedoEntity brinquedo) {
        brinquedo.setId(id);
        return service.salvar(brinquedo);
    }

    @GetMapping
    public List<BrinquedoEntity> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public BrinquedoEntity buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
