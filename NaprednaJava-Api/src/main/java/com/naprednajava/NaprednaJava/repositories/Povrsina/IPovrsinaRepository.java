package com.naprednajava.NaprednaJava.repositories.Povrsina;

import com.naprednajava.NaprednaJava.models.Povrsina;

import java.util.List;

public interface IPovrsinaRepository {

    List<Povrsina> getAll();

    int insert(Povrsina povrsina);

    int update(Integer id, Povrsina povrsina);

    int delete(Integer id);
}
