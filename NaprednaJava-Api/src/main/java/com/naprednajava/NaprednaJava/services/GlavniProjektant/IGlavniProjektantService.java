package com.naprednajava.NaprednaJava.services.GlavniProjektant;

import com.naprednajava.NaprednaJava.models.GlavniProjektant;
import com.naprednajava.NaprednaJava.services.ServiceResult;

import java.util.List;
import java.util.Optional;

public interface IGlavniProjektantService {

    List<GlavniProjektant> getAll();

    Optional<GlavniProjektant> getById(Integer id);

    ServiceResult<GlavniProjektant> insert(GlavniProjektant glavniProjektant);

    ServiceResult<GlavniProjektant> update(Integer id, GlavniProjektant glavniProjektant);

    ServiceResult<GlavniProjektant> delete(GlavniProjektant glavniProjektant);
}
