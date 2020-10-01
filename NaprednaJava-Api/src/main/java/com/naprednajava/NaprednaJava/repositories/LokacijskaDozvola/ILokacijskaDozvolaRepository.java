package com.naprednajava.NaprednaJava.repositories.LokacijskaDozvola;

import com.naprednajava.NaprednaJava.models.LokacijskaDozvola;

import java.util.List;

public interface ILokacijskaDozvolaRepository {

    List<LokacijskaDozvola> getAll();

    int insert(LokacijskaDozvola lokacijskaDozvola);

    int update(Integer id, LokacijskaDozvola lokacijskaDozvola);

    int delete(Integer id);
}
