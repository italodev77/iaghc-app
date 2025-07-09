package com.dev.iagch.Produto.core.regras;

import com.dev.iagch.Produto.core.entity.Produto;
import com.dev.iagch.Produto.core.valueobjects.Estoque;
import com.dev.iagch.Produto.infrastructure.repository.ProdutoRepository;

public  class AtualizarEstoque {

    private final ProdutoRepository produtoRepository;

    public AtualizarEstoque(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

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
