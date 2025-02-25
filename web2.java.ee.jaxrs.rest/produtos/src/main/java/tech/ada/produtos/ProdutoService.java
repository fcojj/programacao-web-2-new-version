package tech.ada.produtos;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProdutoService {
    private static final List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Produto addProduto(Produto produto) {
        produtos.add(produto);

        return produto;
    }
}
