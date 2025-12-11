package br.ifpe.jaboatao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.ifpe.jaboatao.model.Funcionario;
import br.ifpe.jaboatao.repository.FuncionarioRepository;


@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController{

    @Autowired
    private FuncionarioRepository fr;

    // listar
    @GetMapping
    public String listar(Model model){
        model.addAttribute("listaFuncionarios", fr.findAll());
        return "funcionario-form";
    }

    // form cadastrar
    @GetMapping("/novo")
    public String novo(Funcionario funcionario){
        return "funcionario-form";
    }

    // salvar
    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario) {
        fr.save(funcionario);
        return "redirect:/funcionarios";
    }

    // editar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("funcionario", fr.findById(id).orElse(null));
        return "funcionario-form";
    }

    // deletar
    @GetMapping("/delete/{id}")
    public String editar(@PathVariable Integer id) {
        fr.deleteById(id);
        return "redirect:/funcionarios";
    }  
}