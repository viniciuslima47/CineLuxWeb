package br.ifpe.jaboatao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.ifpe.jaboatao.model.Filme;
import br.ifpe.jaboatao.repository.FilmeRepository;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeRepository fr;
    
    // listar filmes
    @GetMapping
    public String listar(Model model){
        model.addAttribute("listarfilmes", fr.findAll());
        return "filme-lista";
    }

   // form cadastrar
    @GetMapping("/novo")
    public String formCadastrar(Filme filme){
        return "filme-form"; // exibe formulário
    }

    // salvar (create / update)
    @PostMapping("/salvar")
    public String salvar(@Valid Filme filme, BindingResult result) {
        if(result.hasErrors()) {
            return "filme-form";
        }
        fr.save(filme);
        return "redirect:/filme";
    }

     // editar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Filme filme = fr.findById(id).orElse(null);
        model.addAttribute("filme", filme);
        return "filme-form";
    }

    // deletar
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        fr.deleteById(id);
        return "redirect:/filme";
    }
    
}
