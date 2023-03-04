package com.comercio.comercioEletronico.controller;

import com.comercio.comercioEletronico.exceptions.IdInvalidoException;
import com.comercio.comercioEletronico.model.Cliente;
import com.comercio.comercioEletronico.model.Produto;
import com.comercio.comercioEletronico.model.dto.ClienteResponseDto;
import com.comercio.comercioEletronico.model.dto.ProdutoResponseDto;
import com.comercio.comercioEletronico.service.interfaces.ICliente;
import com.comercio.comercioEletronico.service.interfaces.IProduto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {
    @Autowired
    ICliente clienteService;

    @GetMapping
    public ResponseEntity<ClienteResponseDto> buscarTodosClientes(){
        List<Cliente> clientes = clienteService.buscarTodosClientes();
        ClienteResponseDto response = new ClienteResponseDto("OK", clientes);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> buscarPorId(@PathVariable("id") Long id) throws IdInvalidoException {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        ClienteResponseDto response = new ClienteResponseDto("OK", cliente);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> criarCliente(@RequestBody @Valid Cliente cliente){
        Cliente novoCliente = clienteService.criarCliente(cliente);
        ClienteResponseDto response = new ClienteResponseDto("CREATED", novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable ("id") Long id) throws IdInvalidoException {
        clienteService.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<ClienteResponseDto> atualizarCliente(@RequestBody @Valid Cliente cliente){
        Cliente clienteAtualizado = clienteService.editarCliente(cliente);
        ClienteResponseDto response = new ClienteResponseDto("OK", clienteAtualizado);
        return ResponseEntity.ok().body(response);
    }
}
