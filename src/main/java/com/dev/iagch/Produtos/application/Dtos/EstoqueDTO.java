package com.dev.iagch.Produtos.application.Dtos;

public class EstoqueDTO {

    private Integer real;

    private Integer armazem;

    private Integer fiscal;

    public EstoqueDTO() {
    }

    public EstoqueDTO(Integer real, Integer armazem, Integer fiscal) {
        this.real = real;
        this.armazem = armazem;
        this.fiscal = fiscal;
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
