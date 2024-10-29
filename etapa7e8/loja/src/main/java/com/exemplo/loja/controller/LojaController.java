
package com.exemplo.loja.controller;

import com.exemplo.loja.model.Produtos;
import com.exemplo.loja.model.Usuario;
import com.exemplo.loja.repository.ProdutosRepository;
import com.exemplo.loja.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LojaController {
    @Autowired
    private ProdutosRepository produtosRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    

    @GetMapping("/cadastro-usuario")
    public String exibirFormularioCadastroUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro-usuario";
    }

   @PostMapping("/guardar-usuario")
    public String processarCadastroUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String usuario, @RequestParam String senha, Model model) {
        Usuario user = usuarioRepository.findByUsuario(usuario);
        if (user != null && user.getSenha().equals(senha)) {
            return "redirect:/inserir-produto";
        }
        model.addAttribute("error", "Usuário ou senha inválidos");
        return "login";
    }

    @GetMapping("/cadastro")
    public String exibirtela() {
        return "cadastro";
    }

    @GetMapping("/inserir-produto")
    public String mostraCadastro(Model model) {
        model.addAttribute("produto", new Produtos());
        return "cadastro";
    }

    @PostMapping("/guardar-produto")
    public String processarFormulario(@ModelAttribute Produtos produto) {
        produtosRepository.save(produto);
        return "redirect:/listarProduto";
    }

    @GetMapping("/listarProduto")
    public String mostraProduto(Model model) {
        model.addAttribute("produtos", produtosRepository.findAll());
        return "listarProduto";
    }

    @GetMapping("/excluir-produto")
    public String excluirProduto(@RequestParam Integer id) {
        produtosRepository.deleteById(id);
        return "redirect:/listarProduto";
    }

    @GetMapping("/alterar-produto")
    public String alterarProduto(Model model, @RequestParam Integer id) {
        Produtos produtoEncontrado = produtosRepository.findById(id).orElse(null);
        if (produtoEncontrado != null) {
            model.addAttribute("produto", produtoEncontrado);
            return "cadastro";
        } else {
            return "redirect:/listarProduto";
        }
    }
}