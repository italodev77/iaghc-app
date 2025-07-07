package com.dev.iagch.Produtos.infrastructure.repository;

import com.dev.iagch.Produtos.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
