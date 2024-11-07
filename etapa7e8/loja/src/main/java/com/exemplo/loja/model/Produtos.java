
package com.exemplo.loja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "O campo código não pode estar vazio")
    private Integer codigo;

    @NotEmpty(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo valor não pode estar vazio")
    @Positive(message = "O valor deve ser positivo")
    private Double valor;

    @NotNull(message = "O campo quantidade em estoque não pode estar vazio")
    @Positive(message = "A quantidade em estoque deve ser positiva")
    private Integer quantidadeEstoque;

    @NotNull(message = "O campo data não pode estar vazio")
    private LocalDate data;

}

