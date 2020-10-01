package com.naprednajava.NaprednaJava.repositories.Prostorija;

import com.naprednajava.NaprednaJava.models.Prostorija;

import java.util.List;

public interface IProstorijaRepository {

    List<Prostorija> getAll();

    int insert(Prostorija prostorija);

    int update(Integer id, Prostorija prostorija);

    int delete(Integer id);
}
