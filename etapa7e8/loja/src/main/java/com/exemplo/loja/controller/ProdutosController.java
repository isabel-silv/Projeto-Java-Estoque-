
package com.exemplo.loja.controller;

import com.exemplo.loja.model.Produtos;
import com.exemplo.loja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdutosController {
  @Autowired  
  ProdutoService produtoService; 
 
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
        produtoService.criarProduto(produto);
        return "redirect:/listarProduto";
    }

    @GetMapping("/listarProduto")
    public String mostraProduto(Model model) {
        model.addAttribute("produtos", produtoService.listarTodos());
        return "listarProduto";
    }

    @GetMapping("/excluir-produto")
    public String excluirProduto(@RequestParam Integer id) {
        produtoService.excluir(id);
        return "redirect:/listarProduto";
    }

    @GetMapping("/alterar-produto")
    public String alterarProduto(Model model, @RequestParam String id) {
        Integer idProduto = Integer.parseInt(id);
        model.addAttribute("produto", produtoService.buscarPorId(idProduto));
        return "cadastro";
   
    }
}


