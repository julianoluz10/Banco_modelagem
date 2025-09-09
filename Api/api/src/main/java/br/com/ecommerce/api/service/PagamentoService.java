package br.com.ecommerce.api.service;


import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    //Injecao de Dependecia
    //Falar que Service depende de alguem
    //final constante
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamento) {
        pagamentoRepository = pagamento;
    }
    //Listar todos os Clientes
    public List<Pagamento> listarTodos(){
        return pagamentoRepository.findAll();
    }
    //INSERT INTO
    public Pagamento CadastrarPagamento(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }
}
