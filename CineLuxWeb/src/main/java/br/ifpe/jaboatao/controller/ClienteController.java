package br.ifpe.jaboatao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.ifpe.jaboatao.model.Cliente;
import br.ifpe.jaboatao.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/clientes")
public class ClienteController{
    @Autowired
    private ClienteRepository cr;

    //listar clientes
    @GetMapping
    public String listar(Model model){
        model.addAttribute("listaClientes", cr.findAll());
        return "cliente-lista";
    }

     // form cadastrar
    @GetMapping("/novo")
    public String novo(Cliente cliente) {
        return "cliente-form";
    }

    // salvar ( create / update )
    @PostMapping("/salvar")
    public String salvar(Cliente cliente) {
        cr.save(cliente);
        return "redirect:/clientes";
    }

   // editar
   @GetMapping("/editar/{id}")
   public String editar(@PathVariable Integer id, Model model) {
      model.addAttribute("cliente", cr.findById(id).orElse(null));
      return "cliente-form";
   }

   // deletar
   @GetMapping("/delete/{id}")
   public String delete(@PathVariable Integer id) {
      cr.deleteById(id);
      return "redirect:/clientes";
   }
   
}
