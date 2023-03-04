package com.comercio.comercioEletronico.repository;

import com.comercio.comercioEletronico.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
