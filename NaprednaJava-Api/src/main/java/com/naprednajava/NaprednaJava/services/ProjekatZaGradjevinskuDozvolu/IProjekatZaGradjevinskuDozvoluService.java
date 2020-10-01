package com.naprednajava.NaprednaJava.services.ProjekatZaGradjevinskuDozvolu;

import com.naprednajava.NaprednaJava.models.ProjekatZaGradjevinskuDozvolu;
import com.naprednajava.NaprednaJava.services.ServiceResult;

import java.util.List;
import java.util.Optional;

public interface IProjekatZaGradjevinskuDozvoluService {

    List<ProjekatZaGradjevinskuDozvolu> getAll();

    Optional<ProjekatZaGradjevinskuDozvolu> getById(Integer id);

    ServiceResult<ProjekatZaGradjevinskuDozvolu> insert(ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu);

    ServiceResult<ProjekatZaGradjevinskuDozvolu> update(Integer id, ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu);

    ServiceResult<ProjekatZaGradjevinskuDozvolu> delete(ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu);
}
