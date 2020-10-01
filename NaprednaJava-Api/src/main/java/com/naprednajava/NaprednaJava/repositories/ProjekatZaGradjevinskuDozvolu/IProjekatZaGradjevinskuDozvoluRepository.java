package com.naprednajava.NaprednaJava.repositories.ProjekatZaGradjevinskuDozvolu;

import com.naprednajava.NaprednaJava.models.ProjekatZaGradjevinskuDozvolu;

import java.util.List;

public interface IProjekatZaGradjevinskuDozvoluRepository {

    List<ProjekatZaGradjevinskuDozvolu> getAll();

    int insert(ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu);

    int update(Integer id, ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu);

    int delete(Integer id);
}
