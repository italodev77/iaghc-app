package com.dev.iagch.application.produtos.service;

import com.dev.iagch.Core.produtos.entity.Produtos;
import com.dev.iagch.Core.produtos.valueObjects.Estoque;
import com.dev.iagch.Core.produtos.valueObjects.Preco;
import com.dev.iagch.application.produtos.dtos.ProdutoRequestDto;
import com.dev.iagch.application.produtos.mapper.produtos.*;
import com.dev.iagch.infra.produtos.repository.IprodutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AtualizarProdutoService {

    private final IprodutoRepository produtoRepository;
    private final PrecoMapper precoMapper;
    private final EstoqueMapper estoqueMapper;

    public AtualizarProdutoService(IprodutoRepository produtoRepository, PrecoMapper precoMapper, EstoqueMapper estoqueMapper) {
        this.produtoRepository = produtoRepository;
        this.estoqueMapper = estoqueMapper;
        this.precoMapper = precoMapper;
    }

    @Transactional
    public Produtos atualizarProduto(Long id, ProdutoRequestDto dto) {
        Produtos produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        produto.atualizarDescricao(dto.descricao);
        produto.atualizarGrupo(dto.grupoId);
        produto.atualizarMargem(dto.margem);

        Preco precoAtualizado = precoMapper.toPrecoParcial(dto.preco);
        produto.atualizarPreco(precoAtualizado);

        Estoque estoqueAtualizado = estoqueMapper.toEstoqueParcial(dto.estoque);
        produto.atualizarEstoque(estoqueAtualizado);

        return produtoRepository.save(produto);
    }
}
