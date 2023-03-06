package com.comercio.comercioEletronico.service.interfaces;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Cliente;
import com.comercio.comercioEletronico.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface IPedido {

    List<Pedido> buscarTodosPedidos();
    Optional<Pedido> buscarPedidoPorId(Long id) throws IdInvalidoException;
    Pedido criarPedido(Pedido pedido);
    void deletarPedido (Long id) throws IdInvalidoException;
    Pedido editarPedido(Pedido pedido);
}
