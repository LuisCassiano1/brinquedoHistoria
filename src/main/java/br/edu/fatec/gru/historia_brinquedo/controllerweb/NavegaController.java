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
    	model.addAttribute("brinquedo", new BrinquedoEntity());
    	model.addAttribute("brinquedos", brinquedoService.listAll());
    	model.addAttribute("categorias", Arrays.asList("Pelúcia", "Quebra-Cabeças", "HotWheels"));
        return "adm"; 
    }
    
    @GetMapping("/adm/formulario")
    public String showForm(Model model) {
        model.addAttribute("brinquedo", new BrinquedoEntity()); // Objeto para o formulário
        model.addAttribute("categorias", Arrays.asList(
        		"Pelúcia", "Quebra-Cabeças", "HotWheels"
        )); // Lista de categorias
        return "adm/formulario";
    }

    @PostMapping("/salvar")
    public String saveBrinquedo(@Valid @ModelAttribute("brinquedo") BrinquedoEntity brinquedo,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
        	model.addAttribute
        	("brinquedos", brinquedoService.listAll());
        	model.addAttribute("categorias", Arrays.asList("Pelúcia", "Quebra-Cabeças", "HotWheels"));			
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
    public String categoria() {
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
    public String editarBrinquedo(@PathVariable Long idBrinquedo, Model model) {
        BrinquedoEntity brinquedo = brinquedoService.getById(idBrinquedo);
        if (brinquedo == null) {
            return "redirect:/adm";
        }
        model.addAttribute("brinquedo", brinquedo);
        model.addAttribute("categorias", List.of("Pelúcia", "Quebra-Cabeças", "HotWheels"));
        return "formBrinquedo";
    }

    @GetMapping("/deletar/{id}")
    public String deletarBrinquedo(@PathVariable Long idBrinquedo) {
        brinquedoService.delete(idBrinquedo);
        return "redirect:/adm";
    }
 // COLOCAR QUANDO A LISTA FUNCIONAR
    /*@GetMapping("/pelucias")
    public String mostrarPelucias(Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.getByCategoria("Pelúcia");
        model.addAttribute("brinquedos", brinquedos);
        return "categoria";
    }

    @GetMapping("/quebraCabecas")
    public String mostrarQuebraCabecas(Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.getByCategoria("Quebra-Cabeças");
        model.addAttribute("brinquedos", brinquedos);
        return "categoria";
    }

    @GetMapping("/hotwheels")
    public String mostrarHotWheels(Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.getByCategoria("HotWheels");
        model.addAttribute("brinquedos", brinquedos);
        return "categoria";
    }
    
    @GetMapping("/catalogo/{categoria}")
    public String listarPorCategoria(@PathVariable String categoria, Model model) {
        List<BrinquedoEntity> brinquedos = brinquedoService.getByCategoria(categoria);
        model.addAttribute("brinquedos", brinquedos);
        model.addAttribute("categoria", categoria);
        return "categoriaBrinquedos"; // essa é a view que você vai criar
    }*/
    
    @GetMapping("/brinquedo/{id}")
    public String mostrarDetalhesBrinquedo(@PathVariable Long idBrinquedo, Model model) {
        BrinquedoEntity brinquedo = brinquedoService.getById(idBrinquedo);
        if (brinquedo == null) {
            return "redirect:/catalogo"; // ou uma página de erro
        }
        model.addAttribute("brinquedo", brinquedo);
        return "detalhesBrinquedo"; // essa é a view que você vai criar
    }

}
