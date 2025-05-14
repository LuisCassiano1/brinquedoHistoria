package br.edu.fatec.gru.historia_brinquedo.controller;

import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService;
import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

    @Autowired
    private BrinquedoService brinquedoService;
    
    @GetMapping("/detalhes/{idBrinquedo}")
    public String detalhesBrinquedo(@PathVariable Long idBrinquedo, Model model) {
        BrinquedoEntity brinquedo = brinquedoService.getById(idBrinquedo);
        model.addAttribute("brinquedo", brinquedo);
        return "detalhesBrinquedos"; // nome do HTML que você criou
    }
}
