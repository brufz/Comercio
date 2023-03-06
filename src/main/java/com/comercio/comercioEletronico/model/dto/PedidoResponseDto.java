package com.comercio.comercioEletronico.model.dto;

import com.comercio.comercioEletronico.model.Pedido;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class PedidoResponseDto {
    private String codigoRetorno;

    private List<Pedido> dados;

    private Pedido pedido;

    public PedidoResponseDto(String codigoRetorno, Pedido pedido) {
        this.codigoRetorno = codigoRetorno;
        this.pedido = pedido;
    }

    public PedidoResponseDto(String codigoRetorno, List<Pedido> dados) {
        this.codigoRetorno = codigoRetorno;
        this.dados = dados;
    }

    public PedidoResponseDto(String codigoRetorno, Optional<Pedido> pedido) {
        this.codigoRetorno = codigoRetorno;
        this.pedido = pedido.orElse(null);
    }
}
