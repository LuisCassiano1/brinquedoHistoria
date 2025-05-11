package br.edu.fatec.gru.historia_brinquedo.controllerweb;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService;
import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import br.edu.fatec.gru.historia_brinquedo.repository.BrinquedoRepository;
import jakarta.validation.Valid;

@Controller
public class NavegaController {

    @Autowired
    private BrinquedoService brinquedoService;
    private BrinquedoRepository brinquedoRepository;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }
    
    @GetMapping("/adm")
    public String mostrarAdm(Model model) {
        model.addAttribute("brinquedos", brinquedoRepository.findAll() );
        model.addAttribute("brinquedo", new BrinquedoEntity()); // <- este é o importante!
        return "adm"; // nome do seu HTML
    }
    
    @GetMapping("/adm")
    public String showForm(Model model) {
        model.addAttribute("brinquedo", new BrinquedoEntity()); // Objeto para o formulário
        model.addAttribute("categorias", Arrays.asList(
            "Educativo", "Eletrônico", "Montar", "Ao Ar Livre"
        )); // Lista de categorias
        return "adm";
    }

    @PostMapping("/salvar")
    public String saveBrinquedo(@Valid @ModelAttribute("brinquedo") BrinquedoEntity brinquedo,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "adm"; // Volta para o formulário com erros
        }
        brinquedoService.save(brinquedo);
        return "redirect:/adm";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }

    @GetMapping("/catalogo")
    public String catalogo() {
        return "catalogo";
    }

    @GetMapping("/adm/formBrinquedo")
    public String exibirFormulario(Model model) {
        model.addAttribute("brinquedo", new BrinquedoEntity());
        model.addAttribute("categorias", List.of("Pelúcia", "Quebra-Cabeças", "HotWheels"));
        return "adm/formBrinquedo"; // nome do arquivo HTML real
    }

    @PostMapping("/criar")
    public String salvarBrinquedo(
        @ModelAttribute BrinquedoEntity brinquedo,
        Model model
    ) {
        try {
            brinquedoService.save(brinquedo);
            return "redirect:/adm";
        } catch (Exception ex) {
            model.addAttribute("erro", ex.getMessage());
            return "formBrinquedo";
        }
    }

    @GetMapping("/editar/{id}")
    public String editarBrinquedo(@PathVariable Long id, Model model) {
        BrinquedoEntity brinquedo = brinquedoService.getById(id);
        if (brinquedo == null) {
            return "redirect:/adm";
        }
        model.addAttribute("brinquedo", brinquedo);
        model.addAttribute("categorias", List.of("Pelúcia", "Quebra-Cabeças", "HotWheels"));
        return "formBrinquedo";
    }

    @GetMapping("/deletar/{id}")
    public String deletarBrinquedo(@PathVariable Long id) {
        brinquedoService.delete(id);
        return "redirect:/adm";
    }

    @GetMapping("/pelucias")
    public String mostrarPelucias(Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.getByCategoria("Pelúcia");
        model.addAttribute("brinquedos", brinquedos);
        return "catalogo";
    }

    @GetMapping("/quebraCabecas")
    public String mostrarQuebraCabecas(Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.getByCategoria("Quebra-Cabeças");
        model.addAttribute("brinquedos", brinquedos);
        return "catalogo";
    }

    @GetMapping("/hotwheels")
    public String mostrarHotWheels(Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.getByCategoria("HotWheels");
        model.addAttribute("brinquedos", brinquedos);
        return "catalogo";
    }
}
