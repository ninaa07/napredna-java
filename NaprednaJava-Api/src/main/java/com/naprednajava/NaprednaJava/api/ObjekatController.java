package com.naprednajava.NaprednaJava.api;


import com.naprednajava.NaprednaJava.models.Objekat;
import com.naprednajava.NaprednaJava.services.Objekat.IObjekatService;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/objekti")
@RestController
public class ObjekatController {

    private final IObjekatService objekatService;

    @Autowired
    public ObjekatController(@Qualifier("objekatService") IObjekatService objekatService) {
        this.objekatService = objekatService;
    }

    @GetMapping
    public List<Objekat> getAll() {
        return objekatService.getAll();
    }

    @GetMapping(path = "{id}")
    public ServiceResult<Objekat> getById(@PathVariable("id") Integer id) {

        var objekat = objekatService.getById(id).orElse(null);

        if (objekat == null)
            return new ServiceResult<>(false, "Objekat nije pronadjen", objekat);

        return new ServiceResult<>(true, "", objekat);
    }

    @PostMapping
    public ServiceResult<Objekat> insert(@Valid @NotNull @RequestBody Objekat objekat) {
        return objekatService.insert(objekat);
    }

    @PutMapping(path = "{id}")
    public ServiceResult<Objekat> update(@PathVariable("id") Integer id, @Valid @NotNull @RequestBody Objekat objekat) {

        var o = objekatService.getById(id).orElse(null);

        if (o == null)
            return new ServiceResult<>(false, "Objekat nije pronadjen", o);

        return objekatService.update(id, objekat);
    }

    @DeleteMapping(path = "{id}")
    public ServiceResult<Objekat> delete(@PathVariable("id") Integer id) {

        var objekat = objekatService.getById(id).orElse(null);

        if (objekat == null)
            return new ServiceResult<>(false, "Objekat nije pronadjen", objekat);

        return objekatService.delete(objekat);
    }
}
