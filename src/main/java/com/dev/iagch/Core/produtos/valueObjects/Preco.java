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
    private  BigDecimal precoVenda3;
    private  BigDecimal precoVenda4;
    private  BigDecimal precoVenda5;
    private  BigDecimal precoVenda6;




    private BigDecimal defaultIfNull(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }
    public Preco(
            BigDecimal precoCompra,
            BigDecimal precoCusto,
            BigDecimal precoVenda,
            BigDecimal precoVenda2,
            BigDecimal precoVenda3,
            BigDecimal precoVenda4,
            BigDecimal precoVenda5,
            BigDecimal precoVenda6
    ) {
        this.precoCompra = defaultIfNull(precoCompra);
        this.precoCusto = defaultIfNull(precoCusto);
        this.precoVenda = defaultIfNull(precoVenda);
        this.precoVenda2 = defaultIfNull(precoVenda2);
        this.precoVenda3 = defaultIfNull(precoVenda3);
        this.precoVenda4 = defaultIfNull(precoVenda4);
        this.precoVenda5 = defaultIfNull(precoVenda5);
        this.precoVenda6 = defaultIfNull(precoVenda6);

        validarPrecos();
    }
    private void validarPrecos() {
        if (precoVenda.compareTo(precoCusto) < 0) throw new IllegalArgumentException("Preço de venda não pode ser menor que o custo.");
        if (precoVenda2.compareTo(precoCusto) < 0) throw new IllegalArgumentException("Preço de venda 2 não pode ser menor que o custo.");
        if (precoVenda6.compareTo(precoCusto) < 0) throw new IllegalArgumentException("Preço de fardo não pode ser menor que o custo.");
        if (precoVenda4.compareTo(precoCusto) < 0) throw new IllegalArgumentException("Preço de caixa não pode ser menor que o custo.");
        if (precoVenda5.compareTo(precoCusto) < 0) throw new IllegalArgumentException("Preço de pallet não pode ser menor que o custo.");
    }

    public Preco atualizarPrecos(Preco novo) {
        return new Preco(
                novo.precoCompra != null ? novo.precoCompra : this.precoCompra,
                novo.precoCusto != null ? novo.precoCusto : this.precoCusto,
                novo.precoVenda != null ? novo.precoVenda : this.precoVenda,
                novo.precoVenda2 != null ? novo.precoVenda2 : this.precoVenda2,
                novo.precoVenda3 != null ? novo.precoVenda3 : this.precoVenda3,
                novo.precoVenda4 != null ? novo.precoVenda4 : this.precoVenda4,
                novo.precoVenda5 != null ? novo.precoVenda5 : this.precoVenda5,
                novo.precoVenda6 != null ? novo.precoVenda6 : this.precoVenda6
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
                && Objects.equals(precoVenda3, preco.precoVenda3)
                && Objects.equals(precoVenda4, preco.precoVenda4)
                && Objects.equals(precoVenda5, preco.precoVenda5)
                && Objects.equals(precoVenda6, preco.precoVenda6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precoCompra, precoCusto, precoVenda, precoVenda2, precoVenda3, precoVenda4, precoVenda5, precoVenda6);
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

    public BigDecimal getPrecoVenda3() {
        return precoVenda3;
    }

    public BigDecimal getPrecoVenda4() {
        return precoVenda4;
    }

    public BigDecimal getPrecoVenda5() {
        return precoVenda5;
    }
    public BigDecimal getPrecoVenda6() {
        return precoVenda6;
    }




}
