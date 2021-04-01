package io.com.github.gginformatica.apimaisfoda.api;

import io.com.github.gginformatica.apimaisfoda.domain.dto.DrinkResponse;
import io.com.github.gginformatica.apimaisfoda.service.DrinksService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping
public class DrinksApi {
    private final DrinksService drinksService;

    public DrinksApi(final DrinksService drinksService) {
        this.drinksService = drinksService;
    }

    @GetMapping("/drinks/{bebida}")
    @ResponseStatus(OK)
    public DrinkResponse salvaDrink(@PathVariable("bebida") String nome) {
        return drinksService.salvaDrink(nome);
    }
}
