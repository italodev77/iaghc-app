package com.dev.iagch.Produto.service;

import com.dev.iagch.Produto.core.entity.Produto;
import com.dev.iagch.Produto.core.regras.AtualizarEstoque;
import com.dev.iagch.Produto.core.regras.AtualizarPrecos;
import com.dev.iagch.Produto.core.valueobjects.Estoque;
import com.dev.iagch.Produto.core.valueobjects.Precos;
import com.dev.iagch.Produto.infrastructure.repository.ProdutoRepository;
import com.dev.iagch.Produto.web.Dtos.*;
import com.dev.iagch.Produto.web.mappers.ProdutoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final AtualizarEstoque atualizarEstoque;
    private final AtualizarPrecos atualizarPrecos;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
        this.atualizarEstoque = new AtualizarEstoque(produtoRepository);
        this.atualizarPrecos = new AtualizarPrecos(produtoRepository);
    }

    @Transactional
    public ProdutoResponseDto criarProduto(ProdutoRequestDto dto) {
        Produto produto = new Produto(
                null,
                dto.descricao,
                dto.caracteristica,
                toPrecos(dto.precos),
                toEstoque(dto.estoque),
                dto.ativo != null ? dto.ativo : true,
                null,
                null
        );

        produto = produtoRepository.save(produto);
        return ProdutoMapper.toResponseDto(produto);
    }

    @Transactional
    public ProdutoResponseDto atualizarPrecosProduto(Long idProduto, PrecosDto precosDto) {
        atualizarPrecos.atualizarPrecos(idProduto, toPrecos(precosDto));

        Produto produtoAtualizado = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return ProdutoMapper.toResponseDto(produtoAtualizado);
    }

    @Transactional
    public ProdutoResponseDto atualizarEstoqueProduto(Long idProduto, EstoqueDto estoqueDto) {
        atualizarEstoque.atualizarEstoque(idProduto, toEstoque(estoqueDto));

        Produto produtoAtualizado = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return ProdutoMapper.toResponseDto(produtoAtualizado);
    }

    public ProdutoResponseDto buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return ProdutoMapper.toResponseDto(produto);
    }

    // Métodos auxiliares para conversão de DTOs
    private Precos toPrecos(PrecosDto dto) {
        if (dto == null) return null;

        return new Precos(
                dto.precoCusto,
                dto.precoVenda,
                dto.precoVenda2,
                dto.precoVenda3,
                dto.precoFardo,
                dto.precoCaixa,
                dto.precoPalete
        );
    }

    private Estoque toEstoque(EstoqueDto dto) {
        if (dto == null) return null;

        return new Estoque(
                dto.quantidadeEstoqueReal,
                dto.quantidadeEstoqueArmazem,
                dto.quantidadeEstoqueFiscal
        );
    }
}
