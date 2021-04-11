package io.com.github.gginformatica.apimaisfoda.services;

import io.com.github.gginformatica.apimaisfoda.ApimaisfodaApplicationTests;
import io.com.github.gginformatica.apimaisfoda.adapter.DrinkAdapter;
import io.com.github.gginformatica.apimaisfoda.domain.dto.AtributoDrinkResponse;
import io.com.github.gginformatica.apimaisfoda.domain.dto.DrinkResponse;
import io.com.github.gginformatica.apimaisfoda.integration.TheCocktailDbIntegration;
import io.com.github.gginformatica.apimaisfoda.integration.response.AttributeCocktailDbResponse;
import io.com.github.gginformatica.apimaisfoda.integration.response.DrinkWithTheCocktailDbResponse;
import io.com.github.gginformatica.apimaisfoda.service.DrinksService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DrinksServiceTest extends ApimaisfodaApplicationTests {

    @InjectMocks
    private DrinksService drinksService;

    @Mock
    private TheCocktailDbIntegration cocktailDbIntegration;

    @Mock
    private DrinkAdapter drinkAdapter;

    @Override
    public void init() {

    }

    @Test
    public void salvaDrinkTest() {
        List<AttributeCocktailDbResponse> attributeCocktailDbResponses = new ArrayList<>();
        attributeCocktailDbResponses.add(new AttributeCocktailDbResponse("nome 1", "foto 1", "1"));
        attributeCocktailDbResponses.add(new AttributeCocktailDbResponse("nome 2", "foto 2", "2"));
        attributeCocktailDbResponses.add(new AttributeCocktailDbResponse("nome 3", "foto 3", "3"));

        DrinkWithTheCocktailDbResponse drinkWithTheCocktailDbResponse = new DrinkWithTheCocktailDbResponse();
        drinkWithTheCocktailDbResponse.setDrinks(
                attributeCocktailDbResponses
        );

        List<AtributoDrinkResponse> atritubosDrinkResponse = new ArrayList<>();
        atritubosDrinkResponse.add(new AtributoDrinkResponse("nome", "foto"));
        atritubosDrinkResponse.add(new AtributoDrinkResponse("nome 2", "foto 2"));
        atritubosDrinkResponse.add(new AtributoDrinkResponse("nome 3", "foto 3"));

        DrinkResponse drinkResponse = new DrinkResponse(atritubosDrinkResponse);

//        when(cocktailDbIntegration.getCocktails(anyString())).thenReturn(drinkWithTheCocktailDbResponse);

        when(drinkAdapter.castDrink(any())).thenReturn(drinkResponse);

        drinkAdapter.castDrink(drinkWithTheCocktailDbResponse);

//        verify(cocktailDbIntegration).getCocktails(anyString());
        verify(drinkAdapter).castDrink(any());
    }
}
