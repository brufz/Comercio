package com.comercio.comercioEletronico.repository;

import com.comercio.comercioEletronico.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
