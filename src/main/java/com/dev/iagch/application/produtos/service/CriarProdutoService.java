package com.dev.iagch.application.produtos.service;

import com.dev.iagch.Core.produtos.entity.Produtos;
import com.dev.iagch.Core.produtos.valueObjects.FormacaoCusto;
import com.dev.iagch.application.produtos.dtos.ProdutoRequestDto;
import com.dev.iagch.application.produtos.mapper.ProdutoMapper;
import com.dev.iagch.infra.produtos.repository.IprodutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CriarProdutoService {

    private final IprodutoRepository produtoRepository;

    public CriarProdutoService(IprodutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produtos criarProduto(ProdutoRequestDto dto) {
        Produtos produto = ProdutoMapper.toEntity(dto);


        produto.atualizarFormacaoCusto(FormacaoCusto.vazio());

        return produtoRepository.save(produto);
    }
}
