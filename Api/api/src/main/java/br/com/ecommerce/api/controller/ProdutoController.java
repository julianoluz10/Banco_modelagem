package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    //Controler->Service
    private final ProdutoService produtoService;
    public ProdutoController(ProdutoService Prod) {
        produtoService = Prod;
    }
    //Listar Todos
    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos(){
        //1.Pegar a lista de produtos

        List<Produto> produto = produtoService.ListarTodos();
        return ResponseEntity.ok(produto);
    }

}
