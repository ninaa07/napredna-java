package com.naprednajava.NaprednaJava.services.Objekat;

import com.naprednajava.NaprednaJava.models.Objekat;
import com.naprednajava.NaprednaJava.repositories.Objekat.IObjekatRepository;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("objekatService")
public class ObjekatService implements IObjekatService {

    private final IObjekatRepository objekatRepository;

    public ObjekatService(@Qualifier("objekat") IObjekatRepository objekatRepository) {
        this.objekatRepository = objekatRepository;
    }

    @Override
    public List<Objekat> getAll() {
        return objekatRepository.getAll();
    }

    @Override
    public Optional<Objekat> getById(Integer id) {
        return objekatRepository.getAll().stream().filter(x -> x.getId() == id).findAny();
    }

    @Override
    public ServiceResult<Objekat> insert(Objekat objekat) {

        objekatRepository.insert(objekat);

        return new ServiceResult<>(true, "Objekat uspesno dodat", objekat);
    }

    @Override
    public ServiceResult<Objekat> update(Integer id, Objekat objekat) {

        objekatRepository.update(id, objekat);

        return new ServiceResult<>(true, "Objekat uspesno izmenjen", objekat);
    }

    @Override
    public ServiceResult<Objekat> delete(Objekat objekat) {

        objekatRepository.delete(objekat.getId());

        return new ServiceResult<>(true, "Objekat uspesno izbrisan", objekat);
    }
}
