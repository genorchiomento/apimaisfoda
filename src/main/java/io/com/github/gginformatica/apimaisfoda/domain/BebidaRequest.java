package io.com.github.gginformatica.apimaisfoda.domain;

import javax.validation.constraints.NotNull;

public class BebidaRequest {
    @NotNull(message = "nome está vazio")
    private String nome;
    @NotNull(message = "categoria está vazio")
    private Categoria categoria;
    @NotNull(message = "anoLancamento está vazio")
    private Integer anoLancamento;

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
