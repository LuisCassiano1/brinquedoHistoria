package br.edu.fatec.gru.historia_brinquedo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService;

@RestController
@RequestMapping("/api/brinquedos")
@CrossOrigin(origins = "*")
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;

    @GetMapping
    public List<BrinquedoEntity> listarTodos() {
        return brinquedoService.listAll();
    }

    @GetMapping("/{id}")
    public BrinquedoEntity getById(@PathVariable("id") Long id) {
        return brinquedoService.getById(id);
    }

    @GetMapping("/nome/{nome}")
    public List<BrinquedoEntity> getByNome(@PathVariable("nome") String nome) {
        return brinquedoService.getByNome(nome);
    }

    @PostMapping
    public BrinquedoEntity insert(@RequestBody BrinquedoEntity brinquedo) {
        return brinquedoService.save(brinquedo);
    }

    @PutMapping("/{id}")
    public BrinquedoEntity update(@RequestBody BrinquedoEntity brinquedo, @PathVariable Long id) {
        BrinquedoEntity brinquedoExistente = brinquedoService.getById(id);
        brinquedoExistente.setNome(brinquedo.getNome());
        brinquedoExistente.setCategoria(brinquedo.getCategoria());
        brinquedoExistente.setMarca(brinquedo.getMarca());
        brinquedoExistente.setValor(brinquedo.getValor());
        brinquedoExistente.setDescricao(brinquedo.getDescricao());
        return brinquedoService.save(brinquedoExistente);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        brinquedoService.delete(id);
        return "Brinquedo excluído com sucesso";
    }
}
