package com.comercio.comercioEletronico.service.interfaces;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoria{

    List<Categoria> buscarTodasCategorias();
    Optional<Categoria> buscarCategoriaPorId(Long id) throws IdInvalidoException;
    Categoria criarCategoria(Categoria categoria);
    void deletarCategoria (Long id) throws IdInvalidoException;

    Categoria editarCategoria(Categoria categoria);
}
