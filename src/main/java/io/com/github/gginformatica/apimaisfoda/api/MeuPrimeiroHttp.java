package io.com.github.gginformatica.apimaisfoda.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuPrimeiroHttp {

    @GetMapping
    public String retornaHelloWorld() {
        return "Hello World";
    }

    @GetMapping("/genor")
    public String retornaHelloGenor() {
        return "Olá Genor";
    }
}
