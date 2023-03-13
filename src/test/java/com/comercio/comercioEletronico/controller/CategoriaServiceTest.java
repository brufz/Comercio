package com.comercio.comercioEletronico.controller;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.factory.CategoriaFactory;
import com.comercio.comercioEletronico.model.Categoria;
import com.comercio.comercioEletronico.repository.CategoriaRepository;
import com.comercio.comercioEletronico.service.CategoriaService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    @Mock
    CategoriaRepository categoriaRepository;

    @InjectMocks
    CategoriaService categoriaService;

    @Test
    public void buscarTodasAsCategoriasQuandoSucesso(){
        when(categoriaRepository.findAll()).thenReturn(CategoriaFactory.getCategorias());
        List<Categoria> categorias = categoriaService.buscarTodasCategorias();
        Assertions.assertEquals(3, categorias.size());
    }

    @Test
    public void testarBuscarCategoriaPorIdQuandoSucesso() throws IdInvalidoException {
        when(categoriaRepository.existsById(1L)).thenReturn(true);
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(new Categoria(1L, "smartphone", "celular nota 1000")));
        Optional<Categoria> categorias = categoriaService.buscarCategoriaPorId(1L);
        Assertions.assertEquals(1L, categorias.get().getId());
    }

    @Test
    public void testarBuscarCategoriaPorIdLancandoIdInvalidoException() throws IdInvalidoException {
        when(categoriaRepository.existsById(5L)).thenReturn(false);
        Assertions.assertThrows(IdInvalidoException.class, () -> categoriaService.buscarCategoriaPorId(5L));
    }



}
