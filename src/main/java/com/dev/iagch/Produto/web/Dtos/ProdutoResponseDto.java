package com.dev.iagch.Produto.web.Dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoResponseDto {
    public Long id;
    public String codigo;
    public String descricao;
    public String caracteristica;
    public PrecosDto precos;
    public EstoqueDto estoque;
    public Boolean ativo;
    public LocalDateTime dataCriacao;
    public LocalDateTime dataAtualizacao;
}
