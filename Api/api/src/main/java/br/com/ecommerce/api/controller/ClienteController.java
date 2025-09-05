package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    //Controller-> Service
    private final ClienteService clienteService;
    public ClienteController(ClienteService service) {
        clienteService = service;
    }
    //Listar Todos
    @GetMapping
    public ResponseEntity<List<Cliente>> ListarClientes(){
        //1.Pegar a lista de clientes

        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

}
