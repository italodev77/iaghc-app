package com.dev.iagch.Produtos.domain.entity;

import com.dev.iagch.Produtos.domain.valueobjects.Estoque;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_Produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "codigo_produto", nullable = false, unique = true, length = 50)
    private String codigo;

    @Column(name = "descricao_produto", length = 500)
    private String descricao;

    @Column(name = "caracteristica_produto", nullable = false, length = 150)
    private String caracteristica;

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

    @Embedded
    private Estoque estoque;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Produto() {
        this.estoque = new Estoque();
    }

    public Produto(String codigo, String descricao, String caracteristica, BigDecimal precoCusto, BigDecimal precoVenda,
                   BigDecimal precoVenda2, BigDecimal precoVenda3, BigDecimal precoFardo, BigDecimal precoCaixa,
                   BigDecimal precoPalete, Estoque estoque) {

        this.codigo = codigo;
        this.descricao = descricao;
        this.caracteristica = caracteristica;
        this.precoCusto = precoCusto != null ? precoCusto : BigDecimal.ZERO;
        this.precoVenda = precoVenda != null ? precoVenda : BigDecimal.ZERO;
        this.precoVenda2 = precoVenda2 != null ? precoVenda2 : BigDecimal.ZERO;
        this.precoVenda3 = precoVenda3 != null ? precoVenda3 : BigDecimal.ZERO;
        this.precoFardo = precoFardo != null ? precoFardo : BigDecimal.ZERO;
        this.precoCaixa = precoCaixa != null ? precoCaixa : BigDecimal.ZERO;
        this.precoPalete = precoPalete != null ? precoPalete : BigDecimal.ZERO;
        this.estoque = estoque != null ? estoque : new Estoque();
        this.ativo = true;
    }

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCaracteristica() {
        return caracteristica;
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

    public BigDecimal getPrecoVenda2() {
        return precoVenda2;
    }

    public BigDecimal getPrecoVenda3() {
        return precoVenda3;
    }

    public BigDecimal getPrecoFardo() {
        return precoFardo;
    }

    public BigDecimal getPrecoCaixa() {
        return precoCaixa;
    }

    public BigDecimal getPrecoPalete() {
        return precoPalete;
    }

    public Estoque getEstoque() {
        return estoque;
    }


    public void setQuantidadeEstoqueReal(Integer quantidadeEstoqueReal) {
        if (this.estoque == null) this.estoque = new Estoque();
        this.estoque.setReal(quantidadeEstoqueReal);
    }

    public void setQuantidadeEstoqueArmazem(Integer quantidadeEstoqueArmazem) {
        if (this.estoque == null) this.estoque = new Estoque();
        this.estoque.setArmazem(quantidadeEstoqueArmazem);
    }

    public void setQuantidadeEstoqueFiscal(Integer quantidadeEstoqueFiscal) {
        if (this.estoque == null) this.estoque = new Estoque();
        this.estoque.setFiscal(quantidadeEstoqueFiscal);
    }


    public Boolean getAtivo() {
        return ativo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
}
