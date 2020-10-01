package com.naprednajava.NaprednaJava.services.Objekat;

import com.naprednajava.NaprednaJava.models.Objekat;
import com.naprednajava.NaprednaJava.services.ServiceResult;

import java.util.List;
import java.util.Optional;

public interface IObjekatService {

    List<Objekat> getAll();

    Optional<Objekat> getById(Integer id);

    ServiceResult<Objekat> insert(Objekat objekat);

    ServiceResult<Objekat> update(Integer id, Objekat objekat);

    ServiceResult<Objekat> delete(Objekat objekat);
}
