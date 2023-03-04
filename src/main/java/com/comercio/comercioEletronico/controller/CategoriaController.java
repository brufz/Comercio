package com.comercio.comercioEletronico.controller;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Categoria;
import com.comercio.comercioEletronico.model.dto.CategoriaResponseDto;
import com.comercio.comercioEletronico.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<CategoriaResponseDto> buscarTodasCategorias(){
        List<Categoria> categorias = categoriaService.buscarTodasCategorias();
        CategoriaResponseDto response = new CategoriaResponseDto("OK", categorias);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> buscarCategoriaPorId(@PathVariable("id") Long id) throws IdInvalidoException {
        Optional<Categoria> categoria = categoriaService.buscarCategoriaPorId(id);
        CategoriaResponseDto response = new CategoriaResponseDto("ok", categoria);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDto> criarCategoria(@RequestBody @Valid Categoria categoria){
        categoriaService.criarCategoria(categoria);
        CategoriaResponseDto response = new CategoriaResponseDto("CREATED", categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCategoria(@PathVariable Long id) throws IdInvalidoException {
        categoriaService.deletarCategoria(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/id")
    public ResponseEntity<CategoriaResponseDto> editarCategoria(@RequestBody @Valid Categoria categoria){
        categoriaService.editarCategoria(categoria);
        CategoriaResponseDto response = new CategoriaResponseDto("OK", categoria);
        return ResponseEntity.ok().body(response);
    }
}
