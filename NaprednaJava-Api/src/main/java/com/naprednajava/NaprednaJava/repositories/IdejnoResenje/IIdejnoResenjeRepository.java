package com.naprednajava.NaprednaJava.repositories.IdejnoResenje;

import com.naprednajava.NaprednaJava.models.IdejnoResenje;

import java.util.List;

public interface IIdejnoResenjeRepository {

    List<IdejnoResenje> getAll();

    int insert(IdejnoResenje idejnoResenje);

    int update(Integer id, IdejnoResenje idejnoResenje);

    int delete(Integer id);
}
