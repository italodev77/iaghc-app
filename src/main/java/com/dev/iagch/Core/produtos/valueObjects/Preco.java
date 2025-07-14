package com.dev.iagch.Core.produtos.valueObjects;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class Preco {

    private  BigDecimal precoCompra;
    private  BigDecimal precoCusto;
    private  BigDecimal precoVenda;
    private  BigDecimal precoVenda2;
    private  BigDecimal precoVendaFardo;
    private  BigDecimal precoVendaCaixa;
    private  BigDecimal precoVendaPallet;




    private BigDecimal defaultIfNull(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }
    public Preco(
            BigDecimal precoCompra,
            BigDecimal precoCusto,
            BigDecimal precoVenda,
            BigDecimal precoVenda2,
            BigDecimal precoVendaFardo,
            BigDecimal precoVendaCaixa,
            BigDecimal precoVendaPallet
    ) {
        this.precoCompra = defaultIfNull(precoCompra);
        this.precoCusto = defaultIfNull(precoCusto);
        this.precoVenda = defaultIfNull(precoVenda);
        this.precoVenda2 = defaultIfNull(precoVenda2);
        this.precoVendaFardo = defaultIfNull(precoVendaFardo);
        this.precoVendaCaixa = defaultIfNull(precoVendaCaixa);
        this.precoVendaPallet = defaultIfNull(precoVendaPallet);

        validarPrecos();
    }
    private void validarPrecos() {
        if (precoVenda.compareTo(precoCusto) < 0) throw new IllegalArgumentException("Preço de venda não pode ser menor que o custo.");
        if (precoVenda2.compareTo(precoCusto) < 0) throw new IllegalArgumentException("Preço de venda 2 não pode ser menor que o custo.");
        if (precoVendaFardo.compareTo(precoCusto) < 0) throw new IllegalArgumentException("Preço de fardo não pode ser menor que o custo.");
        if (precoVendaCaixa.compareTo(precoCusto) < 0) throw new IllegalArgumentException("Preço de caixa não pode ser menor que o custo.");
        if (precoVendaPallet.compareTo(precoCusto) < 0) throw new IllegalArgumentException("Preço de pallet não pode ser menor que o custo.");
    }

    public Preco atualizarPrecos(Preco novo) {
        return new Preco(
                novo.precoCompra != null ? novo.precoCompra : this.precoCompra,
                novo.precoCusto != null ? novo.precoCusto : this.precoCusto,
                novo.precoVenda != null ? novo.precoVenda : this.precoVenda,
                novo.precoVenda2 != null ? novo.precoVenda2 : this.precoVenda2,
                novo.precoVendaFardo != null ? novo.precoVendaFardo : this.precoVendaFardo,
                novo.precoVendaCaixa != null ? novo.precoVendaCaixa : this.precoVendaCaixa,
                novo.precoVendaPallet != null ? novo.precoVendaPallet : this.precoVendaPallet
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Preco)) return false;
        Preco preco = (Preco) o;
        return Objects.equals(precoCompra, preco.precoCompra)
                && Objects.equals(precoCusto, preco.precoCusto)
                && Objects.equals(precoVenda, preco.precoVenda)
                && Objects.equals(precoVenda2, preco.precoVenda2)
                && Objects.equals(precoVendaFardo, preco.precoVendaFardo)
                && Objects.equals(precoVendaCaixa, preco.precoVendaCaixa)
                && Objects.equals(precoVendaPallet, preco.precoVendaPallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precoCompra, precoCusto, precoVenda, precoVenda2, precoVendaFardo, precoVendaCaixa, precoVendaPallet);
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public BigDecimal getPrecoVenda2() {
        return precoVenda2;
    }

    public BigDecimal getPrecoVendaFardo() {
        return precoVendaFardo;
    }

    public BigDecimal getPrecoVendaCaixa() {
        return precoVendaCaixa;
    }

    public BigDecimal getPrecoVendaPallet() {
        return precoVendaPallet;
    }



}
