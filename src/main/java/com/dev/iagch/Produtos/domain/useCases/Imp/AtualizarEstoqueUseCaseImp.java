package com.dev.iagch.Produtos.domain.useCases.Imp;

import com.dev.iagch.Produtos.domain.entity.Produto;
import com.dev.iagch.Produtos.domain.useCases.interfaces.IAtualizarEstoqueUseCase;
import com.dev.iagch.Produtos.domain.valueobjects.Estoque;
import com.dev.iagch.Produtos.infrastructure.repository.ProdutoRepository;

public  class AtualizarEstoqueUseCaseImp implements IAtualizarEstoqueUseCase {

    private final ProdutoRepository produtoRepository;

    public AtualizarEstoqueUseCaseImp(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void atualizarEstoque(Long idProduto, Estoque estoque) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (estoque.getReal() != null) {
            produto.setQuantidadeEstoqueReal(estoque.getReal());
        }
        if (estoque.getArmazem() != null) {
            produto.setQuantidadeEstoqueArmazem(estoque.getArmazem());
        }
        if (estoque.getFiscal() != null) {
            produto.setQuantidadeEstoqueFiscal(estoque.getFiscal());
        }

        produtoRepository.save(produto);
    }
}
