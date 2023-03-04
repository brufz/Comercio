package com.comercio.comercioEletronico.service.interfaces;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Cliente;
import com.comercio.comercioEletronico.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ICliente {

    List<Cliente> buscarTodosClientes();
    Optional<Cliente> buscarClientePorId(Long id) throws IdInvalidoException;
    Cliente criarCliente(Cliente cliente);
    void deletarCliente (Long id) throws IdInvalidoException;
    Cliente editarCliente(Cliente cliente);
}
