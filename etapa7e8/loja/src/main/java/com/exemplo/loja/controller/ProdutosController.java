
package com.exemplo.loja.controller;

import com.exemplo.loja.model.Produtos;
import com.exemplo.loja.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
 @GetMapping("/cadastro-produto")
    public String exibirFormularioCadastroProduto(Model model) {
        model.addAttribute("produtos", new Produtos());
        return "cadastro";
    }

    @PostMapping("/guardar-produto")
    public String processarCadastroProduto(@Valid @ModelAttribute Produtos produtos, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cadastro";
        }
        produtoService.criarProduto(produtos);
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
        model.addAttribute("produtos", produtoService.buscarPorId(idProduto));
        return "cadastro";
   
    }
}


