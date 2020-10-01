package com.naprednajava.NaprednaJava.repositories.Objekat;

import com.naprednajava.NaprednaJava.models.Objekat;

import java.util.List;

public interface IObjekatRepository {

    List<Objekat> getAll();

    int insert(Objekat objekat);

    int update(Integer id, Objekat objekat);

    int delete(Integer id);
}
