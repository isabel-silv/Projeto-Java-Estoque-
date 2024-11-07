
package com.exemplo.loja.controller;


import com.exemplo.loja.model.Usuario;
import com.exemplo.loja.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
 @Autowired  
 UsuarioService usuarioService;
 
 @GetMapping("/cadastro-usuario")
    public String exibirFormularioCadastroUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro-usuario";
    }

   @PostMapping("/guardar-usuario")
    public String processarCadastroUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.criarUsuario(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String usuario, @RequestParam String senha, Model model) {
        Usuario user = usuarioService.buscarPorUsuario(usuario);
        if (user != null && user.getSenha().equals(senha)) {
            return "redirect:/inserir-produto";
        }
        model.addAttribute("error", "Usuário ou senha inválidos");
        return "login";
    }
 
 }

