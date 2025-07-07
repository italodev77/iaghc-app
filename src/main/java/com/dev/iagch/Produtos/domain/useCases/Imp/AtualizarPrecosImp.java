package com.dev.iagch.Produtos.domain.useCases.Imp;


import com.dev.iagch.Produtos.domain.entity.Produto;
import com.dev.iagch.Produtos.domain.useCases.interfaces.IAtualizarPrecosUseCase;
import com.dev.iagch.Produtos.domain.valueobjects.Precos;
import com.dev.iagch.Produtos.infrastructure.repository.ProdutoRepository;

import java.math.BigDecimal;

public class AtualizarPrecosImp implements IAtualizarPrecosUseCase {

    private final ProdutoRepository produtoRepository;


    public AtualizarPrecosImp(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public void atualizarPrecos(Long idProduto, Precos precos) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (precos.getPrecoCusto() != null) {
            produto.setPrecoCusto(precos.getPrecoCusto());
        }
        if (precos.getPrecoVenda() != null) {
            produto.setPrecoVenda(precos.getPrecoVenda());
        }
        if (precos.getPrecoVenda2() != null) {
            produto.setPrecoVenda2(precos.getPrecoVenda2());
        }
        if (precos.getPrecoVenda3() != null) {
            produto.setPrecoVenda3(precos.getPrecoVenda3());
        }
        if (precos.getPrecoFardo() != null) {
            produto.setPrecoFardo(precos.getPrecoFardo());
        }
        if (precos.getPrecoCaixa() != null) {
            produto.setPrecoCaixa(precos.getPrecoCaixa());
        }
        if (precos.getPrecoPalete() != null) {
            produto.setPrecoPalete(precos.getPrecoPalete());
        }

        produtoRepository.save(produto);
    }
}
