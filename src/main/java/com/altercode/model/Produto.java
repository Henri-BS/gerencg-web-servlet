package com.altercode.model;

import java.time.LocalDate;

public class Produto {
    private Long id;
    private String descricao;
    private String quantidade;
    private String preco;
    private String validade;
    private Categoria categoria;
    private UnidadeMedida medida;

    public Produto() {}

    public Produto(Long pk, String descricao, String quantidade, String preco, String validade, Categoria categoria, UnidadeMedida medida) {
        this.id = pk;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.validade = validade;
        this.categoria = categoria;
        this.medida = medida;
    }

    public Produto(String descricaoStr, Integer quantidade, Double preco, LocalDate validade, Categoria categoria, UnidadeMedida medida) {
    }

    public Produto(Long pk, String descricao, int quantidade, double preco, LocalDate validade, Categoria categoria, UnidadeMedida medida) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public UnidadeMedida getMedida() {
        return medida;
    }

    public void setMedida(UnidadeMedida medida) {
        this.medida = medida;
    }
}
