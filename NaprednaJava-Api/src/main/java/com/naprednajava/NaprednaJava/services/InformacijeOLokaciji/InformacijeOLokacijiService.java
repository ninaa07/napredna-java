package com.naprednajava.NaprednaJava.services.InformacijeOLokaciji;

import com.naprednajava.NaprednaJava.models.InformacijeOLokaciji;
import com.naprednajava.NaprednaJava.repositories.InformacijeOLokaciji.IInformacijeOLokacijiRepository;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("informacijeOLokacijiService")
public class InformacijeOLokacijiService implements IInformacijeOLokacijiService {

    private final IInformacijeOLokacijiRepository informacijeOLokacijiRepository;

    public InformacijeOLokacijiService(@Qualifier("informacijeOLokaciji") IInformacijeOLokacijiRepository informacijeOLokacijiRepository) {
        this.informacijeOLokacijiRepository = informacijeOLokacijiRepository;
    }

    @Override
    public List<InformacijeOLokaciji> getAll() {
        return informacijeOLokacijiRepository.getAll();
    }

    @Override
    public Optional<InformacijeOLokaciji> getById(Integer id) {
        return informacijeOLokacijiRepository.getAll().stream().filter(x -> x.getId() == id).findAny();
    }

    @Override
    public ServiceResult<InformacijeOLokaciji> insert(InformacijeOLokaciji informacijeOLokaciji) {

        informacijeOLokacijiRepository.insert(informacijeOLokaciji);

        return new ServiceResult<>(true, "Informacije o lokaciji uspesno dodate", informacijeOLokaciji);
    }

    @Override
    public ServiceResult<InformacijeOLokaciji> update(Integer id, InformacijeOLokaciji informacijeOLokaciji) {

        informacijeOLokacijiRepository.update(id, informacijeOLokaciji);

        return new ServiceResult<>(true, "Informacije o lokaciji uspesno izmenjene", informacijeOLokaciji);
    }

    @Override
    public ServiceResult<InformacijeOLokaciji> delete(InformacijeOLokaciji informacijeOLokaciji) {

        informacijeOLokacijiRepository.delete(informacijeOLokaciji.getId());

        return new ServiceResult<>(true, "Informacije o lokaciji uspesno izbrisane", informacijeOLokaciji);
    }
}
