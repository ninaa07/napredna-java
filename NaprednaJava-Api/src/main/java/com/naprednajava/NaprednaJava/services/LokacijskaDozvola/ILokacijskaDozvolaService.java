package com.naprednajava.NaprednaJava.services.LokacijskaDozvola;

import com.naprednajava.NaprednaJava.models.LokacijskaDozvola;
import com.naprednajava.NaprednaJava.services.ServiceResult;

import java.util.List;
import java.util.Optional;

public interface ILokacijskaDozvolaService {

    List<LokacijskaDozvola> getAll();

    Optional<LokacijskaDozvola> getById(Integer id);

    ServiceResult<LokacijskaDozvola> insert(LokacijskaDozvola lokacijskaDozvola);

    ServiceResult<LokacijskaDozvola> update(Integer id, LokacijskaDozvola lokacijskaDozvola);

    ServiceResult<LokacijskaDozvola> delete(LokacijskaDozvola lokacijskaDozvola);
}
