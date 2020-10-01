package com.naprednajava.NaprednaJava.repositories.InformacijeOLokaciji;

import com.naprednajava.NaprednaJava.models.InformacijeOLokaciji;

import java.util.List;

public interface IInformacijeOLokacijiRepository {

    List<InformacijeOLokaciji> getAll();

    int insert(InformacijeOLokaciji informacijeOLokaciji);

    int update(Integer id, InformacijeOLokaciji informacijeOLokaciji);

    int delete(Integer id);
}
