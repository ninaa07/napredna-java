package com.naprednajava.NaprednaJava.services.Prostorija;

import com.naprednajava.NaprednaJava.models.Prostorija;
import com.naprednajava.NaprednaJava.repositories.Prostorija.IProstorijaRepository;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("prostorijaService")
public class ProstorijaService implements IProstorijaService {

    private final IProstorijaRepository prostorijaRepository;

    public ProstorijaService(@Qualifier("prostorija") IProstorijaRepository prostorijaRepository) {
        this.prostorijaRepository = prostorijaRepository;
    }

    @Override
    public List<Prostorija> getAll() {
        return prostorijaRepository.getAll();
    }

    @Override
    public Optional<Prostorija> getById(Integer id) {
        return prostorijaRepository.getAll().stream().filter(x -> x.getId() == id).findAny();
    }

    @Override
    public ServiceResult<Prostorija> insert(Prostorija prostorija) {

        prostorijaRepository.insert(prostorija);

        return new ServiceResult<>(true, "Prostorija uspesno dodata", prostorija);
    }

    @Override
    public ServiceResult<Prostorija> update(Integer id, Prostorija prostorija) {

        prostorijaRepository.update(id, prostorija);

        return new ServiceResult<>(true, "Prostorija uspesno izmenjena", prostorija);
    }

    @Override
    public ServiceResult<Prostorija> delete(Prostorija prostorija) {

        prostorijaRepository.delete(prostorija.getId());

        return new ServiceResult<>(true, "Prostorija uspesno izbrisana", prostorija);
    }

}
