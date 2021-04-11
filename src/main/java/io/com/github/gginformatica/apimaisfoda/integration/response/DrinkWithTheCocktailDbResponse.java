package io.com.github.gginformatica.apimaisfoda.integration.response;

import java.util.List;

public class DrinkWithTheCocktailDbResponse {
    private List<AttributeCocktailDbResponse> drinks;

    public List<AttributeCocktailDbResponse> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<AttributeCocktailDbResponse> drinks) {
        this.drinks = drinks;
    }
}
