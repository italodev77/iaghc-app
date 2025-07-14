package com.dev.iagch.application.produtos.mapper.produtos;

import com.dev.iagch.Core.produtos.valueObjects.Estoque;
import com.dev.iagch.application.produtos.dtos.EstoqueParcialDto;

public class EstoqueMapper {
    public Estoque toEstoqueParcial(EstoqueParcialDto estoqueParcialDto){
        if (estoqueParcialDto == null) return null;
        return new Estoque(
                estoqueParcialDto.estoque,
                estoqueParcialDto.estoqueFiscal,
                estoqueParcialDto.estoqueGalpao
        );
    }
}
