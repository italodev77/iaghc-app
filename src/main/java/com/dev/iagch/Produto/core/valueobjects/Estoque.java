package com.dev.iagch.Produto.core.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Estoque {
    @Column(name = "quantidade_estoque_real", nullable = false)
    private Integer real;

    @Column(name = "quantidade_estoque_armazem", nullable = false)
    private Integer armazem;

    @Column(name = "quantidade_estoque_fiscal", nullable = false)
    private Integer fiscal;

    // construtores, getters, setters



    public Estoque(Integer real, Integer armazem, Integer fiscal) {
        this.real = real;
        this.armazem = armazem;
        this.fiscal = fiscal;
    }

    public Estoque() {
    }

    public Integer getReal() {
        return real;
    }

    public void setReal(Integer real) {
        this.real = real;
    }

    public Integer getArmazem() {
        return armazem;
    }

    public void setArmazem(Integer armazem) {
        this.armazem = armazem;
    }

    public Integer getFiscal() {
        return fiscal;
    }

    public void setFiscal(Integer fiscal) {
        this.fiscal = fiscal;
    }
}
