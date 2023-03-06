package com.comercio.comercioEletronico.service;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Pedido;
import com.comercio.comercioEletronico.repository.PedidoRepository;
import com.comercio.comercioEletronico.service.interfaces.IPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedido {

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> buscarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> buscarPedidoPorId(Long id) throws IdInvalidoException {
        validarId(id);
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return novoPedido;
    }

    @Override
    public void deletarPedido(Long id) throws IdInvalidoException {
        validarId(id);
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido editarPedido(Pedido pedido) {
        Pedido save = pedidoRepository.save(pedido);
        return save;
    }

    public void validarId(Long id) throws IdInvalidoException {
        if (!pedidoRepository.existsById(id)) {
            throw new IdInvalidoException("Id não encontrado no banco de dados");
        }
    }
}
