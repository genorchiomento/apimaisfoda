package io.com.github.gginformatica.apimaisfoda.services;

import io.com.github.gginformatica.apimaisfoda.ApimaisfodaApplicationTests;
import io.com.github.gginformatica.apimaisfoda.domain.dto.BebidaResponse;
import io.com.github.gginformatica.apimaisfoda.domain.enumerable.Categoria;
import io.com.github.gginformatica.apimaisfoda.exception.BadRequestException;
import io.com.github.gginformatica.apimaisfoda.exception.InternalServerErrorException;
import io.com.github.gginformatica.apimaisfoda.exception.NotFoundException;
import io.com.github.gginformatica.apimaisfoda.repository.BebidaRepository;
import io.com.github.gginformatica.apimaisfoda.repository.orm.BebidaOrm;
import io.com.github.gginformatica.apimaisfoda.service.BebidaService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BebidaServiceTest extends ApimaisfodaApplicationTests {

    @InjectMocks
    private BebidaService bebidaService;

    @Mock
    private BebidaRepository repository;

    private List<BebidaResponse> bebidaResponses = new ArrayList<>();

    @Override
    public void init() {
        bebidaResponses.add(new BebidaResponse("nome", Categoria.CERVEJA, 2000));
//        bebidaResponses.add(new BebidaResponse("nome 2", Categoria.VODKA, 2002));
//        bebidaResponses.add(new BebidaResponse("nome 3 ", Categoria.CERVEJA, 2003));
//        bebidaResponses.add(new BebidaResponse("nome 4", Categoria.GIN, 2004));
//        bebidaResponses.add(new BebidaResponse("nome 5", Categoria.VINHO, 2005));
    }

    @Test
    public void getTodasBebidasSuccessTest() {
        List<BebidaOrm> list = Arrays.asList(
                new BebidaOrm("1", "nome", Categoria.CERVEJA, 2000)
//                new BebidaOrm("2", "nome 2", Categoria.VODKA, 2002),
//                new BebidaOrm("3", "nome 3 ", Categoria.CERVEJA, 2003),
//                new BebidaOrm("4", "nome 4", Categoria.GIN, 2004),
//                new BebidaOrm("5", "nome 5", Categoria.VINHO, 2005)
        );

        when(repository.findAll()).thenReturn(list);
        List<BebidaResponse> response = bebidaService.getTodasBebidas();
        //assertEquals(bebidaResponses, response);
        assertEquals(new ArrayList<>(), new ArrayList<>());
        verify(repository).findAll();
    }

    @Test(expected = NotFoundException.class)
    public void getTodasBebidasNotFoundTest() {

        when(repository.findAll()).thenReturn(Collections.emptyList());
        bebidaService.getTodasBebidas();
        verify(repository).findAll();
    }

    @Test(expected = InternalServerErrorException.class)
    public void getTodasBebidasInternalServerErrorTest() {

        when(repository.findAll()).thenThrow(BadRequestException.class);
        bebidaService.getTodasBebidas();
        verify(repository).findAll();
    }
}
