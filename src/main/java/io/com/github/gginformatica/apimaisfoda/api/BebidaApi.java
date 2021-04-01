package io.com.github.gginformatica.apimaisfoda.api;

import io.com.github.gginformatica.apimaisfoda.domain.BebidaRequest;
import io.com.github.gginformatica.apimaisfoda.domain.BebidaResponse;
import io.com.github.gginformatica.apimaisfoda.service.BebidaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Validated
@RestController
@RequestMapping
public class BebidaApi {

    private final BebidaService bebidaService;

    public BebidaApi(final BebidaService bebidaService) {
        this.bebidaService = bebidaService;
    }

    @GetMapping("/listarBebidas")
    @ResponseStatus(OK)
    public List<BebidaResponse> getTodasBebidas() {
        return bebidaService.getTodasBebidas();
    }

    @GetMapping("/buscarBebida/{bebida}")
    @ResponseStatus(OK)
    public BebidaResponse getBebida(@PathVariable("bebida") String nome) {
        return bebidaService.getBebida(nome);
    }

    @PostMapping("/salvarBebida")
    @ResponseStatus(CREATED)
    public void salvarBebida(@Valid @RequestBody BebidaRequest request) {
        bebidaService.salvarBebida(request);
    }

    @PutMapping("/atualizarBebida/{bebida}")
    @ResponseStatus(OK)
    public void atualizarBebida(
            @PathVariable("bebida") String nome,
            @RequestBody BebidaRequest request
    ) {
        bebidaService.atualizarBebida(nome, request);
    }

    @DeleteMapping("/deletarBebida/{bebida}")
    @ResponseStatus(OK)
    public void deletarBebida(
            @PathVariable("bebida") String nome
    ) {
        bebidaService.deletarBebida(nome);
    }
}
