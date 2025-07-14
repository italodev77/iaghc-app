package com.dev.iagch.infra.produtos.repository;

import com.dev.iagch.Core.produtos.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IprodutoRepository extends JpaRepository<Produtos, Long> {
}
