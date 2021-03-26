package io.com.github.gginformatica.apimaisfoda.integration;

import io.com.github.gginformatica.apimaisfoda.configuration.FeignConfiguration;
import io.com.github.gginformatica.apimaisfoda.domain.DrinksWithTheCocktailDbResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "cocktailClient", url = "https://www.thecocktaildb.com/api/json/v1/1", configuration = FeignConfiguration.class)
public interface TheCocktailDbIntegration {

    @GetMapping("/filter.php?i=Beer")
    List<String> getCocktails();
}
