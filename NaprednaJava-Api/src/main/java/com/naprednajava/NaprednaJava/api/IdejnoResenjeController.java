package com.naprednajava.NaprednaJava.api;


import com.naprednajava.NaprednaJava.models.IdejnoResenje;
import com.naprednajava.NaprednaJava.services.IdejnoResenje.IIdejnoResenjeService;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/idejnaResenja")
@RestController
public class IdejnoResenjeController {

    private final IIdejnoResenjeService idejnoResenjeService;

    @Autowired
    public IdejnoResenjeController(@Qualifier("idejnoResenjeService") IIdejnoResenjeService idejnoResenjeService) {
        this.idejnoResenjeService = idejnoResenjeService;
    }

    @GetMapping
    public List<IdejnoResenje> getAll() {
        return idejnoResenjeService.getAll();
    }

    @GetMapping(path = "{id}")
    public ServiceResult<IdejnoResenje> getById(@PathVariable("id") Integer id) {

        var idejnoResenje = idejnoResenjeService.getById(id).orElse(null);

        if (idejnoResenje == null)
            return new ServiceResult<>(false, "Idejno resenje nije pronadjeno", idejnoResenje);

        return new ServiceResult<>(true, "", idejnoResenje);
    }

    @PostMapping
    public ServiceResult<IdejnoResenje> insert(@Valid @NotNull @RequestBody IdejnoResenje idejnoResenje) {
        return idejnoResenjeService.insert(idejnoResenje);
    }

    @PutMapping(path = "{id}")
    public ServiceResult<IdejnoResenje> update(@PathVariable("id") Integer id, @Valid @NotNull @RequestBody IdejnoResenje idejnoResenje) {

        var ir = idejnoResenjeService.getById(id).orElse(null);

        if (ir == null)
            return new ServiceResult<>(false, "Idejno resenje nije pronadjeno", ir);

        return idejnoResenjeService.update(id, idejnoResenje);
    }

    @DeleteMapping(path = "{id}")
    public ServiceResult<IdejnoResenje> delete(@PathVariable("id") Integer id) {

        var idejnoResenje = idejnoResenjeService.getById(id).orElse(null);

        if (idejnoResenje == null)
            return new ServiceResult<>(false, "Idejno resenje nije pronadjeno", idejnoResenje);

        return idejnoResenjeService.delete(idejnoResenje);
    }
}
