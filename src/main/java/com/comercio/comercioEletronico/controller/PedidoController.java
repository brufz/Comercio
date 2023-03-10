package com.comercio.comercioEletronico.controller;

import com.comercio.comercioEletronico.exceptions.EstoqueException;
import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.exceptions.QuantidadeItensInvalidoException;
import com.comercio.comercioEletronico.model.Cliente;
import com.comercio.comercioEletronico.model.Pedido;
import com.comercio.comercioEletronico.model.dto.ClienteResponseDto;
import com.comercio.comercioEletronico.model.dto.PedidoResponseDto;
import com.comercio.comercioEletronico.service.interfaces.ICliente;
import com.comercio.comercioEletronico.service.interfaces.IPedido;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/pedido")
public class PedidoController {
    @Autowired
    IPedido pedidoService;

    @GetMapping
    public ResponseEntity<PedidoResponseDto> buscarTodosPedidos(){
        List<Pedido> pedidos = pedidoService.buscarTodosPedidos();
        PedidoResponseDto response = new PedidoResponseDto("OK", pedidos);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> buscarPorId(@PathVariable("id") Long id) throws IdInvalidoException {
        Optional<Pedido> pedido = pedidoService.buscarPedidoPorId(id);
        PedidoResponseDto response = new PedidoResponseDto("OK", pedido);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> criarPedido(@RequestBody @Valid Pedido pedido) throws Exception, QuantidadeItensInvalidoException, EstoqueException {
        Pedido novoPedido = pedidoService.criarPedido(pedido);
        PedidoResponseDto response = new PedidoResponseDto("CREATED", novoPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPedido(@PathVariable ("id") Long id) throws IdInvalidoException {
        pedidoService.deletarPedido(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<PedidoResponseDto> atualizarPedido(@RequestBody @Valid Pedido pedido){
        Pedido pedidoAtualizado = pedidoService.editarPedido(pedido);
        PedidoResponseDto response = new PedidoResponseDto("OK", pedidoAtualizado);
        return ResponseEntity.ok().body(response);
    }
}
