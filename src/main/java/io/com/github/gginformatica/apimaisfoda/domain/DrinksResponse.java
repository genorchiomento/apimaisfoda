package io.com.github.gginformatica.apimaisfoda.domain;

public class DrinksResponse {
    private final String nome;
    private final String thumbnail;

    public DrinksResponse(String nome, String thumbnail) {
        this.nome = nome;
        this.thumbnail = thumbnail;
    }

    public String getNome() {
        return nome;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}