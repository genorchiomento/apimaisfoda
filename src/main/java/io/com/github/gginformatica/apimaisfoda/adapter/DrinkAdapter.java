package io.com.github.gginformatica.apimaisfoda.adapter;

import io.com.github.gginformatica.apimaisfoda.domain.AtributoDrinkResponse;
import io.com.github.gginformatica.apimaisfoda.domain.DrinkResponse;
import io.com.github.gginformatica.apimaisfoda.integration.DrinkWithTheCocktailDbResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DrinkAdapter {

    public DrinkResponse castDrink(DrinkWithTheCocktailDbResponse drinkCocktailDbResponse) {
        List<AtributoDrinkResponse> listAtributos = new ArrayList<>();
        drinkCocktailDbResponse.getDrinks().forEach(v -> {
            AtributoDrinkResponse atritubo = new AtributoDrinkResponse(v.getStrDrink(), v.getStrDrinkThumb());
            listAtributos.add(atritubo);
        });
        return new DrinkResponse(listAtributos);
    }
}
