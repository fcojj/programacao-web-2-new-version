package tech.ada.web2.spring.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private static long INDEX = 0L;

    private Long id;
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.id = ++INDEX;
        this.nome = nome;
        this.preco = preco;
    }
}
