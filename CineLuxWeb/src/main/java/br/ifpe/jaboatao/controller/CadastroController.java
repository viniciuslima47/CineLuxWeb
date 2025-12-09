package br.ifpe.jaboatao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ifpe.jaboatao.model.Pessoa;
import br.ifpe.jaboatao.repository.PessoaRepository;
import jakarta.validation.Valid;

@Controller
public class CadastroController {

    @Autowired
    private PessoaRepository pr;
    
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public String cadastroUsuario(@Valid Pessoa pessoa, BindingResult result) {

        if(result.hasErrors()) {
            return "redirect:/cadastroUsuario";
        }

        pr.save(pessoa);
        return "redirect:/login";
    }

}
