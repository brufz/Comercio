package com.comercio.comercioEletronico.service.interfaces;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Categoria;
import com.comercio.comercioEletronico.model.Produto;

import java.util.List;
import java.util.Optional;

public interface IProduto {
    List<Produto> buscarTodosProdutos();
    Optional<Produto> buscarProdutoPorId(Long id) throws IdInvalidoException;
    Produto criarProduto(Produto produto);
    void deletarProduto (Long id) throws IdInvalidoException;
    Produto editarProduto(Produto produto);
}
