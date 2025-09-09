package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {
    //Controler->Service
    private final PagamentoService pagamentoService;
    public  PagamentoController(PagamentoService pagamento) {
        pagamentoService = pagamento;
    }
    //Listar Todos
    @GetMapping
    public ResponseEntity<List<Pagamento>> ListarPagamentos(){
        //1.Pegar a lista de pagamentos
        List<Pagamento> pagamentos = pagamentoService.listarTodos();
        return ResponseEntity.ok(pagamentos);
    }
    @PostMapping
    public ResponseEntity<Pagamento> CadastrarPagamento(
            @RequestBody Pagamento pagamento
    ){
        //1.TENTAR CADASTRAR O CLIENTE
        pagamentoService.CadastrarPagamento(pagamento);
        //CODIGO 201-CREATE
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

}
