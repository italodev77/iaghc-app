package com.dev.iagch.application.produtos.dtos;

import java.math.BigDecimal;

public class ProdutoRequestDto {
    public String descricao;
    public Long grupoId;
    public BigDecimal margem;
    public PrecoParcialDto preco;
    public EstoqueParcialDto estoque;
    public FormacaoCustoDto formacaoCusto;
}
