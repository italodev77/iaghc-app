package com.dev.iagch.Produtos.application.service;

import com.dev.iagch.Produtos.application.Dtos.EstoqueDTO;
import com.dev.iagch.Produtos.domain.useCases.interfaces.IAtualizarEstoqueUseCase;
import com.dev.iagch.Produtos.domain.valueobjects.Estoque;

public class EstoqueService {

    private final IAtualizarEstoqueUseCase atualizarEstoqueUseCase;

    public EstoqueService(IAtualizarEstoqueUseCase atualizarEstoqueUseCase) {
        this.atualizarEstoqueUseCase = atualizarEstoqueUseCase;
    }

    public void atualizarEstoqueParcial(Long idProduto, EstoqueDTO estoqueDTO) {
        Estoque estoqueParaAtualizar = new Estoque();

        boolean temAlteracao = false;

        if (estoqueDTO.getReal() != null) {
            estoqueParaAtualizar.setReal(estoqueDTO.getReal());
            temAlteracao = true;
        }
        if (estoqueDTO.getArmazem() != null) {
            estoqueParaAtualizar.setArmazem(estoqueDTO.getArmazem());
            temAlteracao = true;
        }
        if (estoqueDTO.getFiscal() != null) {
            estoqueParaAtualizar.setFiscal(estoqueDTO.getFiscal());
            temAlteracao = true;
        }

        if (!temAlteracao) {
            throw new IllegalArgumentException("Nenhum campo de estoque para atualizar foi informado.");
        }

        atualizarEstoqueUseCase.atualizarEstoque(idProduto, estoqueParaAtualizar);
    }
}
