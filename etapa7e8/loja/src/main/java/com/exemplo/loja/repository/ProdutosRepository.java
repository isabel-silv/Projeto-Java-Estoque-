package com.exemplo.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.loja.model.Produtos;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

}
