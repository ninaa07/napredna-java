package com.naprednajava.NaprednaJava.services.VrstaPovrsine;

import com.naprednajava.NaprednaJava.models.VrstaPovrsine;
import com.naprednajava.NaprednaJava.services.ServiceResult;

import java.util.List;
import java.util.Optional;

public interface IVrstaPovrsineService {

    List<VrstaPovrsine> getAll();

    Optional<VrstaPovrsine> getById(Integer id);

    ServiceResult<VrstaPovrsine> insert(VrstaPovrsine vrstaPovrsine);

    ServiceResult<VrstaPovrsine> update(Integer id, VrstaPovrsine vrstaPovrsine);

    ServiceResult<VrstaPovrsine> delete(VrstaPovrsine vrstaPovrsine);
}
