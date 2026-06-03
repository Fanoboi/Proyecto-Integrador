package com.luzdelsaber.biblioteca.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.luzdelsaber.biblioteca.service.BibliografiaService;

@Controller
public class HomeController {

    private final BibliografiaService bibliografiaService;

    public HomeController(BibliografiaService bibliografiaService) {
        this.bibliografiaService = bibliografiaService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("librosDestacados", bibliografiaService.listarLibrosCatalogo()
                .stream()
                .limit(3)
                .toList());
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio(Model model) {
        model.addAttribute("libros", bibliografiaService.listarLibrosCatalogo());
        model.addAttribute("categorias", bibliografiaService.listarCategoriasActivas());
        return "inicio";
    }

    @GetMapping("/reservas")
    public String reservas() {
        return "reservas";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/pedidos")
    public String pedidos() {
        return "pedidos";
    }

}
