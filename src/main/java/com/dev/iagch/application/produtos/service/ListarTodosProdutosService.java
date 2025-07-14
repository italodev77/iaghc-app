package com.dev.iagch.application.produtos.service;

import com.dev.iagch.Core.produtos.entity.Produtos;
import com.dev.iagch.infra.produtos.repository.IprodutoRepository;

import java.util.List;

public class ListarTodosProdutosService {
    private final IprodutoRepository produtoRepository;

    public ListarTodosProdutosService(IprodutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produtos> listarTodos() {
        return produtoRepository.findAll();
    }
}
