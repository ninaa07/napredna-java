package com.naprednajava.NaprednaJava.services.Prostorija;

import com.naprednajava.NaprednaJava.models.Prostorija;
import com.naprednajava.NaprednaJava.services.ServiceResult;

import java.util.List;
import java.util.Optional;

public interface IProstorijaService {

    List<Prostorija> getAll();

    Optional<Prostorija> getById(Integer id);

    ServiceResult<Prostorija> insert(Prostorija prostorija);

    ServiceResult<Prostorija> update(Integer id, Prostorija prostorija);

    ServiceResult<Prostorija> delete(Prostorija prostorija);
}
