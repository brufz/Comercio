package com.comercio.comercioEletronico.service;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Categoria;
import com.comercio.comercioEletronico.model.Produto;
import com.comercio.comercioEletronico.repository.CategoriaRepository;
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
    
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(Long id) throws IdInvalidoException {
        validarId(id);
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto;
    }

    @Override
    public Produto criarProduto(Produto produto) {
        Produto novoProduto = produtoRepository.save(produto);
        Optional<Categoria> categoria = categoriaRepository.findById(produto.getCategoria().getId());
        novoProduto.setCategoria(categoria.get());
        return novoProduto;
    }

    @Override
    public void deletarProduto(Long id) throws IdInvalidoException {
        validarId(id);
        produtoRepository.deleteById(id);
    }

    @Override
    public Produto editarProduto(Produto produto) {
        Produto save = produtoRepository.save(produto);
        return save;
    }

    public void validarId(Long id) throws IdInvalidoException {
        if (!produtoRepository.existsById(id)) {
            throw new IdInvalidoException("Id não encontrado no banco de dados");
        }
    }
}

