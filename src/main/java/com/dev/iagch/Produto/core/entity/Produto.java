package com.dev.iagch.Produto.core.entity;

import com.dev.iagch.Produto.core.valueobjects.Estoque;
import com.dev.iagch.Produto.core.valueobjects.Precos;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_Produtos")
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "descricao_produto", length = 500)
    private String descricao;

    @Column(name = "caracteristica_produto", nullable = false, length = 150)
    private String caracteristica;

    @Embedded
    private Precos precos;

    @Embedded
    private Estoque estoque;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Produto(Long id, String descricao, String caracteristica, Precos precos, Estoque estoque, Boolean ativo, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.descricao = descricao;
        this.caracteristica = caracteristica;
        this.precos = precos;
        this.estoque = estoque;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        if (this.precos == null) this.precos = new Precos();
        this.precos.setPrecoCusto(precoCusto);
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        if (this.precos == null) this.precos = new Precos();
        this.precos.setPrecoVenda(precoVenda);
    }

    public void setPrecoVenda2(BigDecimal precoVenda2) {
        if (this.precos == null) this.precos = new Precos();
        this.precos.setPrecoVenda2(precoVenda2);
    }

    public void setPrecoVenda3(BigDecimal precoVenda3) {
        if (this.precos == null) this.precos = new Precos();
        this.precos.setPrecoVenda3(precoVenda3);
    }

    public void setPrecoFardo(BigDecimal precoFardo) {
        if (this.precos == null) this.precos = new Precos();
        this.precos.setPrecoFardo(precoFardo);
    }

    public void setPrecoCaixa(BigDecimal precoCaixa) {
        if (this.precos == null) this.precos = new Precos();
        this.precos.setPrecoCaixa(precoCaixa);
    }

    public void setPrecoPalete(BigDecimal precoPalete) {
        if (this.precos == null) this.precos = new Precos();
        this.precos.setPrecoPalete(precoPalete);
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

    public String getDescricao() {
        return descricao;
    }

    public String getCaracteristica() {
        return caracteristica;
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
    public Precos getPrecos() {
        return precos;
    }

    public Estoque getEstoque() {
        return estoque;
    }

}
