package com.comercio.comercioEletronico.service;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Cliente;
import com.comercio.comercioEletronico.model.Pedido;
import com.comercio.comercioEletronico.model.Produto;
import com.comercio.comercioEletronico.repository.ClienteRepository;
import com.comercio.comercioEletronico.repository.PedidoRepository;
import com.comercio.comercioEletronico.repository.ProdutoRepository;
import com.comercio.comercioEletronico.service.interfaces.IPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedido {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

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
        Optional<Produto> produtoOptional;
        List<Produto> listaProdutos = new ArrayList<>();
        Optional<Cliente> cliente = clienteRepository.findById(pedido.getCliente().getId());
        for (Produto produto:pedido.getProdutos()) {
            produtoOptional = produtoRepository.findById(produto.getId());
            listaProdutos.add(produtoOptional.get());
        }
        pedido.setCliente(cliente.get());
        pedido.setProdutos(listaProdutos);
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
