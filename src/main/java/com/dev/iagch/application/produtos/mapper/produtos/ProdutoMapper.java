package com.dev.iagch.application.produtos.mapper;

import com.dev.iagch.Core.produtos.entity.Produtos;
import com.dev.iagch.Core.produtos.valueObjects.Estoque;
import com.dev.iagch.Core.produtos.valueObjects.Preco;
import com.dev.iagch.application.produtos.dtos.ProdutoRequestDto;

public class ProdutoMapper {

    public static Produtos toEntity(ProdutoRequestDto dto) {
        Produtos produto = new Produtos();

        produto.atualizarDescricao(dto.descricao);
        produto.atualizarGrupo(dto.grupoId);
        produto.atualizarMargem(dto.margem);

        Preco preco = new Preco(
                dto.preco.precoCompra,
                dto.preco.precoCusto,
                dto.preco.precoVenda,
                dto.preco.precoVenda2,
                dto.preco.precoVendaFardo,
                dto.preco.precoVendaCaixa,
                dto.preco.precoVendaPallet
        );
        produto.atualizarPreco(preco);

        Estoque estoque = new Estoque(
                dto.estoque.estoque,
                dto.estoque.estoqueFiscal,
                dto.estoque.estoqueGalpao
        );
        produto.atualizarEstoque(estoque);

        return produto;
    }
}
