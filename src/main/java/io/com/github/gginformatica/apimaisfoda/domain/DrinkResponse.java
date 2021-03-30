package io.com.github.gginformatica.apimaisfoda.domain;

import java.util.List;

public class DrinkResponse {
    private final List<AtributoDrinkResponse> atritubosDrinkResponse;

    public DrinkResponse(List<AtributoDrinkResponse> atritubosDrinkResponse) {
        this.atritubosDrinkResponse = atritubosDrinkResponse;
    }

    public List<AtributoDrinkResponse> getAtritubosDrinkResponse() {
        return atritubosDrinkResponse;
    }
}