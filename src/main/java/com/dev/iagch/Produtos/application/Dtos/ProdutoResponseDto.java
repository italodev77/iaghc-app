package com.dev.iagch.Produtos.application.Dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoResponseDto {
    public Long id;
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
    public Boolean ativo;
    public LocalDateTime dataCriacao;
    public LocalDateTime dataAtualizacao;
}
