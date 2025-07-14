package com.dev.iagch.Core.produtos.valueObjects;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Estoque {

    private int estoque;
    private int estoqueFiscal;
    private int estoqueGalpao;

    protected Estoque() {

    }

    public Estoque(int estoque, int estoqueFiscal, int estoqueGalpao) {
        if (estoque < 0 || estoqueFiscal < 0 || estoqueGalpao < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo.");
        }
        this.estoque = estoque;
        this.estoqueFiscal = estoqueFiscal;
        this.estoqueGalpao = estoqueGalpao;
    }

    public Estoque atualizarEstoque(Estoque novo) {
        return new Estoque(
                novo.estoque >= 0 ? novo.estoque : this.estoque,
                novo.estoqueFiscal >= 0 ? novo.estoqueFiscal : this.estoqueFiscal,
                novo.estoqueGalpao >= 0 ? novo.estoqueGalpao : this.estoqueGalpao
        );
    }

    public int getEstoque() {
        return estoque;
    }

    public int getEstoqueFiscal() {
        return estoqueFiscal;
    }

    public int getEstoqueGalpao() {
        return estoqueGalpao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estoque)) return false;
        Estoque estoque1 = (Estoque) o;
        return estoque == estoque1.estoque &&
                estoqueFiscal == estoque1.estoqueFiscal &&
                estoqueGalpao == estoque1.estoqueGalpao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(estoque, estoqueFiscal, estoqueGalpao);
    }
}
