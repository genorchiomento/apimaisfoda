package io.com.github.gginformatica.apimaisfoda.api;

import io.com.github.gginformatica.apimaisfoda.domain.BebidaRequest;
import io.com.github.gginformatica.apimaisfoda.domain.BebidaResponse;
import io.com.github.gginformatica.apimaisfoda.exception.InternalServerErrorException;
import io.com.github.gginformatica.apimaisfoda.exception.NotFoundException;
import io.com.github.gginformatica.apimaisfoda.repository.BebidaRepository;
import io.com.github.gginformatica.apimaisfoda.repository.orm.BebidaOrm;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Validated
@RestController
@RequestMapping
public class BebidaApi {

    private final BebidaRepository repository;

    public BebidaApi(final BebidaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/listarBebidas")
    @ResponseStatus(OK)
    public List<BebidaResponse> getTodasBebidas() {
        try {
            List<BebidaOrm> list = repository.findAll();
            if (list.isEmpty()) {
                throw new NotFoundException("Não há bebidas");
            }

            List<BebidaResponse> response = new ArrayList<>();
            list.forEach(bebidaOrm -> {
                BebidaResponse bebidaResponse = new BebidaResponse();
                bebidaResponse.setNome(bebidaOrm.getNome());
                bebidaResponse.setCategoria(bebidaOrm.getCategoria());
                bebidaResponse.setAnoLancamento(bebidaOrm.getAnoLancamento());

                response.add(bebidaResponse);
            });

            return response;
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }

    @GetMapping("/buscarBebida/{bebida}")
    @ResponseStatus(OK)
    public BebidaResponse getBebida(@PathVariable("bebida") String nome) {
        try {
            BebidaOrm bebidaOrm = repository.findByNome(nome.toUpperCase());

            if (bebidaOrm == null) {
                throw new NotFoundException("Bebida não existe");
            }

            BebidaResponse bebidaResponse = new BebidaResponse();
            bebidaResponse.setNome(bebidaOrm.getNome());
            bebidaResponse.setCategoria(bebidaOrm.getCategoria());
            bebidaResponse.setAnoLancamento(bebidaOrm.getAnoLancamento());

            return bebidaResponse;
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }

    @PostMapping("/salvarBebida")
    @ResponseStatus(CREATED)
    public void salvarBebida(@Valid @RequestBody BebidaRequest request) {
        try {
            BebidaOrm orm = new BebidaOrm();
            orm.setId(UUID.randomUUID().toString());
            orm.setNome(request.getNome().toUpperCase());
            orm.setCategoria(request.getCategoria());
            orm.setAnoLancamento(request.getAnoLancamento());

            repository.save(orm);
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }

    }

    @PutMapping("/atualizarBebida/{bebida}")
    @ResponseStatus(OK)
    public void atualizarBebida(
            @PathVariable("bebida") String nome,
            @RequestBody BebidaRequest request
    ) {
        try {
            BebidaOrm bebidaOrm = repository.findByNome(nome);

            if (bebidaOrm == null) {
                throw new NotFoundException("Bebida não encontrada");
            }

            BebidaOrm orm = new BebidaOrm();
            orm.setId(bebidaOrm.getId());
            orm.setNome(request.getNome().toUpperCase());
            orm.setCategoria(request.getCategoria());
            orm.setAnoLancamento(request.getAnoLancamento());

            repository.save(orm);
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }

    @DeleteMapping("/deletarBebida/{bebida}")
    @ResponseStatus(OK)
    public void deletarBebida(
            @PathVariable("bebida") String nome
    ) {
        try {
            BebidaOrm bebidaOrm = repository.findByNome(nome);

            if (bebidaOrm == null) {
                throw new NotFoundException("Bebida não encontrada");
            }

            repository.delete(bebidaOrm);
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }
}
