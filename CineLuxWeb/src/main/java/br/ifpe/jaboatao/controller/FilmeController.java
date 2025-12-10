package br.ifpe.jaboatao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.jaboatao.model.Filme;
import br.ifpe.jaboatao.repository.FilmeRepository;
import jakarta.validation.Valid;

@Controller
public class FilmeController {

    @Autowired
    private FilmeRepository fr;
    
    @GetMapping("/filme")
    public String formularioFilme(Filme filme) {
        return "filme";
    }

    @PostMapping("/filme")
    public String cadastrarFilme(@Valid Filme filme, BindingResult result) {

        if (result.hasErrors()) {
            return "filme";
        }

        fr.save(filme);
        return "redirect:/";
    }
}
