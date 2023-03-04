package com.comercio.comercioEletronico.model.dto;

import com.comercio.comercioEletronico.model.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class ProdutoResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigoRetorno;

    private List<Produto> dados;

    private Produto produto;

    public ProdutoResponseDto(String codigoRetorno, Produto produto) {
        this.codigoRetorno = codigoRetorno;
        this.produto = produto;
    }

    public ProdutoResponseDto(String codigoRetorno, List<Produto> dados) {
        this.codigoRetorno = codigoRetorno;
        this.dados = dados;
    }

    public ProdutoResponseDto(String codigoRetorno, Optional<Produto> produto) {
        this.codigoRetorno = codigoRetorno;
        this.produto = produto.orElse(null);
    }
}
