package com.naprednajava.NaprednaJava.services.VrstaPovrsine;

import com.naprednajava.NaprednaJava.models.VrstaPovrsine;
import com.naprednajava.NaprednaJava.repositories.VrstaPovrsine.IVrstaPovrsineRepository;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("vrstaPovrsineService")
public class VrstaPovrsineService implements IVrstaPovrsineService {

    private final IVrstaPovrsineRepository vrstaPovrsineRepository;

    public VrstaPovrsineService(@Qualifier("vrstaPovrsine") IVrstaPovrsineRepository vrstaPovrsineRepository) {
        this.vrstaPovrsineRepository = vrstaPovrsineRepository;
    }

    @Override
    public List<VrstaPovrsine> getAll() {
        return vrstaPovrsineRepository.getAll();
    }

    @Override
    public Optional<VrstaPovrsine> getById(Integer id) {
        return vrstaPovrsineRepository.getAll().stream().filter(x -> x.getId() == id).findAny();
    }

    @Override
    public ServiceResult<VrstaPovrsine> insert(VrstaPovrsine vrstaPovrsine) {

        vrstaPovrsineRepository.insert(vrstaPovrsine);

        return new ServiceResult<>(true, "Vrsta povrsine uspesno dodata", vrstaPovrsine);
    }

    @Override
    public ServiceResult<VrstaPovrsine> update(Integer id, VrstaPovrsine vrstaPovrsine) {

        vrstaPovrsineRepository.update(id, vrstaPovrsine);

        return new ServiceResult<>(true, "Vrsta povrsine uspesno izmenjena", vrstaPovrsine);
    }

    @Override
    public ServiceResult<VrstaPovrsine> delete(VrstaPovrsine vrstaPovrsine) {

        vrstaPovrsineRepository.delete(vrstaPovrsine.getId());

        return new ServiceResult<>(true, "Vrsta povrsine uspesno izbrisana", vrstaPovrsine);
    }
}
