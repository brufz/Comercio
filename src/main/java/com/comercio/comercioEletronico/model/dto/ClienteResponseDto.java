package com.comercio.comercioEletronico.model.dto;

import com.comercio.comercioEletronico.model.Categoria;
import com.comercio.comercioEletronico.model.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class ClienteResponseDto {
    private String codigoRetorno;

    private List<Cliente> dados;

    private Cliente cliente;

    public ClienteResponseDto(String codigoRetorno, Cliente cliente) {
        this.codigoRetorno = codigoRetorno;
        this.cliente = cliente;
    }

    public ClienteResponseDto(String codigoRetorno, List<Cliente> dados) {
        this.codigoRetorno = codigoRetorno;
        this.dados = dados;
    }

    public ClienteResponseDto(String codigoRetorno, Optional<Cliente> cliente) {
        this.codigoRetorno = codigoRetorno;
        this.cliente = cliente.orElse(null);
    }
}
