
package com.exemplo.loja.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produtos {
    private Integer id;
    private int codigo;  
    private String nome;
    private double valor;
    private int quantidadeEstoque;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String data;
}
