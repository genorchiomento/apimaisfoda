package io.com.github.gginformatica.apimaisfoda.service;

import io.com.github.gginformatica.apimaisfoda.domain.BebidaRequest;
import io.com.github.gginformatica.apimaisfoda.domain.BebidaResponse;
import io.com.github.gginformatica.apimaisfoda.exception.InternalServerErrorException;
import io.com.github.gginformatica.apimaisfoda.exception.NotFoundException;
import io.com.github.gginformatica.apimaisfoda.repository.BebidaRepository;
import io.com.github.gginformatica.apimaisfoda.repository.orm.BebidaOrm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BebidaService {

    private final BebidaRepository repository;

    public BebidaService(final BebidaRepository repository) {
        this.repository = repository;
    }

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

        } catch (NotFoundException notFoundException) {
            throw notFoundException;
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }

    public BebidaResponse getBebida(final String nome) {
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

        } catch (NotFoundException notFoundException) {
            throw notFoundException;
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }

    public void salvarBebida(final BebidaRequest request) {
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

    public void atualizarBebida(final String nome, final BebidaRequest request
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

        } catch (NotFoundException notFoundException) {
            throw notFoundException;
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }

    public void deletarBebida(final String nome) {
        try {
            BebidaOrm bebidaOrm = repository.findByNome(nome);

            if (bebidaOrm == null) {
                throw new NotFoundException("Bebida não encontrada");
            }

            repository.delete(bebidaOrm);

        } catch (NotFoundException notFoundException) {
            throw notFoundException;
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }
}
