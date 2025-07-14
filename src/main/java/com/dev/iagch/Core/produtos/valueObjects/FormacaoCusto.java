package com.dev.iagch.Core.produtos.valueObjects;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class FormacaoCusto {

    private BigDecimal icms;
    private BigDecimal substituicaoTributaria;
    private BigDecimal pis;
    private BigDecimal cofins;
    private BigDecimal ipi;
    private BigDecimal frete;
    private BigDecimal outrasDespesas;
    private BigDecimal desconto;

    protected FormacaoCusto() {}

    public FormacaoCusto(
            BigDecimal icms,
            BigDecimal substituicaoTributaria,
            BigDecimal pis,
            BigDecimal cofins,
            BigDecimal ipi,
            BigDecimal frete,
            BigDecimal outrasDespesas,
            BigDecimal desconto
    ) {
        this.icms = defaultIfNull(icms);
        this.substituicaoTributaria = defaultIfNull(substituicaoTributaria);
        this.pis = defaultIfNull(pis);
        this.cofins = defaultIfNull(cofins);
        this.ipi = defaultIfNull(ipi);
        this.frete = defaultIfNull(frete);
        this.outrasDespesas = defaultIfNull(outrasDespesas);
        this.desconto = defaultIfNull(desconto);

        validarPercentuais();
    }

    private BigDecimal defaultIfNull(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }
    public static FormacaoCusto vazio() {
        return new FormacaoCusto(
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO
        );
    }


    private void validarPercentuais() {
        if (icms.compareTo(BigDecimal.ZERO) < 0 || icms.compareTo(BigDecimal.valueOf(100)) > 0)
            throw new IllegalArgumentException("ICMS inválido");

        if (substituicaoTributaria.compareTo(BigDecimal.ZERO) < 0 || substituicaoTributaria.compareTo(BigDecimal.valueOf(100)) > 0)
            throw new IllegalArgumentException("Icms ST inválido");

        if (pis.compareTo(BigDecimal.ZERO) < 0 || pis.compareTo(BigDecimal.valueOf(100)) > 0)
            throw new IllegalArgumentException("Pis inválido");

        if (cofins.compareTo(BigDecimal.ZERO) < 0 || cofins.compareTo(BigDecimal.valueOf(100)) > 0)
            throw new IllegalArgumentException("Cofins inválido");

        if (ipi.compareTo(BigDecimal.ZERO) < 0 || ipi.compareTo(BigDecimal.valueOf(100)) > 0)
            throw new IllegalArgumentException("ipi inválido");
    }

    public BigDecimal calcularCusto(BigDecimal precoCompra) {
        if (precoCompra == null) {
            throw new IllegalArgumentException("Preço de compra não pode ser nulo");
        }

        return precoCompra
                .add(icms)
                .add(substituicaoTributaria)
                .add(pis)
                .add(cofins)
                .add(ipi)
                .add(frete)
                .add(outrasDespesas)
                .subtract(desconto);
    }

    // Getters e equals/hashCode
}
