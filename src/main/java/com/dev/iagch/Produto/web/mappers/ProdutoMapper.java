package com.dev.iagch.Produto.web.mappers;

import com.dev.iagch.Produto.core.entity.Produto;
import com.dev.iagch.Produto.core.valueobjects.Estoque;
import com.dev.iagch.Produto.core.valueobjects.Precos;
import com.dev.iagch.Produto.web.Dtos.EstoqueDto;
import com.dev.iagch.Produto.web.Dtos.PrecosDto;
import com.dev.iagch.Produto.web.Dtos.ProdutoResponseDto;

public class ProdutoMapper {

    public static ProdutoResponseDto toResponseDto(Produto produto) {
        if (produto == null) return null;

        ProdutoResponseDto dto = new ProdutoResponseDto();
        dto.id = produto.getId();
        dto.codigo = null; // Adapte se você tiver o campo `codigo` na entidade
        dto.descricao = produto.getDescricao();
        dto.caracteristica = produto.getCaracteristica();
        dto.ativo = produto.getAtivo();
        dto.dataCriacao = produto.getDataCriacao();
        dto.dataAtualizacao = produto.getDataAtualizacao();

        if (produto.getPrecos() != null) {
            dto.precos = toPrecosDto(produto.getPrecos());
        }

        if (produto.getEstoque() != null) {
            dto.estoque = toEstoqueDto(produto.getEstoque());
        }

        return dto;
    }

    private static PrecosDto toPrecosDto(Precos precos) {
        PrecosDto dto = new PrecosDto();
        dto.precoCusto = precos.getPrecoCusto();
        dto.precoVenda = precos.getPrecoVenda();
        dto.precoVenda2 = precos.getPrecoVenda2();
        dto.precoVenda3 = precos.getPrecoVenda3();
        dto.precoFardo = precos.getPrecoFardo();
        dto.precoCaixa = precos.getPrecoCaixa();
        dto.precoPalete = precos.getPrecoPalete();
        return dto;
    }

    private static EstoqueDto toEstoqueDto(Estoque estoque) {
        EstoqueDto dto = new EstoqueDto();
        dto.quantidadeEstoqueReal = estoque.getReal();
        dto.quantidadeEstoqueArmazem = estoque.getArmazem();
        dto.quantidadeEstoqueFiscal = estoque.getFiscal();
        return dto;
    }
}
