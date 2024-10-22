
package com.exemplo.loja.controller;

import com.exemplo.loja.model.Produtos;
import com.exemplo.loja.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LojaController {
    private List<Produtos> listaProduto = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    
    public LojaController() {
        usuarios.add(new Usuario("user1", "senha1"));
        usuarios.add(new Usuario("user2", "senha2"));
    }

   @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password) {
        if (autenticacaoBemSucedida(username, password)) {
            return "redirect:/inserir-produto";  
        } else {
            return "login";
        }
    }

    private boolean autenticacaoBemSucedida(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
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
        if (produto.getId() != null) {
            for (Produtos p : listaProduto) {
                if (Objects.equals(p.getId(), produto.getId())) {
                    p.setCodigo(produto.getCodigo());
                    p.setNome(produto.getNome());
                    p.setValor(produto.getValor());
                    p.setQuantidadeEstoque(produto.getQuantidadeEstoque());
                    p.setData(produto.getData());
                    break;
                }
            }
        } else {
            produto.setId(listaProduto.size() + 1);
            listaProduto.add(produto);
        }
        return "redirect:/listarProduto";
    }
    
    @GetMapping("/listarProduto")
    public String mostraProduto(Model model) {
        model.addAttribute("produtos", listaProduto);
        return "listarProduto";
    }

    @GetMapping("/lista-produtos")
    public String mostraProdutos() {
        return "listarProduto";
    }

 @GetMapping("/excluir-produto")
    public String excluirProduto(Model model, @RequestParam String id) {
        Integer idProduto = Integer.parseInt(id);
        Produtos produtoEncontrado = new Produtos();
        for (Produtos p : listaProduto) {
            if (p.getId() == idProduto) {
                produtoEncontrado = p;
                break;
            }
        }
        listaProduto.remove(produtoEncontrado);
        return "redirect:/listarProduto";
    }
   @GetMapping("/alterar-produto")
    public String AlterarProduto(Model model, @RequestParam String id) {
        Integer idProduto = Integer.parseInt(id);
        Produtos produtoEncontrado = new Produtos();
        for (Produtos p : listaProduto) {
            if (p.getId() == idProduto) {
                produtoEncontrado = p;
                break;
            }
        }

        model.addAttribute("produto", produtoEncontrado);
        return "cadastro";
    }
    
}
