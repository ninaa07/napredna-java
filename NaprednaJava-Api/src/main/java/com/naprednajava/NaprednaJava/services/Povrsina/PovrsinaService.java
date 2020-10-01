package com.naprednajava.NaprednaJava.services.Povrsina;

import com.naprednajava.NaprednaJava.models.Povrsina;
import com.naprednajava.NaprednaJava.repositories.Povrsina.IPovrsinaRepository;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("povrsinaService")
public class PovrsinaService implements IPovrsinaService {

    private final IPovrsinaRepository povrsinaRepository;

    public PovrsinaService(@Qualifier("povrsina") IPovrsinaRepository povrsinaRepository) {
        this.povrsinaRepository = povrsinaRepository;
    }

    @Override
    public List<Povrsina> getAll() {
        return povrsinaRepository.getAll();
    }

    @Override
    public Optional<Povrsina> getById(Integer id) {
        return povrsinaRepository.getAll().stream().filter(x -> x.getId() == id).findAny();
    }

    @Override
    public ServiceResult<Povrsina> insert(Povrsina povrsina) {

        var id = povrsinaRepository.insert(povrsina);

        povrsina.setId(id);

        return new ServiceResult<>(true, "Povrsina uspesno dodata", povrsina);
    }

    @Override
    public ServiceResult<Povrsina> update(Integer id, Povrsina povrsina) {

        povrsinaRepository.update(id, povrsina);

        povrsina.setId(id);

        return new ServiceResult<>(true, "Povrsina uspesno izmenjena", povrsina);
    }

    @Override
    public ServiceResult<Povrsina> delete(Povrsina povrsina) {

        povrsinaRepository.delete(povrsina.getId());

        return new ServiceResult<>(true, "Povrsina uspesno izbrisana", povrsina);
    }
}
