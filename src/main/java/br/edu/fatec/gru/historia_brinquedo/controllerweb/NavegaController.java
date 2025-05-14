package br.edu.fatec.gru.historia_brinquedo.controllerweb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.fatec.gru.historia_brinquedo.Service.BrinquedoService;
import br.edu.fatec.gru.historia_brinquedo.model.BrinquedoEntity;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class NavegaController {
	
	private static final Logger logger = LoggerFactory.getLogger(NavegaController.class);

    @Autowired
    private BrinquedoService brinquedoService;

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }
    
    @GetMapping("/adm")
    public String showAdmPage(Model model) {
        if (!model.containsAttribute("brinquedo")) {
            model.addAttribute("brinquedo", new BrinquedoEntity());
        }
        model.addAttribute("brinquedos", brinquedoService.listAll());
        model.addAttribute("categorias", Arrays.asList("Pelúcias", "Quebra-cabeças", "Carrinhos"));
        return "adm";
    }

    @PostMapping("/salvar")
    public String saveBrinquedo(
        @Valid @ModelAttribute("brinquedo") BrinquedoEntity brinquedo,
        BindingResult result,
        @RequestParam("imagem") MultipartFile imagem,
        RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brinquedo", result);
            redirectAttributes.addFlashAttribute("brinquedo", brinquedo);
            return "redirect:/adm";
        }

        try {
            if (!imagem.isEmpty()) {
                String nomeArquivo = UUID.randomUUID() + "_" + imagem.getOriginalFilename();
                Path caminho = Paths.get("src/main/resources/static/imagens/" + nomeArquivo);
                Files.createDirectories(caminho.getParent());
                Files.write(caminho, imagem.getBytes());

                brinquedo.setImagemBrinquedo(nomeArquivo);
                logger.info("Imagem '{}' salva com sucesso.", nomeArquivo);
            }

            brinquedoService.save(brinquedo);
            logger.info("Brinquedo '{}' salvo com sucesso.", brinquedo.getNomeBrinquedo());
            redirectAttributes.addFlashAttribute("successMessage", "Brinquedo salvo com sucesso!");
        } catch (IOException e) {
            logger.error("Erro ao salvar imagem do brinquedo", e);
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar a imagem: " + e.getMessage());
        }

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
        model.addAttribute("categorias", List.of("Pelúcias", "Quebra-cabeças", "Carrinhos"));
        return "formBrinquedo"; // nome do arquivo HTML real
    }

    @GetMapping("/editar/{idBrinquedo}")
    public String editarBrinquedo(@PathVariable Long idBrinquedo, Model model) {
        BrinquedoEntity brinquedo = brinquedoService.getById(idBrinquedo);
        if (brinquedo == null) {
            return "redirect:/adm";
        }
        model.addAttribute("brinquedo", brinquedo);
        model.addAttribute("categorias", List.of("Pelúcias", "Quebra-cabeças", "Carrinhos"));
        return "formBrinquedo";
    }

    @GetMapping("/deletar/{idBrinquedo}")
    public String deletarBrinquedo(@PathVariable Long idBrinquedo, RedirectAttributes redirectAttributes) {
        try {
            brinquedoService.delete(idBrinquedo);
            redirectAttributes.addFlashAttribute("successMessage", "Brinquedo excluído com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao excluir brinquedo: " + e.getMessage());
        }
        return "redirect:/adm";
    }
    
    @GetMapping("/catalogo/{categoria}")
    public String listarPorCategoria(@PathVariable String categoria, Model model) {
        // Normaliza a categoria vinda da URL
        switch (categoria.toLowerCase()) {
            case "pelucias":
                categoria = "Pelúcias";
                break;
            case "carrinhos":
                categoria = "Carrinhos";
                break;
            case "quebra-cabecas":
            case "quebracabecas":
                categoria = "Quebra-cabeças";
                break;
            default:
                categoria = categoria; // ou redireciona para erro
        }

        List<BrinquedoEntity> brinquedos = brinquedoService.findByCategoriaBrinquedoIgnoreCase(categoria);

        model.addAttribute("categoria", categoria);
        model.addAttribute("brinquedos", brinquedos != null ? brinquedos : List.of());

        return "categoriaBrinquedos";
    }



    
    @GetMapping("/brinquedo/{idBrinquedo}")
    public String mostrarDetalhesBrinquedo(@PathVariable Long idBrinquedo, Model model) {
        BrinquedoEntity brinquedo = brinquedoService.getById(idBrinquedo);
        if (brinquedo == null) {
            return "redirect:/catalogo"; // ou uma página de erro
        }
        model.addAttribute("brinquedo", brinquedo);
        return "detalhesBrinquedo";
    }

}
