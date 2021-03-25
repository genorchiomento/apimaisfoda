package io.com.github.gginformatica.apimaisfoda.domain;

import javax.validation.constraints.NotNull;

public class BebidaRequest {
    @NotNull(message = "nome is empty")
    private String nome;
    @NotNull(message = "categoria is empty")
    private Categoria categoria;
    @NotNull(message = "anoLancamento is empty")
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
