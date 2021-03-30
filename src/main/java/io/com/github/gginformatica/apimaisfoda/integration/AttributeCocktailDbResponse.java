package io.com.github.gginformatica.apimaisfoda.integration;

public class AttributeCocktailDbResponse {
    private final String strDrink;
    private final String strDrinkThumb;
    private final String idDrink;

    public AttributeCocktailDbResponse(final String strDrink, final String strDrinkThumb, final String idDrink) {
        this.strDrink = strDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public String getIdDrink() {
        return idDrink;
    }
}
