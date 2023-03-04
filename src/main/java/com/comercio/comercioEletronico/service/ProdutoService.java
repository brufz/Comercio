package com.comercio.comercioEletronico.service;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Produto;
import com.comercio.comercioEletronico.repository.ProdutoRepository;
import com.comercio.comercioEletronico.service.interfaces.IProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements IProduto {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> buscarTodosProdutos() {
        return null;
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(Long id) throws IdInvalidoException {
        return Optional.empty();
    }

    @Override
    public Produto criarProduto(Produto produto) {
        return null;
    }

    @Override
    public void deletarProduto(Long id) throws IdInvalidoException {

    }

    @Override
    public Produto editarProduto(Produto produto) {
        return null;
    }
}
