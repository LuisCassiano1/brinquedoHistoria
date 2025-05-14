package br.edu.fatec.gru.historia_brinquedo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{idBrinquedo}")
    public BrinquedoEntity getById(@PathVariable("idBrinquedo") Long idBrinquedo) {
        return brinquedoService.getById(idBrinquedo);
    }
    // COLOCAR QUANDO A LISTA FUNCIONAR
    /*@GetMapping("/nome/{nome}")
    public List<BrinquedoEntity> getByNome(@PathVariable("nome") String nomeBrinquedo) {
        return brinquedoService.getByNome(nomeBrinquedo);
    }*/

    @PostMapping
    public BrinquedoEntity insert(@RequestBody BrinquedoEntity brinquedo) {
        return brinquedoService.save(brinquedo);
    }

    @PutMapping("/{idBrinquedo}")
    public BrinquedoEntity update(@RequestBody BrinquedoEntity brinquedo, @PathVariable Long idBrinquedo) {
        BrinquedoEntity brinquedoExistente = brinquedoService.getById(idBrinquedo);
        brinquedoExistente.setNomeBrinquedo(brinquedo.getNomeBrinquedo());
        brinquedoExistente.setCategoriaBrinquedo(brinquedo.getCategoriaBrinquedo());
        brinquedoExistente.setMarcaBrinquedo(brinquedo.getMarcaBrinquedo());
        brinquedoExistente.setValorBrinquedo(brinquedo.getValorBrinquedo());
        brinquedoExistente.setDescricaoBrinquedo(brinquedo.getDescricaoBrinquedo());
        return brinquedoService.save(brinquedoExistente);
    }

    @DeleteMapping("/{idBrinquedo}")
    public String delete(@PathVariable("idBrinquedo") Long idBrinquedo) {
        brinquedoService.delete(idBrinquedo);
        return "Brinquedo excluído com sucesso";
    }
}
