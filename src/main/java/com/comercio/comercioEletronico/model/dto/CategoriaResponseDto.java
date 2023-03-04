package com.comercio.comercioEletronico.model.dto;

import com.comercio.comercioEletronico.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class CategoriaResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigoRetorno;

    private List<Categoria> dados;

    private Categoria categoria;

    public CategoriaResponseDto(String codigoRetorno, Categoria categoria) {
        this.codigoRetorno = codigoRetorno;
        this.categoria = categoria;
    }

    public CategoriaResponseDto(String codigoRetorno, List<Categoria> dados) {
        this.codigoRetorno = codigoRetorno;
        this.dados = dados;
    }

    public CategoriaResponseDto(String codigoRetorno, Optional<Categoria> categoria) {
        this.codigoRetorno = codigoRetorno;
        this.categoria = categoria.orElse(null);
    }
}
