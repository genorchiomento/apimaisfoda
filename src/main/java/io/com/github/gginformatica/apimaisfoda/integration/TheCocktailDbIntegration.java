package io.com.github.gginformatica.apimaisfoda.integration;

import io.com.github.gginformatica.apimaisfoda.integration.response.DrinkWithTheCocktailDbResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cocktailClient", url = "https://www.thecocktaildb.com/api/json/v1/1")
public interface TheCocktailDbIntegration {

    @GetMapping("/filter.php?i={bebida}")
    DrinkWithTheCocktailDbResponse getCocktails(@PathVariable String bebida);
}

