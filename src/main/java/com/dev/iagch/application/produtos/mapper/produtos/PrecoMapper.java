package com.dev.iagch.application.produtos.mapper.produtos;

import com.dev.iagch.Core.produtos.valueObjects.Preco;
import com.dev.iagch.application.produtos.dtos.PrecoParcialDto;

public class PrecoMapper {
    public Preco toPrecoParcial(PrecoParcialDto dto) {
        if (dto == null) return null;
        return new Preco(
                dto.precoCompra,
                dto.precoCusto,
                dto.precoVenda,
                dto.precoVenda2,
                dto.precoVendaFardo,
                dto.precoVendaCaixa,
                dto.precoVendaPallet
        );

    }
}