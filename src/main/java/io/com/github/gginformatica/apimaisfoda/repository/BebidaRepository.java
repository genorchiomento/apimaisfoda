package io.com.github.gginformatica.apimaisfoda.repository;

import io.com.github.gginformatica.apimaisfoda.repository.orm.BebidaOrm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BebidaRepository extends MongoRepository<BebidaOrm, String> {

    BebidaOrm findByNome(String nome);
}
