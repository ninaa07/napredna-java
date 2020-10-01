package com.naprednajava.NaprednaJava.services.LokacijskaDozvola;

import com.naprednajava.NaprednaJava.models.LokacijskaDozvola;
import com.naprednajava.NaprednaJava.repositories.LokacijskaDozvola.ILokacijskaDozvolaRepository;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("lokacijskaDozvolaService")
public class LokacijskaDozvolaService implements ILokacijskaDozvolaService {

    private final ILokacijskaDozvolaRepository lokacijskaDozvolaRepository;

    public LokacijskaDozvolaService(@Qualifier("lokacijskaDozvola") ILokacijskaDozvolaRepository lokacijskaDozvolaRepository) {
        this.lokacijskaDozvolaRepository = lokacijskaDozvolaRepository;
    }

    @Override
    public List<LokacijskaDozvola> getAll() {
        return lokacijskaDozvolaRepository.getAll();
    }

    @Override
    public Optional<LokacijskaDozvola> getById(Integer id) {
        return lokacijskaDozvolaRepository.getAll().stream().filter(x -> x.getId() == id).findAny();
    }

    @Override
    public ServiceResult<LokacijskaDozvola> insert(LokacijskaDozvola lokacijskaDozvola) {

        var id = lokacijskaDozvolaRepository.insert(lokacijskaDozvola);

        lokacijskaDozvola.setId(id);

        return new ServiceResult<>(true, "Lokacijska dozvola uspesno dodata", lokacijskaDozvola);
    }

    @Override
    public ServiceResult<LokacijskaDozvola> update(Integer id, LokacijskaDozvola lokacijskaDozvola) {

        lokacijskaDozvolaRepository.update(id, lokacijskaDozvola);

        lokacijskaDozvola.setId(id);

        return new ServiceResult<>(true, "Lokacijska dozvola uspesno izmenjena", lokacijskaDozvola);
    }

    @Override
    public ServiceResult<LokacijskaDozvola> delete(LokacijskaDozvola lokacijskaDozvola) {

        lokacijskaDozvolaRepository.delete(lokacijskaDozvola.getId());

        return new ServiceResult<>(true, "Lokacijska dozvola uspesno izbrisana", lokacijskaDozvola);
    }
}
