package com.dev.iagch.Produto.infrastructure.repository;

import com.dev.iagch.Produto.core.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
