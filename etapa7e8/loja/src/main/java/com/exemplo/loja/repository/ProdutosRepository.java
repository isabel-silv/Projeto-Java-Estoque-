/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.loja.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

}
