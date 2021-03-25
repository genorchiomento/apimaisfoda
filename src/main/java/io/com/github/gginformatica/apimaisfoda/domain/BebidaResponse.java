package io.com.github.gginformatica.apimaisfoda.domain;

import java.time.LocalDate;

public class BebidaResponse {
    private String nome;
    private Categoria categoria;
    private Integer anoLancamento;

    public BebidaResponse() {
    }

    public BebidaResponse(String nomeBebida, Categoria categoria, Integer lancamento) {
        this.nome = nomeBebida;
        this.categoria = categoria;
        this.anoLancamento = lancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
