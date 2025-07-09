package com.dev.iagch.Produto.core.regras;


import com.dev.iagch.Produto.core.entity.Produto;
import com.dev.iagch.Produto.core.valueobjects.Precos;
import com.dev.iagch.Produto.infrastructure.repository.ProdutoRepository;

public class AtualizarPrecos {

    private final ProdutoRepository produtoRepository;


    public AtualizarPrecos(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

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
