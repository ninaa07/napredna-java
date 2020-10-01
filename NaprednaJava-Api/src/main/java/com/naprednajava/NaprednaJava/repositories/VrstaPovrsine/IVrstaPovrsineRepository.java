package com.naprednajava.NaprednaJava.repositories.VrstaPovrsine;

import com.naprednajava.NaprednaJava.models.VrstaPovrsine;

import java.util.List;

public interface IVrstaPovrsineRepository {

    List<VrstaPovrsine> getAll();

    int insert(VrstaPovrsine vrstaPovrsine);

    int update(Integer id, VrstaPovrsine vrstaPovrsine);

    int delete(Integer id);
}
