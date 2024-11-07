
package com.exemplo.loja.controller;

import com.exemplo.loja.model.Produtos;
import com.exemplo.loja.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoAPIController {
    @Autowired 
    ProdutoService produtoService;
    
   @GetMapping("buscar/{id}")
    public ResponseEntity<Produtos> pesquisar(@PathVariable Integer id){
        Produtos produtoEncontrado = produtoService.buscarPorId(id);
        return new ResponseEntity<>(produtoEncontrado, HttpStatus.OK);
    }
     @PostMapping("/adicionar")
    public ResponseEntity<Produtos> criar(@RequestBody Produtos produto){
     Produtos novoProduto = produtoService.criarProduto(produto);
       return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }
    @GetMapping("listar-todos")
    public ResponseEntity<List> listar(){
        List<Produtos> produtoP = produtoService.listarTodos();
        return new ResponseEntity<>(produtoP, HttpStatus.OK);
    }
     @PutMapping("/atualizar/{id}")
    public ResponseEntity<Produtos> atualizar(@PathVariable Integer id, @RequestBody Produtos produto){
        Produtos produtoAtualizado = produtoService.atualizar(id, produto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        produtoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

