package io.com.github.gginformatica.apimaisfoda.repository.orm;

import io.com.github.gginformatica.apimaisfoda.domain.enumerable.Categoria;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bebidas")
public class BebidaOrm {
    @Id
    private String id;
    private String nome;
    private Categoria categoria;
    private Integer anoLancamento;

    public BebidaOrm() {
    }

    public BebidaOrm(String id, String nome, Categoria categoria, Integer anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.anoLancamento = anoLancamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
