package com.dev.iagch.Produto.web.Dtos;

import java.math.BigDecimal;

public class ProdutoRequestDto {
    public String codigo;
    public String descricao;
    public String caracteristica;
    public BigDecimal precoCusto;
    public BigDecimal precoVenda;
    public BigDecimal precoVenda2;
    public BigDecimal precoVenda3;
    public BigDecimal precoFardo;
    public BigDecimal precoCaixa;
    public BigDecimal precoPalete;
    public Integer quantidadeEstoqueReal;
    public Integer quantidadeEstoqueArmazem;
    public Integer quantidadeEstoqueFiscal;
}
