package io.com.github.gginformatica.apimaisfoda.domain;

public class DrinksWithTheCocktailDbResponse {
    private final String strDrink;
    private final String strDrinkThumb;
    private final String idDrink;

    public DrinksWithTheCocktailDbResponse(final String strDrink, final String strDrinkThumb, final String idDrink) {
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
