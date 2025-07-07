package com.dev.iagch.Produtos.application.mappers;

import com.dev.iagch.Produtos.application.Dtos.EstoqueDTO;
import com.dev.iagch.Produtos.domain.valueobjects.Estoque;

public class EstoqueMapper {

    public static EstoqueDTO toDTO(Estoque estoque) {
        if (estoque == null) return null;

        EstoqueDTO dto = new EstoqueDTO();
        dto.setReal(estoque.getReal());
        dto.setArmazem(estoque.getArmazem());
        dto.setFiscal(estoque.getFiscal());

        return dto;
    }

    public static Estoque toEntity(EstoqueDTO dto) {
        if (dto == null) return null;

        Estoque estoque = new Estoque();
        estoque.setReal(dto.getReal());
        estoque.setArmazem(dto.getArmazem());
        estoque.setFiscal(dto.getFiscal());

        return estoque;
    }
}
