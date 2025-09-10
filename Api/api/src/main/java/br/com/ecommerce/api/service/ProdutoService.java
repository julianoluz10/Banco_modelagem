package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    //Injecao de Dependencia
    //Falar que Service depende de  alguem
    // final constante
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository prod) {

        produtoRepository = prod;
    }

    //Listar todos os Produtos

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    //Insert Into
    public Produto CadastrarProduto(Produto produto){
        return produtoRepository.save(produto);
    }
    public Produto buscarPorId(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }
}
