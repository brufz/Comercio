package com.comercio.comercioEletronico.repository;

import com.comercio.comercioEletronico.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
