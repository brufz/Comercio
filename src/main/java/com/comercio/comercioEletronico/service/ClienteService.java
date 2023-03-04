package com.comercio.comercioEletronico.service;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Cliente;
import com.comercio.comercioEletronico.repository.ClienteRepository;
import com.comercio.comercioEletronico.service.interfaces.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements ICliente {

    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarClientePorId(Long id) throws IdInvalidoException {
        validarId(id);
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente;
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        Cliente novoCliente = clienteRepository.save(cliente);
        return novoCliente;
    }

    @Override
    public void deletarCliente(Long id) throws IdInvalidoException {
        validarId(id);
        clienteRepository.deleteById(id);

    }

    @Override
    public Cliente editarCliente(Cliente cliente) {
        Cliente save = clienteRepository.save(cliente);
        return save;
    }

    public void validarId(Long id) throws IdInvalidoException {
        if (!clienteRepository.existsById(id)) {
            throw new IdInvalidoException("Id não encontrado no banco de dados");
        }
    }
}
