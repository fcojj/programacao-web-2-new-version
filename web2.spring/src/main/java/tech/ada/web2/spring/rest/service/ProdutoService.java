package tech.ada.web2.spring.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.web2.spring.rest.model.Produto;
import tech.ada.web2.spring.rest.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getProdutos(String nome, Double preco) {
        return produtoRepository.findAll(nome, preco);
    }

    public Produto addProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public boolean deleteProduto(Long id) {
        return produtoRepository.deleteById(id);
    }

    public Produto getProduto(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto updateProduto(Produto produto) {
        var produtoExistente = produtoRepository.findById(produto.getId());

        if (produtoExistente != null) {
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setPreco(produto.getPreco());
        }

        return produtoExistente;
    }
}
