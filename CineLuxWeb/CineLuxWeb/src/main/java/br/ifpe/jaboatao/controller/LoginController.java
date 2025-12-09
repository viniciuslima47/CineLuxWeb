package br.ifpe.jaboatao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.jaboatao.model.Pessoa;
import br.ifpe.jaboatao.repository.PessoaRepository;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private PessoaRepository pr;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/logar")
    public String loginUsuario(Pessoa pessoa, Model model, HttpServletResponse response) {
        Pessoa usuarioLogado = this.pr.login(pessoa.getCpf(), pessoa.getSenha());

        if(usuarioLogado != null){
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuario Invalido!");
        return "Login/login";
    }

}
