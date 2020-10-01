package com.naprednajava.NaprednaJava.services.GlavniProjektant;

import com.naprednajava.NaprednaJava.models.GlavniProjektant;
import com.naprednajava.NaprednaJava.repositories.GlavniProjektant.IGlavniProjektantRepository;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("glavniProjektantService")
public class GlavniProjektantService implements IGlavniProjektantService {

    private final IGlavniProjektantRepository glavniProjektantRepository;

    @Autowired
    public GlavniProjektantService(@Qualifier("glavniProjektant") IGlavniProjektantRepository glavniProjektantRepository) {
        this.glavniProjektantRepository = glavniProjektantRepository;
    }

    @Override
    public List<GlavniProjektant> getAll() {
        return glavniProjektantRepository.getAll();
    }

    @Override
    public Optional<GlavniProjektant> getById(Integer id) {
        return glavniProjektantRepository.getAll().stream().filter(x -> x.getId() == id).findAny();
    }

    @Override
    public ServiceResult<GlavniProjektant> insert(GlavniProjektant glavniProjektant) {

        glavniProjektantRepository.insert(glavniProjektant);

        return new ServiceResult<>(true, "Glavni projektant uspesno dodat", glavniProjektant);
    }

    @Override
    public ServiceResult<GlavniProjektant> update(Integer id, GlavniProjektant glavniProjektant) {

        glavniProjektantRepository.update(id, glavniProjektant);

        return new ServiceResult<>(true, "Glavni projektant uspesno izmenjen", glavniProjektant);
    }

    @Override
    public ServiceResult<GlavniProjektant> delete(GlavniProjektant glavniProjektant) {

        glavniProjektantRepository.delete(glavniProjektant.getId());

        return new ServiceResult<>(true, "Glavni projektant uspesno izbrisan", glavniProjektant);
    }
}
