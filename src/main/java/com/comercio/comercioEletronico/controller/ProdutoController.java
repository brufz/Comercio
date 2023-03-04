package com.comercio.comercioEletronico.controller;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Produto;
import com.comercio.comercioEletronico.model.dto.ProdutoResponseDto;
import com.comercio.comercioEletronico.service.ProdutoService;
import com.comercio.comercioEletronico.service.interfaces.IProduto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/produto")
public class ProdutoController {

    @Autowired
    IProduto produtoService;

    @GetMapping
    public ResponseEntity<ProdutoResponseDto> buscarTodosProdutos(){
        List<Produto> produtos = produtoService.buscarTodosProdutos();
        ProdutoResponseDto response = new ProdutoResponseDto("OK", produtos);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> buscarPorId(@PathVariable("id") Long id) throws IdInvalidoException {
        Optional<Produto> produto = produtoService.buscarProdutoPorId(id);
        ProdutoResponseDto response = new ProdutoResponseDto("OK", produto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> criarProduto(@RequestBody @Valid Produto produto){
        Produto novoProduto = produtoService.criarProduto(produto);
        ProdutoResponseDto response = new ProdutoResponseDto("CREATED", produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable ("id") Long id) throws IdInvalidoException {
        produtoService.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<ProdutoResponseDto> atualizarProduto(@RequestBody @Valid Produto produto){
        Produto produtoAtualizado = produtoService.editarProduto(produto);
        ProdutoResponseDto response = new ProdutoResponseDto("OK", produtoAtualizado);
        return ResponseEntity.ok().body(response);
    }
}
