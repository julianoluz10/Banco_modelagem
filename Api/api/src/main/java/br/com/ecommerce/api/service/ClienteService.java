package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    //Injecao de Dependencia
    //Falar que Service depende de  alguem
    // final constante
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repo) {
        clienteRepository = repo;
    }

    //Listar todos os clientes
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }
    //INSERT INTO blabla
    public Cliente CadastrarCliente(Cliente cl){
        return clienteRepository.save(cl);
    }
    public Cliente buscarPorId(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }
    public Cliente deletarCliente(Integer id){
        //1.verifico se o cliente existe
        Cliente cliente = buscarPorId(id);

        //2. se nao existir, retorno nulo
        if(cliente == null){
            return null;
        }
        //3. se existir, excluo
        clienteRepository.delete(cliente);
        return cliente;
    }
}
