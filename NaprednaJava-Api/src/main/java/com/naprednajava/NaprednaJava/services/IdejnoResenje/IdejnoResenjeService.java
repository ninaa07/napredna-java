package com.naprednajava.NaprednaJava.services.IdejnoResenje;

import com.naprednajava.NaprednaJava.models.IdejnoResenje;
import com.naprednajava.NaprednaJava.repositories.IdejnoResenje.IIdejnoResenjeRepository;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("idejnoResenjeService")
public class IdejnoResenjeService implements IIdejnoResenjeService {

    private final IIdejnoResenjeRepository idejnoResenjeRepository;

    public IdejnoResenjeService(@Qualifier("idejnoResenje") IIdejnoResenjeRepository idejnoResenjeRepository) {
        this.idejnoResenjeRepository = idejnoResenjeRepository;
    }

    @Override
    public List<IdejnoResenje> getAll() {
        return idejnoResenjeRepository.getAll();
    }

    @Override
    public Optional<IdejnoResenje> getById(Integer id) {
        return idejnoResenjeRepository.getAll().stream().filter(x -> x.getId() == id).findAny();
    }

    @Override
    public ServiceResult<IdejnoResenje> insert(IdejnoResenje idejnoResenje) {

        idejnoResenjeRepository.insert(idejnoResenje);

        return new ServiceResult<>(true, "Idejno resenje uspesno dodato", idejnoResenje);
    }

    @Override
    public ServiceResult<IdejnoResenje> update(Integer id, IdejnoResenje idejnoResenje) {

        idejnoResenjeRepository.update(id, idejnoResenje);

        return new ServiceResult<>(true, "Idejno resenje uspesno izmenjeno", idejnoResenje);
    }

    @Override
    public ServiceResult<IdejnoResenje> delete(IdejnoResenje idejnoResenje) {

        idejnoResenjeRepository.delete(idejnoResenje.getId());

        return new ServiceResult<>(true, "Idejno resenje uspesno izbrisano", idejnoResenje);
    }
}
