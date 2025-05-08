package br.edu.fatec.gru.historia_brinquedo.controllerweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService;
import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;

@Controller
public class NavegaController {

    @Autowired
    private BrinquedoService brinquedoService;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/adm")
    public String adm(Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.listarTodos();
        model.addAttribute("brinquedos", brinquedos);
        return "adm";
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
        return "form-brinquedo"; // nome do arquivo HTML real
    }

    @PostMapping("/criar")
    public String salvarBrinquedo(
        @ModelAttribute BrinquedoEntity brinquedo,
        Model model
    ) {
        try {
            brinquedoService.salvar(brinquedo);
            return "redirect:/adm";
        } catch (Exception ex) {
            model.addAttribute("erro", ex.getMessage());
            return "form-brinquedo";
        }
    }

    @GetMapping("/editar/{id}")
    public String editarBrinquedo(@PathVariable Long id, Model model) {
        BrinquedoEntity brinquedo = brinquedoService.buscarPorId(id);
        if (brinquedo == null) {
            return "redirect:/adm";
        }
        model.addAttribute("brinquedo", brinquedo);
        model.addAttribute("categorias", List.of("Pelúcia", "Quebra-Cabeças", "HotWheels"));
        return "form-brinquedo";
    }

    @GetMapping("/deletar/{id}")
    public String deletarBrinquedo(@PathVariable Long id) {
        brinquedoService.deletar(id);
        return "redirect:/adm";
    }

    @GetMapping("/pelucias")
    public String mostrarPelucias(Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.buscarPorCategoria("Pelúcia");
        model.addAttribute("brinquedos", brinquedos);
        return "catalogo";
    }

    @GetMapping("/quebraCabecas")
    public String mostrarQuebraCabecas(Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.buscarPorCategoria("Quebra-Cabeças");
        model.addAttribute("brinquedos", brinquedos);
        return "catalogo";
    }

    @GetMapping("/hotwheels")
    public String mostrarHotWheels(Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.buscarPorCategoria("HotWheels");
        model.addAttribute("brinquedos", brinquedos);
        return "catalogo";
    }
}
