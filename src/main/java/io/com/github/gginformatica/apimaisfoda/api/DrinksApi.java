package io.com.github.gginformatica.apimaisfoda.api;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping
public class DrinksApi {

    @PostMapping("/drinks/{bebida}")
    @ResponseStatus(OK)
    public void salvaDrink(@PathVariable("bebida") String nome) {

    }
}
