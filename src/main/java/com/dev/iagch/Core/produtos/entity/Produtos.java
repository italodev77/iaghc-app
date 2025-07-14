package com.dev.iagch.Core.produtos.entity;

import com.dev.iagch.Core.produtos.valueObjects.Estoque;
import com.dev.iagch.Core.produtos.valueObjects.FormacaoCusto;
import com.dev.iagch.Core.produtos.valueObjects.Preco;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Long grupoId;

    private BigDecimal margem;

    @Embedded
    private Preco preco;

    @Embedded
    private Estoque estoque;

    @Embedded
    private FormacaoCusto formacaoCusto;

    // Atualizadores
    public void atualizarDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }
        this.descricao = descricao;
    }

    public void atualizarGrupo(Long grupoId) {
        if (grupoId == null || grupoId <= 0) {
            throw new IllegalArgumentException("Grupo inválido");
        }
        this.grupoId = grupoId;
    }

    public void atualizarMargem(BigDecimal margem) {
        if (margem == null || margem.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Margem inválida");
        }
        this.margem = margem;
    }

    public void atualizarPreco(Preco novoPreco) {
        if (novoPreco == null) {
            throw new IllegalArgumentException("Preço não pode ser nulo");
        }
        this.preco = this.preco == null ? novoPreco : this.preco.atualizarPrecos(novoPreco);
    }

    public void atualizarEstoque(Estoque novoEstoque){
        this.estoque = this.estoque == null ? novoEstoque : this.estoque.atualizarEstoque(novoEstoque);
    }

    public void atualizarFormacaoCusto(FormacaoCusto novaFormacaoCusto) {
        if (novaFormacaoCusto == null) {
            throw new IllegalArgumentException("Formação de custo não pode ser nula");
        }
        this.formacaoCusto = novaFormacaoCusto;
    }

    public BigDecimal getPrecoCustoTotal() {
        return this.formacaoCusto != null
                ? this.formacaoCusto.calcularCusto(preco.getPrecoCusto())
                : preco.getPrecoCusto(); // fallback seguro
    }
}
