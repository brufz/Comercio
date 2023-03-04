package com.comercio.comercioEletronico.service;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Categoria;
import com.comercio.comercioEletronico.repository.CategoriaRepository;
import com.comercio.comercioEletronico.service.interfaces.ICategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoria {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> buscarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> buscarCategoriaPorId(Long id) throws IdInvalidoException {
        validarId(id);
        Optional<Categoria> categoriaPorId = categoriaRepository.findById(id);
        return categoriaPorId;
    }

    @Override
    public Categoria criarCategoria(Categoria categoria) {
        Categoria novaCategoria = categoriaRepository.save(categoria);
        return novaCategoria;
    }

    @Override
    public void deletarCategoria(Long id) throws IdInvalidoException {
        validarId(id);
        categoriaRepository.deleteById(id);
    }

    @Override
    public Categoria editarCategoria( Categoria categoria) {
        Categoria save = categoriaRepository.save(categoria);
        return save;
    }

    public void validarId(Long id) throws IdInvalidoException {
        if (!categoriaRepository.existsById(id)){
            throw new IdInvalidoException("Id não encontrado no banco de dados");
        }
    }

}
