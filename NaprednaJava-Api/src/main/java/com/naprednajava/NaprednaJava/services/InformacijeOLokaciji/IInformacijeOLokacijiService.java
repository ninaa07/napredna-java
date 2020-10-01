package com.naprednajava.NaprednaJava.services.InformacijeOLokaciji;

import com.naprednajava.NaprednaJava.models.InformacijeOLokaciji;
import com.naprednajava.NaprednaJava.services.ServiceResult;

import java.util.List;
import java.util.Optional;

public interface IInformacijeOLokacijiService {

    List<InformacijeOLokaciji> getAll();

    Optional<InformacijeOLokaciji> getById(Integer id);

    ServiceResult<InformacijeOLokaciji> insert(InformacijeOLokaciji informacijeOLokaciji);

    ServiceResult<InformacijeOLokaciji> update(Integer id, InformacijeOLokaciji informacijeOLokaciji);

    ServiceResult<InformacijeOLokaciji> delete(InformacijeOLokaciji informacijeOLokaciji);
}
