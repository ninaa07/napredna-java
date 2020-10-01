package com.naprednajava.NaprednaJava.services.Povrsina;

import com.naprednajava.NaprednaJava.models.Povrsina;
import com.naprednajava.NaprednaJava.services.ServiceResult;

import java.util.List;
import java.util.Optional;

public interface IPovrsinaService {

    List<Povrsina> getAll();

    Optional<Povrsina> getById(Integer id);

    ServiceResult<Povrsina> insert(Povrsina povrsina);

    ServiceResult<Povrsina> update(Integer id, Povrsina povrsina);

    ServiceResult<Povrsina> delete(Povrsina povrsina);
}
