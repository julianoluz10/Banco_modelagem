package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    //Controler->Service
    private final ProdutoService produtoService;
    public ProdutoController(ProdutoService produto) {
        produtoService = produto;
    }
    //Listar Todos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        //1.Pegar a lista de produtos

        List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }
   @PostMapping
    public ResponseEntity<Produto> CadastrarProduto(
            @RequestBody Produto produto
    ){
        //.TENTAR CADASTRA O CLIENTE
        produtoService.CadastrarProduto(produto);
        //codigo-201-create
return ResponseEntity.ok(produto);    }

}
