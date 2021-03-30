package io.com.github.gginformatica.apimaisfoda.api;

import io.com.github.gginformatica.apimaisfoda.adapter.DrinkAdapter;
import io.com.github.gginformatica.apimaisfoda.domain.DrinkResponse;
import io.com.github.gginformatica.apimaisfoda.integration.DrinkWithTheCocktailDbResponse;
import io.com.github.gginformatica.apimaisfoda.integration.TheCocktailDbIntegration;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping
public class DrinksApi {
    private final TheCocktailDbIntegration cocktailDbIntegration;
    private final DrinkAdapter drinkAdapter;

    public DrinksApi(TheCocktailDbIntegration theCocktailDbIntegration, DrinkAdapter adapter) {
        cocktailDbIntegration = theCocktailDbIntegration;
        drinkAdapter = adapter;
    }

    @GetMapping("/drinks/{bebida}")
    @ResponseStatus(OK)
    public DrinkResponse salvaDrink(@PathVariable("bebida") String nome) {
        DrinkWithTheCocktailDbResponse cocktails = cocktailDbIntegration.getCocktails(nome);
        return drinkAdapter.castDrink(cocktails);
    }
}
