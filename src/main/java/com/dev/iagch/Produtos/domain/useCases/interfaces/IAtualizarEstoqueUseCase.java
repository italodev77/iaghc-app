package com.dev.iagch.Produtos.domain.useCases.interfaces;

import com.dev.iagch.Produtos.domain.valueobjects.Estoque;

public interface IAtualizarEstoqueUseCase {
    void atualizarEstoque(Long idProduto, Estoque estoque);
}
