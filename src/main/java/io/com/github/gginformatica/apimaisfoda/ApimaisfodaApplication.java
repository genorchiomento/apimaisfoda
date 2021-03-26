package io.com.github.gginformatica.apimaisfoda;

import io.com.github.gginformatica.apimaisfoda.domain.DrinksWithTheCocktailDbResponse;
import io.com.github.gginformatica.apimaisfoda.integration.TheCocktailDbIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApimaisfodaApplication implements CommandLineRunner {

    @Autowired
    private TheCocktailDbIntegration cocktailApi;

    public static void main(String[] args) {
        SpringApplication.run(ApimaisfodaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> cocktails = cocktailApi.getCocktails();

        cocktails.forEach(v -> {
            //TODO ajustar error e adicionar dep no pom
            System.out.println(v);
        });
    }
}
