package com.naprednajava.NaprednaJava.services.ProjekatZaGradjevinskuDozvolu;

import com.naprednajava.NaprednaJava.models.ProjekatZaGradjevinskuDozvolu;
import com.naprednajava.NaprednaJava.repositories.ProjekatZaGradjevinskuDozvolu.IProjekatZaGradjevinskuDozvoluRepository;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("projekatZaGradjevinskuDozvoluService")
public class ProjekatZaGradjevinskuDozvoluService implements IProjekatZaGradjevinskuDozvoluService {

    private final IProjekatZaGradjevinskuDozvoluRepository projekatZaGradjevinskuDozvoluRepository;

    public ProjekatZaGradjevinskuDozvoluService(@Qualifier("projekatZaGradjevinskuDozvolu") IProjekatZaGradjevinskuDozvoluRepository projekatZaGradjevinskuDozvoluRepository) {
        this.projekatZaGradjevinskuDozvoluRepository = projekatZaGradjevinskuDozvoluRepository;
    }

    @Override
    public List<ProjekatZaGradjevinskuDozvolu> getAll() {
        return projekatZaGradjevinskuDozvoluRepository.getAll();
    }

    @Override
    public Optional<ProjekatZaGradjevinskuDozvolu> getById(Integer id) {
        return projekatZaGradjevinskuDozvoluRepository.getAll().stream().filter(x -> x.getId() == id).findAny();
    }

    @Override
    public ServiceResult<ProjekatZaGradjevinskuDozvolu> insert(ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu) {

        var id = projekatZaGradjevinskuDozvoluRepository.insert(projekatZaGradjevinskuDozvolu);

        projekatZaGradjevinskuDozvolu.setId(id);

        return new ServiceResult<>(true, "Projekat za gradjevinsku dozvolu uspesno dodat", projekatZaGradjevinskuDozvolu);
    }

    @Override
    public ServiceResult<ProjekatZaGradjevinskuDozvolu> update(Integer id, ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu) {

        projekatZaGradjevinskuDozvoluRepository.update(id, projekatZaGradjevinskuDozvolu);

        projekatZaGradjevinskuDozvolu.setId(id);

        return new ServiceResult<>(true, "Projekat za gradjevinsku dozvolu uspesno izmenjen", projekatZaGradjevinskuDozvolu);
    }

    @Override
    public ServiceResult<ProjekatZaGradjevinskuDozvolu> delete(ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu) {

        projekatZaGradjevinskuDozvoluRepository.delete(projekatZaGradjevinskuDozvolu.getId());

        return new ServiceResult<>(true, "Projekat za gradjevinsku dozvolu uspesno izbrisan", projekatZaGradjevinskuDozvolu);
    }
}
