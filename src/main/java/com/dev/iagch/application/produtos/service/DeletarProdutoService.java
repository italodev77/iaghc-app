package com.dev.iagch.application.produtos.service;

import com.dev.iagch.infra.produtos.repository.IprodutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DeletarProdutoService {

    private final IprodutoRepository repository;

    public DeletarProdutoService(IprodutoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void deletarPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto com ID " + id + " não encontrado.");
        }

        repository.deleteById(id);
    }
}