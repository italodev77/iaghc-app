package com.dev.iagch.Produtos.domain.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.math.BigDecimal;

@Embeddable
public class Precos {
    @Column(name = "preco_custo", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoCusto;

    @Column(name = "preco_venda", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoVenda;

    @Column(name = "preco_venda_2", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoVenda2;

    @Column(name = "preco_venda_3", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoVenda3;

    @Column(name = "preco_fardo", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoFardo;

    @Column(name = "preco_caixa", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoCaixa;

    @Column(name = "preco_palete", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoPalete;

    public Precos(BigDecimal precoCusto, BigDecimal precoCaixa, BigDecimal precoFardo, BigDecimal precoVenda3, BigDecimal precoVenda2, BigDecimal precoVenda, BigDecimal precoPalete) {
        this.precoCusto = precoCusto;
        this.precoCaixa = precoCaixa;
        this.precoFardo = precoFardo;
        this.precoVenda3 = precoVenda3;
        this.precoVenda2 = precoVenda2;
        this.precoVenda = precoVenda;
        this.precoPalete = precoPalete;
    }

    public Precos() {
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public BigDecimal getPrecoVenda2() {
        return precoVenda2;
    }

    public void setPrecoVenda2(BigDecimal precoVenda2) {
        this.precoVenda2 = precoVenda2;
    }

    public BigDecimal getPrecoVenda3() {
        return precoVenda3;
    }

    public void setPrecoVenda3(BigDecimal precoVenda3) {
        this.precoVenda3 = precoVenda3;
    }

    public BigDecimal getPrecoFardo() {
        return precoFardo;
    }

    public void setPrecoFardo(BigDecimal precoFardo) {
        this.precoFardo = precoFardo;
    }

    public BigDecimal getPrecoCaixa() {
        return precoCaixa;
    }

    public void setPrecoCaixa(BigDecimal precoCaixa) {
        this.precoCaixa = precoCaixa;
    }

    public BigDecimal getPrecoPalete() {
        return precoPalete;
    }

    public void setPrecoPalete(BigDecimal precoPalete) {
        this.precoPalete = precoPalete;
    }
}
