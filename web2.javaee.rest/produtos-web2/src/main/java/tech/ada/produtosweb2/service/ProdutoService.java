package tech.ada.produtosweb2.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import tech.ada.produtosweb2.model.Produto;

@ApplicationScoped
public class ProdutoService {
    private static final List<Produto> produtos = new ArrayList<>();

    public ProdutoService() {
        produtos.add(new Produto("Produto 1", 10.0));
        produtos.add(new Produto("Produto 2", 20.0));
        produtos.add(new Produto("Produto 3", 30.0));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Produto addProduto(Produto produto) {
        produtos.add(produto);

        return produto;
    }

    public void deleteProduto(int id) {
        if(produtos.size() >= id) {
            produtos.remove(id);
        }
    }

    public Produto getProduto(int id) {
        if(id >= produtos.size()) {
            return null;
        }

        return produtos.get(id);
    }

    public List<Produto> getProdutos(String nome) {
        if(nome == null) {
            return produtos;
        }

        return produtos.stream()
                       .filter(produto -> produto.getNome().contains(nome))
                       .toList();
    }
}
