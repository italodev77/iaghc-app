package com.dev.iagch.application.produtos.service;

import com.dev.iagch.Core.produtos.entity.Produtos;
import com.dev.iagch.infra.produtos.repository.IprodutoRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BuscarProdutoPorIdService {

    private final IprodutoRepository produtoRepository;

    public BuscarProdutoPorIdService(IprodutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produtos buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto com ID " + id + " não encontrado"));
    }
}
