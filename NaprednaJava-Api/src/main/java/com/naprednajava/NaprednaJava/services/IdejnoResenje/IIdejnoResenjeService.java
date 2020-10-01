package com.naprednajava.NaprednaJava.services.IdejnoResenje;

import com.naprednajava.NaprednaJava.models.IdejnoResenje;
import com.naprednajava.NaprednaJava.services.ServiceResult;

import java.util.List;
import java.util.Optional;

public interface IIdejnoResenjeService {

    List<IdejnoResenje> getAll();

    Optional<IdejnoResenje> getById(Integer id);

    ServiceResult<IdejnoResenje> insert(IdejnoResenje idejnoResenje);

    ServiceResult<IdejnoResenje> update(Integer id, IdejnoResenje idejnoResenje);

    ServiceResult<IdejnoResenje> delete(IdejnoResenje idejnoResenje);
}
