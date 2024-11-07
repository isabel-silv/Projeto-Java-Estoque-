
package com.exemplo.loja.service;

import com.exemplo.loja.model.Produtos;
import com.exemplo.loja.repository.ProdutosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
     @Autowired
    ProdutosRepository produtosRepository;
     
     public   Produtos buscarPorId(Integer id){
        return produtosRepository.findById(id).orElseThrow();
    }
      public   Produtos criarProduto(  Produtos produto){
        produto.setId(null);
        produtosRepository.save(produto);
        return produto;
    }
       public List< Produtos> listarTodos(){
        return produtosRepository.findAll();
    }
    public   Produtos atualizar(Integer id,   Produtos produto){
          Produtos produtoEncontrado = buscarPorId(id);
        produtoEncontrado.setCodigo(produto.getCodigo());
        produtoEncontrado.setNome(produto.getNome());
        produtoEncontrado.setValor(produto.getValor());
        produtoEncontrado.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        produtoEncontrado.setData(produto.getData());
        produtosRepository.save(produtoEncontrado);
        return produtoEncontrado;
    }
    
    public void excluir(Integer id){
          Produtos produtoEncontrado = buscarPorId(id);
        produtosRepository.deleteById(produtoEncontrado.getId());
    }
    }

