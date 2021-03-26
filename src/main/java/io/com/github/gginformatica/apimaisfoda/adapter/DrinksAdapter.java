package io.com.github.gginformatica.apimaisfoda.adapter;

import io.com.github.gginformatica.apimaisfoda.domain.DrinksResponse;
import io.com.github.gginformatica.apimaisfoda.domain.DrinksWithTheCocktailDbResponse;

public class DrinksAdapter {

    public DrinksResponse castDrink(DrinksWithTheCocktailDbResponse drinksWithTheCocktailDbResponse) {

        return new DrinksResponse(
                drinksWithTheCocktailDbResponse.getStrDrink(),
                drinksWithTheCocktailDbResponse.getStrDrinkThumb()
        );
    }
}
