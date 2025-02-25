package tech.ada.web2.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.ada.web2.spring.mvc.model.Produto;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

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
        return "redirect:/produtos";
    }

    @PostMapping("/delete")
    public String deletarProduto(@RequestParam int index) {
        if (index >= 0 && index < produtos.size()) {
            produtos.remove(index);
        }
        return "redirect:/produtos";
    }
}
