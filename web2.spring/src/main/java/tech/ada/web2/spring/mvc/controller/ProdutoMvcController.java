package tech.ada.web2.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.ada.web2.spring.mvc.model.Produto;

@Controller
@RequestMapping("/mvc/produtos")
public class ProdutoMvcController {
    private List<Produto> produtos = new ArrayList<>();

    public ProdutoMvcController() {
        produtos.add(new Produto("Arroz", 10.0));
        produtos.add(new Produto("Feijão", 8.0));
        produtos.add(new Produto("Macarrão", 5.0));
    }

    @GetMapping
    public String listarProdutos(Model model) {

        model.addAttribute("produtos", produtos);

        return "produtos/lista";
    }

    @GetMapping("/novo")
    public String novoProdutoForm(Model model) {

        model.addAttribute("produto", new Produto());

        return "produtos/form";
    }

    @PostMapping
    public String criarProduto(@ModelAttribute Produto produto) {

        produtos.add(produto);

        return "redirect:/mvc/produtos";
    }

    @PostMapping("/delete")
    public String deletarProduto(@RequestParam int index) {
        if (index >= 0 && index < produtos.size()) {
            produtos.remove(index);
        }
        return "redirect:/mvc/produtos";
    }

    @GetMapping("/editar/{index}")
    public String editarProdutos(@PathVariable int index, Model model) {

        model.addAttribute("produto", produtos.get(index));
        model.addAttribute("index", index);

        return "produtos/edit";
    }

    @PostMapping("/editar/{index}")
    public String editarProduto(@PathVariable int index, @ModelAttribute Produto produto) {
        produtos.get(index).setNome(produto.getNome());
        produtos.get(index).setPreco(produto.getPreco());

        return "redirect:/mvc/produtos";
    }
}
