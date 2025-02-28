package tech.ada.web2.spring.rest.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import tech.ada.web2.spring.rest.model.Produto;


@Component
public class ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();

    public ProdutoRepository() {
        produtos.add(new Produto("Produto 1", 10.0));
        produtos.add(new Produto("Produto 2", 20.0));
        produtos.add(new Produto("Produto 3", 30.0));
    }

    public List<Produto> findAll(String nome, Double preco) {
        return produtos.stream()
                       .filter( p -> nome == null || p.getNome().equalsIgnoreCase(nome))
                       .filter(p -> preco == null || p.getPreco().equals(preco))
                       .collect(Collectors.toList());
    }

    public Produto save(Produto produto) {
        Produto newProduto = new Produto(produto.getNome(), produto.getPreco());
        produtos.add(newProduto);

        return newProduto;
    }

    public boolean deleteById(Long id) {
        return produtos.removeIf(produto -> produto.getId() == id);
    }

    public Produto findById(Long id) {
        return produtos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
