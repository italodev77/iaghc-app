package com.dev.iagch.Produtos.domain.useCases.interfaces;

import com.dev.iagch.Produtos.domain.valueobjects.Precos;

import java.math.BigDecimal;

public interface IAtualizarPrecosUseCase {
    void atualizarPrecos(Long idProduto, Precos precos);
}
