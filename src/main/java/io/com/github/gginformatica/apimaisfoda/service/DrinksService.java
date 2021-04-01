package io.com.github.gginformatica.apimaisfoda.service;

import io.com.github.gginformatica.apimaisfoda.adapter.DrinkAdapter;
import io.com.github.gginformatica.apimaisfoda.domain.DrinkResponse;
import io.com.github.gginformatica.apimaisfoda.integration.DrinkWithTheCocktailDbResponse;
import io.com.github.gginformatica.apimaisfoda.integration.TheCocktailDbIntegration;
import org.springframework.stereotype.Service;

@Service
public class DrinksService {
    private final TheCocktailDbIntegration cocktailDbIntegration;
    private final DrinkAdapter drinkAdapter;

    public DrinksService(TheCocktailDbIntegration theCocktailDbIntegration, DrinkAdapter adapter) {
        cocktailDbIntegration = theCocktailDbIntegration;
        drinkAdapter = adapter;
    }

    public DrinkResponse salvaDrink(final String nome) {
        DrinkWithTheCocktailDbResponse cocktails = cocktailDbIntegration.getCocktails(nome);
        return drinkAdapter.castDrink(cocktails);
    }

}
