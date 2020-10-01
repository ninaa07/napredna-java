package com.naprednajava.NaprednaJava.repositories.GlavniProjektant;

import com.naprednajava.NaprednaJava.models.GlavniProjektant;

import java.util.List;

public interface IGlavniProjektantRepository {

    List<GlavniProjektant> getAll();

    int insert(GlavniProjektant glavniProjektant);

    int update(Integer id, GlavniProjektant glavniProjektant);

    int delete(Integer id);
}
